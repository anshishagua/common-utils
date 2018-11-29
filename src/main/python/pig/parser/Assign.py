from Node import Node


class Assign(Node):
    def __init__(self, target, expr):
        self.target = target
        self.expr = expr
        self.children = [expr]
        self.type = "ASSIGN"

    def __str__(self):
        return "ASSIGN:%s = %s" % (self.target, self.expr)

    def is_relation_op(self):
        return self.expr.is_relation_op()

    def to_spark(self, exec_context):
        target = self.target.to_spark(exec_context) if isinstance(self.target, Node) else self.target

        if self.expr.type == "NESTED_FOREACH":
            exec_context.params["target"] = self.target
            exec_context.relation_map[target] = self.expr.fields

            return self.expr.to_spark(exec_context)

        expr = self.expr.to_spark(exec_context)

        generated_code = []

        if isinstance(expr, list):
            for i in range(len(expr)):
                if i != (len(expr) - 1):
                    generated_code.append(expr[i])
                else:
                    generated_code.append("%s = %s" % (target, expr[i]))
        else:
            generated_code.append("%s = %s" % (target, expr))

        exec_context.relation_map[target] = self.expr.fields

        #return "%s = %s" % (target, expr)
        return generated_code