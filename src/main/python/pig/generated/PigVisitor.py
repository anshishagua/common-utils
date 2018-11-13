# Generated from /Users/xiaoli/IdeaProjects/common-utils/src/main/resources/Pig.g4 by ANTLR 4.7
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by PigParser.

class PigVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by PigParser#program.
    def visitProgram(self, ctx):
        return self.visitChildren(ctx)


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
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#registerClause.
    def visitRegisterClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#registerFile.
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
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#setClause.
    def visitSetClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#propertyValue.
    def visitPropertyValue(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#loadStatement.
    def visitLoadStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#loadClause.
    def visitLoadClause(self, ctx):
        return self.visitChildren(ctx)


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
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#storeClause.
    def visitStoreClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#distinctStatement.
    def visitDistinctStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#distinctClause.
    def visitDistinctClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#filterStatement.
    def visitFilterStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#filterClause.
    def visitFilterClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#joinStatement.
    def visitJoinStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#joinClause.
    def visitJoinClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#joinType.
    def visitJoinType(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#joinSubClause.
    def visitJoinSubClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#joinItem.
    def visitJoinItem(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#joinGroupByClause.
    def visitJoinGroupByClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#arg.
    def visitArg(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#rel.
    def visitRel(self, ctx):
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
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#unionClause.
    def visitUnionClause(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#directory.
    def visitDirectory(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#parenCondition.
    def visitParenCondition(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#condition.
    def visitCondition(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#andCondition.
    def visitAndCondition(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#notCondition.
    def visitNotCondition(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#unaryCondition.
    def visitUnaryCondition(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#parenExpr.
    def visitParenExpr(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#expr.
    def visitExpr(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#plusMinusOp.
    def visitPlusMinusOp(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#mulDivModOp.
    def visitMulDivModOp(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#multiExpr.
    def visitMultiExpr(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#basicExpression.
    def visitBasicExpression(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#castType.
    def visitCastType(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#castExpr.
    def visitCastExpr(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#biConExpr.
    def visitBiConExpr(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#caseWhenExpr.
    def visitCaseWhenExpr(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#scalar.
    def visitScalar(self, ctx):
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


    # Visit a parse tree produced by PigParser#funcCall.
    def visitFuncCall(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PigParser#className.
    def visitClassName(self, ctx):
        return self.visitChildren(ctx)


