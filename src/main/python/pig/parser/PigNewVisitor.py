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
from Field import Field
from Relation import Relation
from CaseWhen import CaseWhen
from Paren import Paren
from Union import Union
from Distinct import Distinct
from ConditionExpr import ConditionExpr
from ConditionExpr import ConditionExpr
from Null import Null
from Boolean import Boolean
from ConditionCase import ConditionCase
from ValueCase import ValuseCase
from FieldRange import FieldRange
from Foreach import Foreach
from Alias import Alias
from Join import Join, JoinItem


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
    def visitCube_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#cube_clause.
    def visitCube_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#cube_rollup_list.
    def visitCube_rollup_list(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#define_statement.
    def visitDefine_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#split_statement.
    def visitSplit_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#split_clause.
    def visitSplit_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#split_branch.
    def visitSplit_branch(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#split_otherwise.
    def visitSplit_otherwise(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#register_statement.
    def visitRegister_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#register_clause.
    def visitRegister_clause(self, ctx):
        return self.visitChildren(ctx)


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
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#set_clause.
    def visitSet_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#property_value.
    def visitProperty_value(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#load_statement.
    def visitLoad_statement(self, ctx):
        relation = ctx.IDENTIFIER().getText()

        directory = self.visit(ctx.load_clause())

        return Load(relation, directory)

    """load_clause: LOAD PARAM_PATTERN directory PARAM_PATTERN (USING function)?"""
    # Visit a parse tree produced by PigParser#load_clause.
    def visitLoad_clause(self, ctx):
        return self.visit(ctx.directory())


    # Visit a parse tree produced by PigParser#foreach_statement.
    def visitForeach_statement(self, ctx):
        target = Relation(ctx.IDENTIFIER().getText())

        relation, items = self.visit(ctx.foreach_clause())

        return Foreach(target, relation, items)

    """foreach_clause: FOREACH rel (foreach_plan_complex | ( foreach_generate_simple parallel_clause?));"""
    # Visit a parse tree produced by PigParser#foreach_clause.
    def visitForeach_clause(self, ctx):
        src = self.visit(ctx.rel())

        items = None
        if ctx.foreach_generate_simple() is not None:
            items = self.visit(ctx.foreach_generate_simple())

        return (src, items)

        #return self.visitChildren(ctx)

    """foreach_generate_simple : GENERATE flatten_generated_item (COMMA flatten_generated_item )*;"""
    # Visit a parse tree produced by PigParser#foreach_generate_simple.
    def visitForeach_generate_simple(self, ctx):
        items = []

        for context in ctx.flatten_generated_item():
            items.append(self.visit(context))

        return items


    # Visit a parse tree produced by PigParser#foreach_plan_complex.
    def visitForeach_plan_complex(self, ctx):
        return self.visitChildren(ctx)


    """flatten_generated_item: flatten_clause generate_as_clause? | real_arg generate_as_clause?;"""
    # Visit a parse tree produced by PigParser#flatten_generated_item.
    def visitFlatten_generated_item(self, ctx):
        arg = None
        if ctx.real_arg() is not None:
            arg = self.visit(ctx.real_arg())

        alias = None
        if ctx.generate_as_clause() is not None:
            alias = self.visit(ctx.generate_as_clause())

        if alias is not None:
            return Alias(alias, arg)

        return arg

        #return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#generate_as_clause.
    def visitGenerate_as_clause(self, ctx):
        if ctx.explicit_field_def() is not None:
            return self.visit(ctx.explicit_field_def())

        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#field_def_list.
    def visitField_def_list(self, ctx):
        return self.visitChildren(ctx)


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


    # Visit a parse tree produced by PigParser#flatten_clause.
    def visitFlatten_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_blk.
    def visitNested_blk(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_command.
    def visitNested_command(self, ctx):
        return self.visitChildren(ctx)


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
            start = 0
            end = int(self.visit(ctx.col_ref()[0])[1:])

        return FieldRange(start, end)


    # Visit a parse tree produced by PigParser#nested_filter.
    def visitNested_filter(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_op_input.
    def visitNested_op_input(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#col_ref.
    def visitCol_ref(self, ctx):
        if ctx.IDENTIFIER() is not None:
            return ctx.IDENTIFIER().getText()
        else:
            return ctx.DOLLAR_VAR().getText()


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
        target = ctx.IDENTIFIER().getText()
        src, condition = self.visit(ctx.filter_clause())

        return Filter(src, target, condition)


    # Visit a parse tree produced by PigParser#filter_clause.
    def visitFilter_clause(self, ctx):
        relation = ctx.IDENTIFIER().getText()
        condition = self.visit(ctx.expr())

        return (relation, condition)


    # Visit a parse tree produced by PigParser#join_statement.
    def visitJoin_statement(self, ctx):
        target = ctx.IDENTIFIER().getText()

        joinType, joinItems = self.visit(ctx.join_clause())

        return Join(target, joinType, joinItems)

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
        joinType = "INNER"
        if ctx.LEFT() is not None:
            joinType = "LEFT"
        if ctx.RIGHT() is not None:
            joinType = "RIGHT"
        if ctx.FULL() is not None:
            joinType = "FULL"

        joinItems = []

        for context in ctx.joinItem():
            joinItems.append(self.visit(context))

        return (joinType, joinItems)

    """joinItem : rel join_groupby_clause;"""
    # Visit a parse tree produced by PigParser#joinItem.
    def visitJoinItem(self, ctx):
        relation = self.visit(ctx.rel())
        groupByFields = self.visit(ctx.join_groupby_clause())

        return JoinItem(relation, groupByFields)

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

        return Field("*")


    # Visit a parse tree produced by PigParser#rel.
    def visitRel(self, ctx):
        if ctx.IDENTIFIER() is not None:
            return Relation(ctx.IDENTIFIER().getText())

        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#previous_rel.
    def visitPrevious_rel(self, ctx):
        return ctx.getText()

    """nested_op_clause: LEFT_PAREN op_clause parallel_clause? RIGHT_PAREN
                  | LEFT_PAREN FOREACH rel ( foreach_plan_complex | ( foreach_generate_simple parallel_clause? ) ) RIGHT_PAREN;
    """

    # Visit a parse tree produced by PigParser#nested_op_clause.
    def visitNested_op_clause(self, ctx):


        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#partition_clause.
    def visitPartition_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#parallel_clause.
    def visitParallel_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#group_statement.
    def visitGroup_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#group_clause.
    def visitGroup_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#group_item_list.
    def visitGroup_item_list(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#group_item.
    def visitGroup_item(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#join_group_by_clause.
    def visitJoin_group_by_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#arg_list.
    def visitArg_list(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#real_arg.
    def visitReal_arg(self, ctx):
        if ctx.STAR() is not None:
            return Field("*")

        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#union_statement.
    def visitUnion_statement(self, ctx):
        target = self.visit(ctx.rel())
        relations = self.visit(ctx.union_clause())

        return Union(target, relations)


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
            return Field("*")

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

                for i in range(1, length, 2):
                    expressions.append(self.visit(ctx.expr(i)))
                    values.append(self.visit(ctx.expr(i + 1)))

                values.append(self.visit(ctx.expr(length - 1)))

                return ValuseCase(expr, expressions, values)
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

                return ValuseCase(expr, expressions, values)

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

        if ctx.FLOATNUMBER() is not None:
            return Number(float(ctx.FLOATNUMBER().getText()))

        if ctx.DOUBLENUMBER() is not None:
            return Number(float(ctx.DOUBLENUMBER().getText()))

        if ctx.QUOTEDSTRING() is not None:
            return String(ctx.QUOTEDSTRING().getText())

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

        return Function(name, args)

    # Visit a parse tree produced by PigParser#class_name.
    def visitClass_name(self, ctx):
        return ctx.getText()
