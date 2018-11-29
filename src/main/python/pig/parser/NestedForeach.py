from Node import Node
from Group import Group
from Assign import Assign
from Flatten import Flatten
from SimpleRelation import SimpleRelation
from Aggregation import Aggregation
from Field import Field


class NestedForeach(Node):
	def __init__(self, src, nested_commands, generate_items):
		self.src = src
		self.nested_commands = nested_commands
		self.generate_items = generate_items
		self.fields = []
		self.type = "NESTED_FOREACH"
		self.children = [src, nested_commands, generate_items]
		self.spark_code = []

	def is_relation_op(self):
		return True

	def __str__(self):
		return "FOREACH:%s = for %s, generate:%s" % (self.target, self.src, ", ".join(map(str, self.genItems)))

	def to_spark(self, exec_context):
		target = exec_context.params["target"].to_spark(exec_context)

		assert isinstance(self.src.expr, Group)
		exec_context.params["group_by"] = self.src.expr

		for nested_command in self.nested_commands:
			assert isinstance(nested_command, Assign)
			expr = nested_command.children[1]

			if expr.is_relation_op():
				relation_name = nested_command.children[0].name
				generated_code = nested_command.to_spark(exec_context)

				if isinstance(generated_code, list):
					for item in generated_code:
						self.spark_code.append(item)
				else:
					self.spark_code.append(generated_code)

				exec_context.relation_map[relation_name] = exec_context.last_relation["fields"]
				exec_context.last_relation["name"] = relation_name
			else:
				pass

		generate_items = []

		for generate_item in self.generate_items:
			if isinstance(generate_item, Flatten):
				flatten_generate_fields = generate_item.transform()
				generate_items += flatten_generate_fields
			else:
				generate_items.append(generate_item)

		items = []

		aggregation_items = []
		not_aggregation_items = []

		for generate_item in generate_items:
			items.append(generate_item.to_spark(exec_context))

			if generate_item.contains_aggregation():
				aggregation_items.append(generate_item.to_spark(exec_context))
			else:
				not_aggregation_items.append(generate_item.to_spark(exec_context))

			if isinstance(generate_item, Field):
				self.fields.append(generate_item)
			else:
				self.fields.append(generate_item.name)

		if exec_context.last_relation.get("name") is not None:
			src = exec_context.last_relation.get("name")
		else:
			src = self.src.expr.relation.to_spark(exec_context)

		if not aggregation_items:
			self.spark_code.append("%s = %s.select(%s)" % (target, src, ", ".join(not_aggregation_items)))
		else:
			self.spark_code.append("%s = %s.groupby(%s).agg(%s)" % (target, src, ", ".join(not_aggregation_items), ", ".join(aggregation_items)))

		return "\n".join(self.spark_code)
