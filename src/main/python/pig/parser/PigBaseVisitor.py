from pig.generated.PigVisitor import PigVisitor
from pig.parser.Load import Load
from pig.parser.Program import Program
from pig.parser.Store import Store
from pig.parser.Set import Set
from pig.parser.Register import Register
from pig.parser.Filter import Filter
from pig.parser.Or import Or
from pig.parser.And import And
from pig.parser.Not import Not
from pig.parser.IsNotNull import IsNotNull
from pig.parser.IsNull import IsNull
from pig.parser.In import In
from pig.parser.Compare import Compare
from pig.parser.Plus import Plus
from pig.parser.Minus import Minus
from pig.parser.Multiply import Multiply
from pig.parser.Divide import Divide
from pig.parser.Mod import Mod
from pig.parser.Number import Number
from pig.parser.String import String
from pig.parser.Function import Function
from pig.parser.Cast import Cast
from pig.parser.Field import Field
from pig.parser.Relation import Relation
from pig.parser.CaseWhen import CaseWhen
from pig.parser.Paren import Paren
from pig.parser.Union import Union
from pig.parser.Distinct import Distinct
from pig.parser.ConditionExpr import ConditionExpr

class PigBaseVisitor(PigVisitor):
    # Visit a parse tree produced by PigParser#program.
    def visitProgram(self, ctx):
        statements = []

        for context in ctx.statement():
            statements.append(self.visit(context))

        return Program(statements)


    # Visit a parse tree produced by PigParser#statement.
    def visitStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#opClause.
    def visitOpClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#defineStatement.
    def visitDefineStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#splitStatement.
    def visitSplitStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#splitClause.
    def visitSplitClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#split_branch.
    def visitSplit_branch(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#split_otherwise.
    def visitSplit_otherwise(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#registerStatement.
    def visitRegisterStatement(self, ctx):
        return self.visit(ctx.registerClause())


    # Visit a parse tree produced by PigParser#registerClause.
    def visitRegisterClause(self, ctx):
        file = ctx.registerFile().getText()
        alias = None

        if ctx.IDENTIFIER() is not None:
            alias = ctx.IDENTIFIER().getText()

        return Register(file, alias)

    def visitRegisterFile(self, ctx):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by PigParser#field.
    def visitField(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#dataType.
    def visitDataType(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#fieldDefinetion.
    def visitFieldDefinetion(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#function.
    def visitFunction(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#setStatement.
    def visitSetStatement(self, ctx):
        return self.visit(ctx.setClause())


    # Visit a parse tree produced by PigParser#setClause.
    def visitSetClause(self, ctx):
        key = ctx.className().getText()
        value = ctx.propertyValue().getText()

        return Set(key, value)


    # Visit a parse tree produced by PigParser#propertyValue.
    def visitPropertyValue(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#loadStatement.
    def visitLoadStatement(self, context):
        relation = context.IDENTIFIER().getText()
        schema = self.visit(context.loadClause())

        return Load(relation, schema)


    # Visit a parse tree produced by PigParser#loadClause.
    def visitLoadClause(self, ctx):
        return self.visit(ctx.directory())


    # Visit a parse tree produced by PigParser#forEachStatement.
    def visitForEachStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#forEachClause.
    def visitForEachClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#foreach_generate_simple.
    def visitForeach_generate_simple(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#foreach_plan_complex.
    def visitForeach_plan_complex(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#flatten_generated_item.
    def visitFlatten_generated_item(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#generate_as_clause.
    def visitGenerate_as_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#field_def_list.
    def visitField_def_list(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#field_def.
    def visitField_def(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#explicit_field_def.
    def visitExplicit_field_def(self, ctx):
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
    def visitCol_range(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_filter.
    def visitNested_filter(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_op_input.
    def visitNested_op_input(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#col_ref.
    def visitCol_ref(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_proj.
    def visitNested_proj(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#col_ref_list.
    def visitCol_ref_list(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#storeStatement.
    def visitStoreStatement(self, ctx):
        return self.visit(ctx.storeClause())


    # Visit a parse tree produced by PigParser#storeClause.
    def visitStoreClause(self, ctx):
        relation = ctx.IDENTIFIER().getText()
        schema = ctx.directory().getText()

        return Store(relation, schema)


    # Visit a parse tree produced by PigParser#distinctStatement.
    def visitDistinctStatement(self, ctx):
        src = self.visit(ctx.distinctClause())
        target = ctx.IDENTIFIER().getText()

        return Distinct(src, target)


    # Visit a parse tree produced by PigParser#distinctClause.
    def visitDistinctClause(self, ctx):
        return self.visit(ctx.rel())


    # Visit a parse tree produced by PigParser#filterStatement.
    def visitFilterStatement(self, ctx):
        toRelation = ctx.IDENTIFIER().getText()
        fromRelation = ctx.filterClause().IDENTIFIER().getText()

        condition = self.visit(ctx.filterClause().condition())

        return Filter(fromRelation, toRelation, condition)


    # Visit a parse tree produced by PigParser#filterClause.
    def visitFilterClause(self, ctx):
        return self.visitChildren(ctx)


    #joinStatement: IDENTIFIER ASSIGN joinClause SEMI_COLON?;

    # Visit a parse tree produced by PigParser#joinStatement.
    def visitJoinStatement(self, ctx):
        relation = ctx.IDENTIFIER().getText()
        return self.visitChildren(ctx)

    #joinClause: JOIN joinSubClause (USING joinType)? partitionCaluse? parallelClause?;
    # Visit a parse tree produced by PigParser#joinClause.
    def visitJoinClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#joinType.
    def visitJoinType(self, ctx):
        return self.visitChildren(ctx)

    #joinSubClause: joinItem ( ( ( LEFT | RIGHT | FULL ) OUTER? COMMA joinItem ) | ( (COMMA joinItem)+ ) );

    # Visit a parse tree produced by PigParser#joinSubClause.
    def visitJoinSubClause(self, ctx):
        return self.visitChildren(ctx)

    #joinItem : rel joinGroupByClause;

    # Visit a parse tree produced by PigParser#joinItem.
    def visitJoinItem(self, ctx):
        relation = self.visit(ctx.rel())

        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#joinGroupByClause.
    def visitJoinGroupByClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#arg.
    def visitArg(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#rel.
    def visitRel(self, ctx):
        if ctx.IDENTIFIER() is not None:
            return ctx.IDENTIFIER().getText()

        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#previous_rel.
    def visitPrevious_rel(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nested_op_clause.
    def visitNested_op_clause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#partitionCaluse.
    def visitPartitionCaluse(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#parallelClause.
    def visitParallelClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#groupStatement.
    def visitGroupStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#groupClause.
    def visitGroupClause(self, ctx):
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
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#unionStatement.
    def visitUnionStatement(self, ctx):
        relation = self.visit(ctx.rel())
        relations = self.visit(ctx.unionClause())

        return Union(relation, relations)


    # Visit a parse tree produced by PigParser#unionClause.
    def visitUnionClause(self, ctx):
        relations = []

        for context in ctx.rel():
            relations.append(self.visit(context))

        return relations


    # Visit a parse tree produced by PigParser#directory.
    def visitDirectory(self, ctx):

        return ctx.getText()


    # Visit a parse tree produced by PigParser#parenCondition.
    def visitParenCondition(self, ctx):
        return Paren(self.visit(ctx.condition()))

    #condition : parenCondition | andCondition (OR andCondition)* | funcCall;

    # Visit a parse tree produced by PigParser#condition.
    def visitCondition(self, ctx):
        if ctx.parenCondition() is not None:
            return self.visit(ctx.parenCondition())
        if ctx.funcCall() is not None:
            return self.visit(ctx.funcCall())

        length = len(ctx.andCondition())

        left = self.visit(ctx.andCondition()[0])

        for i in range(1, length):
            right = self.visit(ctx.andCondition()[i])

            left = Or(left, right)

        return left


    #andCondition : notCondition (AND notCondition)*
    # Visit a parse tree produced by PigParser#andCondition.
    def visitAndCondition(self, ctx):
        left = self.visit(ctx.notCondition()[0])

        length = len(ctx.notCondition())

        for i in range(1, length):
            right = self.visit(ctx.notCondition()[i])

            left = And(left, right)

        return left


    #notCondition : NOT? unaryCondition;

    # Visit a parse tree produced by PigParser#notCondition.
    def visitNotCondition(self, ctx):
        condition = self.visit(ctx.unaryCondition())

        if ctx.NOT() is not None:
            condition = Not(condition)

        return condition


    #unaryCondition: LEFT_PAREN condition RIGHT_PAREN
    # | expr ((IS (NOT)? NULL )
    # | (IN LEFT_PAREN biConExpr (COMMA biConExpr)* RIGHT_PAREN)
    # | (relOp expr));

    # Visit a parse tree produced by PigParser#unaryCondition.
    def visitUnaryCondition(self, ctx):
        if ctx.condition() is not None:
            return self.visit(ctx.condition())

        if ctx.funcCall() is not None:
            return self.visit(ctx.funcCall())

        left = self.visit(ctx.expr()[0])

        if ctx.NULL() is not None:
            if ctx.NOT() is not None:
                return IsNotNull(left)
            else:
                return IsNull(left)

        if ctx.IN() is not None:
            values = []

            for context in ctx.biConExpr():
                values.append(self.visit(context))

            return In(values)

        compareType = ctx.relOp().getText()

        right = self.visit(ctx.expr()[1])

        return Compare(compareType, left, right)


    # Visit a parse tree produced by PigParser#parenExpr.
    def visitParenExpr(self, ctx):
        return Paren(self.visit(ctx.expr()))


    # expr :
    #       parenExpr
    #    |  multiExpr ((PLUS | MINUS) multiExpr)*
    #    ;
    # Visit a parse tree produced by PigParser#expr.
    def visitExpr(self, ctx):
        if ctx.parenExpr() is not None:
            return self.visit(ctx.parenExpr())

        left = self.visit(ctx.multiExpr()[0])

        length = len(ctx.multiExpr())

        for i in range(1, length):
            right = self.visit(ctx.multiExpr(i))

            op = ctx.plusMinusOp(i - 1).getText()

            if op == '+':
                left = Plus(left, right)
            else:
                left = Minus(left, right)

        return left

    def visitMulDivModOp(self, ctx):
        if ctx.STAR() is not None:
            return "*";
        elif ctx.DIV() is not None:
            return "/"
        return "%"

    #mulDivModOp: (STAR | DIV | MOD);

    #multiExpr : castExpr (mulDivModOp castExpr)*
    # Visit a parse tree produced by PigParser#multiExpr.
    def visitMultiExpr(self, ctx):
        left = self.visit(ctx.castExpr()[0])

        length = len(ctx.castExpr())

        for i in range(1, length):
            right = self.visit(ctx.castExpr()[i])

            op = ctx.mulDivModOp()[0].getText()

            if op == '*':
                left = Multiply(left, right)
            elif op == '/':
                left = Divide(left, right)
            else:
                left = Mod(left, right)

        return left


    # Visit a parse tree produced by PigParser#basicExpression.
    """basicExpression: scalar 
    | IDENTIFIER | IDENTIFIER PERIOD IDENTIFIER 
    | IDENTIFIER COLON COLON IDENTIFIER 
    | STAR;
    """
    def visitBasicExpression(self, ctx):
        if ctx.scalar() is not None:
            return self.visit(ctx.scalar())

        if ctx.PERIOD() is not None or ctx.DOUBLE_COLON() is not None:
            relation = ctx.IDENTIFIER(0).getText()
            field = ctx.IDENTIFIER(1).getText()

            return Field(field, relation)

        if ctx.STAR() is not None:
            return Field("*")

        field = ctx.IDENTIFIER(0).getText()

        return Field(field)


    # Visit a parse tree produced by PigParser#castType.
    def visitCastType(self, ctx):
        return ctx.dataType().getText()

    ###castExpr : castType? basicExpression
    #    | caseWhenExpr
    #    | parenExpr
    #    | scalar
    #    | funcCall
    #    ;

    # Visit a parse tree produced by PigParser#castExpr.
    def visitCastExpr(self, ctx):
        if ctx.scalar() is not None:
            return self.visit(ctx.scalar())

        if ctx.parenExpr() is not None:
            return self.visit(ctx.parenExpr())

        if ctx.funcCall() is not None:
            return self.visit(ctx.funcCall())

        if ctx.caseWhenExpr() is not None:
            return self.visit(ctx.caseWhenExpr())

        if ctx.basicExpression() is not None:
            expression = self.visit(ctx.basicExpression())

            if ctx.castType() is not None:
                dataType = self.visit(ctx.castType())

                expression = Cast(dataType, expression)

            return expression


        return self.visitChildren(ctx)

    """biConExpr: LEFT_PAREN biConExpr RIGHT_PAREN
| condition QMARK biConExpr COLON biConExpr
| multiExpr ((PLUS | MINUS) multiExpr)*  ;"""
    # Visit a parse tree produced by PigParser#biConExpr.
    def visitBiConExpr(self, ctx):
        if ctx.LEFT_PAREN() is not None:
            return Paren(self.visit(ctx.biConExpr()))

        if ctx.condition() is not None:
            condition = self.visit(ctx.condition())
            left = self.visit(ctx.biConExpr(0))
            right = self.visit(ctx.biConExpr(1))

            return ConditionExpr(condition, left, right)

        left = self.visit(ctx.multiExpr()[0])

        length = len(ctx.multiExpr())

        for i in range(1, length):
            right = self.visit(ctx.multiExpr(i))

            op = ctx.plusMinusOp(i - 1).getText()

            if op == '+':
                left = Plus(left, right)
            else:
                left = Minus(left, right)

        return left

    # Visit a parse tree produced by PigParser#caseWhenExpr.
    """caseWhenExpr:
    CASE biConExpr (WHEN biConExpr THEN biConExpr)+ (ELSE biConExpr)? END
    | CASE (WHEN condition THEN biConExpr)+  (ELSE biConExpr)? END
    ;"""
    def visitCaseWhenExpr(self, ctx):
        if ctx.condition() is not None:
            length = len(ctx.condition())

            conditions = []
            values = []

            for i in range(length):
                conditions.append(self.visit(ctx.condition(i)))
                values.append(self.visit(ctx.biConExpr(i)))

            elseValue = None

            if ctx.ELSE() is not None:
                elseValue = self.visit(ctx.biConExpr(length))

            return CaseWhen(conditions, values, elseValue)
        else:
            caseExpression = self.visit(ctx.biConExpr(0))
            elseValue = None

            length = len(ctx.biConExpr())

            if ctx.ELSE() is not None:
                elseValue = self.visit(ctx.biConExpr(length - 1))
                length -= 1

            thenConditions = []
            thenValues = []

            for i in range(1, length, 2):
                thenConditions.append(self.visit(ctx.biConExpr(i)))
                thenValues.append(self.visit(ctx.biConExpr(i + 1)))

            return CaseWhen(caseExpression, thenConditions, thenValues, elseValue)


    """scalar : INTEGER
       | LONGINTEGER
       | FLOATNUMBER
       | DOUBLENUMBER
       | QUOTEDSTRING
       | NULL
       | TRUE
       | FALSE
    ;"""
    # Visit a parse tree produced by PigParser#scalar.
    def visitScalar(self, ctx):
        value = None

        if ctx.INTEGER() is not None:
            return Number(int(ctx.INTEGER().getText()))
        elif ctx.LONGINTEGER() is not None:
            return Number(long(ctx.LONG().getText()))
        elif ctx.DOUBLENUMBER() is not None:
            return Number(float(ctx.DOUBLENUMBER().getText()))
        elif ctx.QUOTEDSTRING() is not None:
            return String(ctx.QUOTEDSTRING().getText())

        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#relOp.
    def visitRelOp(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#relStrOp.
    def visitRelStrOp(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#nullExpression.
    def visitNullExpression(self, ctx):
        return self.visitChildren(ctx)


    """funcCall: className LEFT_PAREN biConExpr? (COMMA biConExpr)* RIGHT_PAREN;
    """
    # Visit a parse tree produced by PigParser#funcCall.
    def visitFuncCall(self, ctx):
        name = ctx.className().getText()

        args = []

        for context in ctx.biConExpr():
            args.append(self.visit(context))

        return Function(name, args)


    # Visit a parse tree produced by PigParser#className.
    def visitClassName(self, ctx):
        return self.visitChildren(ctx)