from pig.generated.PigVisitor import PigVisitor

from Load import Load
from Program import Program
from Store import Store
from Set import Set
from Register import Register
from Filter import Filter
from Or import Or
from And import And
from Not import Not
from IsNotNull import IsNotNull
from IsNull import IsNull
from In import In
from Compare import Compare
from Plus import Plus
from Minus import Minus
from Multiply import Multiply
from Divide import Divide
from Mod import Mod
from Number import Number
from String import String
from Function import Function
from Cast import Cast
from Field import Field, ALL_FIELD
from SimpleRelation import SimpleRelation
from CaseWhen import CaseWhen
from Paren import Paren
from Union import Union
from Distinct import Distinct
from ConditionExpr import ConditionExpr
from ConditionExpr import ConditionExpr
from Null import Null
from Boolean import Boolean
from ConditionCase import ConditionCase
from ValueCase import ValueCase
from FieldRange import FieldRange
from Alias import Alias
from Join import Join, JoinItem
from Group import Group
from ComplexRelation import ComplexRelation
from Assign import Assign
from Flatten import Flatten
from Generate import Genereate
from Split import Split
from Aggregation import Aggregation
from Cube import Cube
from Set import Set
from SimpleForeach import SimpleForeach
from NestedForeach import NestedForeach
from ParamVar import ParamVar
from Define import Define


class PigNewVisitor(PigVisitor):
    # Visit a parse tree produced by PigParser#program.
    def visitProgram(self, ctx):
        statements = []

        for context in ctx.statement():
            statements.append(self.visit(context))

        return Program(statements)


    # Visit a parse tree produced by PigParser#statement.
    def visitStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#op_clause.
    def visitOp_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#cube_statement.
    """cube_statement : IDENTIFIER ASSIGN cube_clause SEMI_COLON?;"""
    def visitCube_statement(self, ctx):
        target = SimpleRelation(ctx.IDENTIFIER().getText())

        src, rollup_list = self.visit(ctx.cube_clause())

        return Cube(target, src, rollup_list)


    # Visit a parse tree produced by PigParser#cube_clause.
    """cube_clause : CUBE rel BY cube_rollup_list (COMMA cube_rollup_list)*;"""
    def visitCube_clause(self, ctx):
        src = self.visit(ctx.rel())

        rollup_list = []

        for context in ctx.cube_rollup_list():
            rollup_list.append(self.visit(context))

        return src, rollup_list[0]


    # Visit a parse tree produced by PigParser#cube_rollup_list.
    """cube_rollup_list : ( CUBE | ROLLUP ) LEFT_PAREN real_arg (COMMA real_arg )* RIGHT_PAREN;"""
    def visitCube_rollup_list(self, ctx):
        rollup_list = []

        for context in ctx.real_arg():
            rollup_list.append(self.visit(context))

        return rollup_list


    # Visit a parse tree produced by PigParser#define_statement.
    def visitDefine_statement(self, ctx):
        variable = ctx.IDENTIFIER()
        expr = self.visit(ctx.func_call())

        return Define(variable, expr)


    # Visit a parse tree produced by PigParser#split_statement.
    def visitSplit_statement(self, ctx):
        return self.visit(ctx.split_clause())

    """split_clause: SPLIT rel INTO split_branch (COMMA split_branch)* split_otherwise?;"""
    # Visit a parse tree produced by PigParser#split_clause.
    def visitSplit_clause(self, ctx):
        src = self.visit(ctx.rel())

        targets = []
        conditions = []

        for context in ctx.split_branch():
            target, condition = self.visit(context)

            conditions.append(condition)
            targets.append(target)

        if ctx.split_otherwise() is not None:
            otherwise = self.visit(ctx.split_otherwise())
            targets.append(otherwise)

        return Split(src, conditions, targets)

    """split_branch : IDENTIFIER IF ((LEFT_PAREN expr RIGHT_PAREN) | expr);"""
    # Visit a parse tree produced by PigParser#split_branch.
    def visitSplit_branch(self, ctx):
        relation = SimpleRelation(ctx.IDENTIFIER().getText())
        condition = self.visit(ctx.expr())

        return relation, condition


    # Visit a parse tree produced by PigParser#split_otherwise.
    def visitSplit_otherwise(self, ctx):
        return SimpleRelation(ctx.IDENTIFIER())


    # Visit a parse tree produced by PigParser#register_statement.
    def visitRegister_statement(self, ctx):
        return self.visit(ctx.register_clause())

    """register_clause: REGISTER register_file (USING class_name)? (AS IDENTIFIER)?;"""
    # Visit a parse tree produced by PigParser#register_clause.
    def visitRegister_clause(self, ctx):
        register_file = ctx.register_file().getText()
        alias = None

        if ctx.IDENTIFIER() is not None:
            alias = ctx.IDENTIFIER().getText()

        return Register(register_file, alias)


    # Visit a parse tree produced by PigParser#register_file.
    def visitRegister_file(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#field.
    def visitField(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#field_definetion.
    def visitField_definetion(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#function.
    def visitFunction(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#set_statement.
    def visitSet_statement(self, ctx):
        key, value = self.visit(ctx.set_clause())

        return Set(key, value)

    """set_clause: SET class_name property_value;"""
    # Visit a parse tree produced by PigParser#set_clause.
    def visitSet_clause(self, ctx):
        return self.visit(ctx.class_name()), self.visit(ctx.property_value())


    # Visit a parse tree produced by PigParser#property_value.
    def visitProperty_value(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#load_statement.
    def visitLoad_statement(self, ctx):
        target = SimpleRelation(ctx.IDENTIFIER().getText())

        load_clause = self.visit(ctx.load_clause())

        return Assign(target, load_clause)

    """load_clause: LOAD PARAM_PATTERN directory PARAM_PATTERN (USING function)?"""
    # Visit a parse tree produced by PigParser#load_clause.
    def visitLoad_clause(self, ctx):
        return Load(ctx.directory().getText())


    # Visit a parse tree produced by PigParser#foreach_statement.
    def visitForeach_statement(self, ctx):
        target = SimpleRelation(ctx.IDENTIFIER().getText())

        foreach = self.visit(ctx.foreach_clause())

        return Assign(target, foreach)

    """foreach_clause: FOREACH rel (foreach_plan_complex | ( foreach_generate_simple parallel_clause?));"""
    # Visit a parse tree produced by PigParser#foreach_clause.
    def visitForeach_clause(self, ctx):
        src = self.visit(ctx.rel())

        foreach = None

        if ctx.foreach_generate_simple() is not None:
            generate_items = self.visit(ctx.foreach_generate_simple())

            foreach = SimpleForeach(src, generate_items)
        else:
            nested_commands, generate_items = self.visit(ctx.foreach_plan_complex())

            foreach = NestedForeach(src, nested_commands, generate_items)

        return foreach

    """foreach_generate_simple : GENERATE flatten_generated_item (COMMA flatten_generated_item )*;"""
    # Visit a parse tree produced by PigParser#foreach_generate_simple.
    def visitForeach_generate_simple(self, ctx):
        items = []

        for context in ctx.flatten_generated_item():
            items.append(self.visit(context))

        return items


    # Visit a parse tree produced by PigParser#foreach_plan_complex.
    """foreach_plan_complex : LEFT_BRACE nested_blk RIGHT_BRACE;"""
    def visitForeach_plan_complex(self, ctx):
        return self.visit(ctx.nested_blk())


    """flatten_generated_item: flatten_clause generate_as_clause? 
            | real_arg generate_as_clause?;
    """
    # Visit a parse tree produced by PigParser#flatten_generated_item.
    def visitFlatten_generated_item(self, ctx):
        arg = None

        if ctx.real_arg() is not None:
            arg = self.visit(ctx.real_arg())

            alias = None
            if ctx.generate_as_clause() is not None:
                alias = self.visit(ctx.generate_as_clause())

            if alias is not None:
                if alias.type == "CAST":
                    cast = Cast(alias.data_type, arg)
                    return Alias(alias.expression, cast)
                else:
                    return Alias(alias, arg)

            return arg
        else:
            flatten = self.visit(ctx.flatten_clause())

            as_fields = None
            if ctx.generate_as_clause() is not None:
                as_fields = self.visit(ctx.generate_as_clause())

            flatten.as_fields = as_fields

            return flatten

        #return self.visitChildren(ctx)

    """generate_as_clause : AS ( (LEFT_PAREN field_def_list RIGHT_PAREN) 
    | explicit_field_def );
    """
    # Visit a parse tree produced by PigParser#generate_as_clause.
    def visitGenerate_as_clause(self, ctx):
        if ctx.explicit_field_def() is not None:
            return self.visit(ctx.explicit_field_def())
        else:
            return self.visit(ctx.field_def_list())

    """field_def_list : field_def (COMMA field_def )*;"""
    # Visit a parse tree produced by PigParser#field_def_list.
    def visitField_def_list(self, ctx):
        fields = []

        for context in ctx.field_def():
            fields.append(self.visit(context))

        return fields

    # Visit a parse tree produced by PigParser#field_def.
    def visitField_def(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#explicit_field_def.
    def visitExplicit_field_def(self, ctx):
        if ctx.IDENTIFIER() is not None:
            field = Field(ctx.IDENTIFIER().getText())

            if ctx.data_type() is not None:
                dataType = self.visit(ctx.data_type())
                return Cast(dataType, field)
            else:
                return field

        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#data_type.
    def visitData_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#implicit_type.
    def visitImplicit_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#explicit_type.
    def visitExplicit_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#simple_type.
    def visitSimple_type(self, ctx):
        return ctx.getText()


    # Visit a parse tree produced by PigParser#explicit_tuple_type.
    def visitExplicit_tuple_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#implicit_tuple_type.
    def visitImplicit_tuple_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#explicit_bag_type.
    def visitExplicit_bag_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#implicit_bag_type.
    def visitImplicit_bag_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#tuple_type.
    def visitTuple_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#explicit_map_type.
    def visitExplicit_map_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#implicit_map_type.
    def visitImplicit_map_type(self, ctx):
        return self.visitChildren(ctx)

    """flatten_clause: FLATTEN LEFT_PAREN expr RIGHT_PAREN;"""
    # Visit a parse tree produced by PigParser#flatten_clause.
    def visitFlatten_clause(self, ctx):
        expr = self.visit(ctx.expr())

        return Flatten(expr)

    """nested_blk : (nested_command SEMI_COLON)* GENERATE flatten_generated_item (COMMA flatten_generated_item )* SEMI_COLON;"""
    # Visit a parse tree produced by PigParser#nested_blk.
    def visitNested_blk(self, ctx):
        nested_commands = []

        for context in ctx.nested_command():
            nested_commands.append(self.visit(context))

        items = []

        for context in ctx.flatten_generated_item():
            items.append(self.visit(context))

        return nested_commands, items


    """nested_command : IDENTIFIER ASSIGN expr | IDENTIFIER ASSIGN nested_op;"""
    # Visit a parse tree produced by PigParser#nested_command.
    def visitNested_command(self, ctx):
        target = ctx.IDENTIFIER().getText()

        expression = None

        if ctx.expr() is not None:
            expression = self.visit(ctx.expr())
        else:
            expression = self.visit(ctx.nested_op())

        if expression.is_relation_op():
            target = SimpleRelation(target)
        else:
            target = Field(target)

        return Assign(target, expression)

    """
nested_op : nested_filter
          | nested_sort
          | nested_distinct
          | nested_limit
          | nested_cross
          | nested_foreach;
    """
    # Visit a parse tree produced by PigParser#nested_op.
    def visitNested_op(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_foreach.
    def visitNested_foreach(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_cross.
    def visitNested_cross(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_op_input_list.
    def visitNested_op_input_list(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_limit.
    def visitNested_limit(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_distinct.
    def visitNested_distinct(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_sort.
    def visitNested_sort(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#order_by_clause.
    def visitOrder_by_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#order_col_list.
    def visitOrder_col_list(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#order_col.
    def visitOrder_col(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#col_range.
    """col_range : col_ref op='..' col_ref? | op='..' col_ref;"""
    def visitCol_range(self, ctx):
        if ctx.children[0].getText() == '..':
            start = int(self.visit(ctx.col_ref()[0])[1:])

            end = -1 if len(ctx.col_ref()) == 1 else int(self.visit(ctx.col_ref()[1])[1:])
        else:
            start = int(self.visit(ctx.col_ref()[0])[1:])
            end = -1

            if len(ctx.col_ref()) == 2:
                end = int(self.visit(ctx.col_ref()[1])[1:])

        return FieldRange(start, end)

    """
        nested_filter : FILTER nested_op_input BY expr;
    """
    # Visit a parse tree produced by PigParser#nested_filter.
    def visitNested_filter(self, ctx):
        src = self.visit(ctx.nested_op_input())

        condition = self.visit(ctx.expr())

        return Filter(src, condition)

    """
        nested_op_input : col_ref | nested_proj;
    """
    # Visit a parse tree produced by PigParser#nested_op_input.
    def visitNested_op_input(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#col_ref.
    def visitCol_ref(self, ctx):
        if ctx.IDENTIFIER() is not None:
            return ctx.IDENTIFIER().getText()
        else:
            return ctx.DOLLAR_VAR().getText()

    """nested_proj: col_ref '.' col_ref_list;"""
    # Visit a parse tree produced by PigParser#nested_proj.
    def visitNested_proj(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#col_ref_list.
    def visitCol_ref_list(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#store_statement.
    def visitStore_statement(self, ctx):
        return self.visit(ctx.store_clause())


    # Visit a parse tree produced by PigParser#store_clause.
    def visitStore_clause(self, ctx):
        relation = ctx.IDENTIFIER().getText()
        directory = self.visit(ctx.directory())

        return Store(relation, directory)


    # Visit a parse tree produced by PigParser#distinct_statement.
    def visitDistinct_statement(self, ctx):
        target = ctx.IDENTIFIER().getText()
        src = self.visit(ctx.distinct_clause())

        return Distinct(src, target)


    # Visit a parse tree produced by PigParser#distinct_clause.
    def visitDistinct_clause(self, ctx):
        return self.visit(ctx.rel())


    # Visit a parse tree produced by PigParser#filter_statement.
    def visitFilter_statement(self, ctx):
        target = SimpleRelation(ctx.IDENTIFIER().getText())
        filter_clause = self.visit(ctx.filter_clause())

        return Assign(target, filter_clause)


    # Visit a parse tree produced by PigParser#filter_clause.
    def visitFilter_clause(self, ctx):
        src = SimpleRelation(ctx.IDENTIFIER().getText())
        condition = self.visit(ctx.expr())

        return Filter(src, condition)


    # Visit a parse tree produced by PigParser#join_statement.
    def visitJoin_statement(self, ctx):
        target = ctx.IDENTIFIER().getText()

        join = self.visit(ctx.join_clause())

        return Assign(target, join)

    """join_clause: JOIN joinSubClause (USING join_type)? partition_clause? parallel_clause?;"""
    # Visit a parse tree produced by PigParser#join_clause.
    def visitJoin_clause(self, ctx):
        return self.visit(ctx.joinSubClause())


    # Visit a parse tree produced by PigParser#join_type.
    def visitJoin_type(self, ctx):
        return self.visitChildren(ctx)

    """joinSubClause: joinItem ( ( ( LEFT | RIGHT | FULL ) OUTER? COMMA joinItem ) | ( (COMMA joinItem)+ ) );
"""
    # Visit a parse tree produced by PigParser#joinSubClause.
    def visitJoinSubClause(self, ctx):
        join_type = "INNER"
        if ctx.LEFT() is not None:
            join_type = "LEFT"
        if ctx.RIGHT() is not None:
            join_type = "RIGHT"
        if ctx.FULL() is not None:
            join_type = "FULL"

        join_items = []

        for context in ctx.joinItem():
            join_items.append(self.visit(context))

        return Join(join_type, join_items)

    """joinItem : rel join_groupby_clause;"""
    # Visit a parse tree produced by PigParser#joinItem.
    def visitJoinItem(self, ctx):
        relation = self.visit(ctx.rel())
        group_by_fields = self.visit(ctx.join_groupby_clause())

        return JoinItem(relation, group_by_fields)

    """join_groupby_clause : BY ((LEFT_PAREN arg (COMMA arg)* RIGHT_PAREN) | arg);"""
    # Visit a parse tree produced by PigParser#join_groupby_clause.
    def visitJoin_groupby_clause(self, ctx):
        fields = []

        for context in ctx.arg():
            fields.append(self.visit(context))

        return fields


    # Visit a parse tree produced by PigParser#arg.
    def visitArg(self, ctx):
        if ctx.IDENTIFIER() is not None:
            return Field(ctx.IDENTIFIER().getText())

        return ALL_FIELD

    """rel : IDENTIFIER |  previous_rel | nested_op_clause;"""
    # Visit a parse tree produced by PigParser#rel.
    def visitRel(self, ctx):
        if ctx.IDENTIFIER() is not None:
            return SimpleRelation(ctx.IDENTIFIER().getText())

        if ctx.nested_op_clause() is not None:
            return ComplexRelation(self.visit(ctx.nested_op_clause()))

        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#previous_rel.
    def visitPrevious_rel(self, ctx):
        return ctx.getText()

    """nested_op_clause: LEFT_PAREN op_clause parallel_clause? RIGHT_PAREN
                  | LEFT_PAREN FOREACH rel ( foreach_plan_complex | ( foreach_generate_simple parallel_clause? ) ) RIGHT_PAREN;
    """

    # Visit a parse tree produced by PigParser#nested_op_clause.
    def visitNested_op_clause(self, ctx):
        if ctx.op_clause() is not None:
            return self.visit(ctx.op_clause())



        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#partition_clause.
    def visitPartition_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#parallel_clause.
    def visitParallel_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#group_statement.
    """group_statement: rel ASSIGN group_clause SEMI_COLON?;"""
    def visitGroup_statement(self, ctx):
        target = self.visit(ctx.rel())
        group = self.visit(ctx.group_clause())

        return Assign(target, group)

    """group_clause: GROUP group_item_list ( USING QUOTEDSTRING )? parallel_clause?;"""
    # Visit a parse tree produced by PigParser#group_clause.
    def visitGroup_clause(self, ctx):
        return self.visit(ctx.group_item_list())


    # Visit a parse tree produced by PigParser#group_item_list.
    def visitGroup_item_list(self, ctx):
        groups = []

        for context in ctx.group_item():
            groups.append(self.visit(context))

        return groups[0]

    """rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?;"""
    # Visit a parse tree produced by PigParser#group_item.
    def visitGroup_item(self, ctx):
        relation = self.visit(ctx.rel())
        fields = []

        if ctx.join_group_by_clause() is not None:
            fields = self.visit(ctx.join_group_by_clause())

        return Group(relation, fields)

    """join_group_by_clause : BY ((LEFT_PAREN arg_list RIGHT_PAREN) | real_arg );"""
    # Visit a parse tree produced by PigParser#join_group_by_clause.
    def visitJoin_group_by_clause(self, ctx):
        if ctx.arg_list() is not None:
            return self.visit(ctx.arg_list())
        else:
            return [self.visit(ctx.real_arg())]

    """arg_list : real_arg (COMMA real_arg )* ;"""
    # Visit a parse tree produced by PigParser#arg_list.
    def visitArg_list(self, ctx):
        args = []

        for context in ctx.real_arg():
            args.append(self.visit(context))

        return args


    # Visit a parse tree produced by PigParser#real_arg.
    def visitReal_arg(self, ctx):
        if ctx.STAR() is not None:
            return ALL_FIELD

        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#union_statement.
    def visitUnion_statement(self, ctx):
        target = self.visit(ctx.rel())
        relations = self.visit(ctx.union_clause())

        return Assign(target, Union(relations))


    # Visit a parse tree produced by PigParser#union_clause.
    def visitUnion_clause(self, ctx):
        relations = []

        for context in ctx.rel():
            relations.append(self.visit(context))

        return relations


    # Visit a parse tree produced by PigParser#directory.
    def visitDirectory(self, ctx):
        return ctx.getText()

    """expr :
     paren_expr
   | scalar
   | field_reference
   | expr mul_div_mod_op expr
   | expr plus_minus_op expr
   | expr rel_op expr
   | expr AND expr
   | expr OR expr
   | NOT expr
   | func_call
   | expr QMARK expr COLON expr
   | case_when_expr
   | expr IS (NOT)? NULL
   | expr IN LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
   | expr rel_op expr
   | cast_type expr
   ;"""
    # Visit a parse tree produced by PigParser#expr.
    def visitExpr(self, ctx):
        if ctx.mul_div_mod_op() is not None:
            op = self.visit(ctx.mul_div_mod_op())

            left = self.visit(ctx.expr(0))
            right = self.visit(ctx.expr(1))

            if op == '*':
                return Multiply(left, right)
            elif op == '/':
                return Divide(left, right)
            else:
                return Mod(left, right)

        if ctx.plus_minus_op() is not None:
            op = self.visit(ctx.plus_minus_op())

            left = self.visit(ctx.expr(0))
            right = self.visit(ctx.expr(1))

            if op == '+':
                return Plus(left, right)
            else:
                return Minus(left, right)

        if ctx.rel_op() is not None:
            op = self.visit(ctx.rel_op())

            left = self.visit(ctx.expr(0))
            right = self.visit(ctx.expr(1))

            return Compare(op, left, right)

        if ctx.AND() is not None:
            left = self.visit(ctx.expr(0))
            right = self.visit(ctx.expr(1))

            return And(left, right)

        if ctx.OR() is not None:
            left = self.visit(ctx.expr(0))
            right = self.visit(ctx.expr(1))

            return Or(left, right)

        if ctx.IS() is not None:
            expr = self.visit(ctx.expr(0))

            if ctx.NOT() is not None:
                return IsNotNull(expr)
            else:
                return IsNull(expr)

        if ctx.NOT() is not None:
            expr = self.visit(ctx.expr())

            return Not(expr)

        if ctx.IN() is not None:
            expr = self.visit(ctx.expr(0))

            length = len(ctx.expr())

            values = []

            for i in range(1, length):
                values.append(self.visit(ctx.expr(i)))

            return In(expr, values)

        if ctx.QMARK() is not None:
            condition = self.visit(ctx.expr(0))
            left = self.visit(ctx.expr(1))
            right = self.visit(ctx.expr(2))

            return ConditionExpr(condition, left, right)

        if ctx.cast_type() is not None:
            castType = self.visit(ctx.cast_type())
            expr = self.visit(ctx.expr(0))

            return Cast(castType, expr)

        return self.visitChildren(ctx)

    def visitData_type(self, ctx):
            return self.visitChildren(ctx)

    def visitParen_expr(self, ctx):
        return Paren(self.visit(ctx.expr()))

    """field_reference:  IDENTIFIER
                 | IDENTIFIER PERIOD IDENTIFIER
                 | IDENTIFIER DOUBLE_COLON IDENTIFIER
                 | STAR;"""
    def visitField_reference(self, ctx):
        if ctx.STAR() is not None:
            return ALL_FIELD

        if ctx.PERIOD() is not None or ctx.DOUBLE_COLON() is not None:
            relation = ctx.IDENTIFIER()[0].getText()
            field = ctx.IDENTIFIER()[1].getText()

            return Field(field, relation)

        return Field(ctx.IDENTIFIER()[0].getText())

    # Visit a parse tree produced by PigParser#plus_minus_op.
    def visitPlus_minus_op(self, ctx):
        if ctx.PLUS() is not None:
            return '+'
        else:
            return '-'

    # Visit a parse tree produced by PigParser#mul_div_mod_op.
    def visitMul_div_mod_op(self, ctx):
        if ctx.STAR() is not None:
            return '*'
        elif ctx.DIV() is not None:
            return '/'
        else:
            return '%'


    # Visit a parse tree produced by PigParser#cast_type.
    def visitCast_type(self, ctx):
        return self.visit(ctx.data_type())

    """case_when_expr:
    CASE expr (WHEN expr THEN expr)+ (ELSE expr)? END
    | CASE (WHEN expr THEN expr)+  (ELSE expr)? END
    ;"""

    # Visit a parse tree produced by PigParser#case_when_expr.
    def visitCase_when_expr(self, ctx):
        length = len(ctx.expr())

        if ctx.ELSE() is not None:
            if length % 2 == 0:
                expr = self.visit(ctx.expr(0))

                expressions = []
                values = []

                for i in range(1, length - 1, 2):
                    expressions.append(self.visit(ctx.expr(i)))
                    values.append(self.visit(ctx.expr(i + 1)))

                values.append(self.visit(ctx.expr(length - 1)))

                return ValueCase(expr, expressions, values)
            else:
                expressions = []
                values = []

                for i in range(0, length - 2, 2):
                    expressions.append(self.visit(ctx.expr(i)))
                    values.append(self.visit(ctx.expr(i + 1)))

                values.append(self.visit(ctx.expr(length - 1)))

                return ConditionCase(expressions, values)
        else:
            if length % 2 == 0:
                expressions = []
                values = []

                for i in range(0, length, 2):
                    expressions.append(self.visit(ctx.expr(i)))
                    values.append(self.visit(ctx.expr(i + 1)))

                return ConditionCase(expressions, values)
            else:
                expr = self.visit(ctx.expr(0))

                expressions = []
                values = []

                for i in range(1, length, 2):
                    expressions.append(self.visit(ctx.expr(i)))
                    values.append(self.visit(ctx.expr(i + 1)))

                return ValueCase(expr, expressions, values)

    """
        scalar : INTEGER
       | LONGINTEGER
       | FLOATNUMBER
       | DOUBLENUMBER
       | QUOTEDSTRING
       | NULL
       | TRUE
       | FALSE
;
    """

    # Visit a parse tree produced by PigParser#scalar.
    def visitScalar(self, ctx):
        if ctx.INTEGER() is not None:
            return Number(long(ctx.INTEGER().getText()))

        if ctx.LONGINTEGER() is not None:
            return Number(long(ctx.LONGINTEGER().getText()))

        if ctx.FLOATNUMBER() is not None:
            return Number(float(ctx.FLOATNUMBER().getText()))

        if ctx.DOUBLENUMBER() is not None:
            return Number(float(ctx.DOUBLENUMBER().getText()))

        if ctx.QUOTEDSTRING() is not None:
            value = ctx.QUOTEDSTRING().getText()
            value = value[1:len(value) - 1]

            if len(value) > 0 and value[0] == "$":
                return ParamVar(value[1:])

            return String(value)

        if ctx.NULL() is not None:
            return Null()

        if ctx.TRUE() is not None:
            return Boolean(True)

        if ctx.FALSE() is not None:
            return Boolean(False)

        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#rel_op.
    def visitRel_op(self, ctx):
        return ctx.getText()


        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#rel_str_op.
    def visitRel_str_op(self, ctx):
        #return ctx.getText()

        return self.visitChildren(ctx)

    """class_name LEFT_PAREN expr? (COMMA expr)* RIGHT_PAREN;"""
    # Visit a parse tree produced by PigParser#func_call.
    def visitFunc_call(self, ctx):
        name = self.visit(ctx.class_name())
        args = []

        for context in ctx.expr():
            args.append(self.visit(context))

        if name in Aggregation.TYPES:
            return Aggregation(name, args[0])

        return Function(name, args)

    # Visit a parse tree produced by PigParser#class_name.
    def visitClass_name(self, ctx):
        return ctx.getText()
