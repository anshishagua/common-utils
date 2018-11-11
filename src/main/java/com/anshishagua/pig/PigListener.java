// Generated from /Users/lixiao/code/common-utils/src/main/resources/Pig.g4 by ANTLR 4.7
package com.anshishagua.pig;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PigParser}.
 */
public interface PigListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PigParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PigParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PigParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PigParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PigParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(PigParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(PigParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(PigParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(PigParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#fieldDefinetion}.
	 * @param ctx the parse tree
	 */
	void enterFieldDefinetion(PigParser.FieldDefinetionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#fieldDefinetion}.
	 * @param ctx the parse tree
	 */
	void exitFieldDefinetion(PigParser.FieldDefinetionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(PigParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(PigParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#bbb}.
	 * @param ctx the parse tree
	 */
	void enterBbb(PigParser.BbbContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#bbb}.
	 * @param ctx the parse tree
	 */
	void exitBbb(PigParser.BbbContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void enterSetStatement(PigParser.SetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void exitSetStatement(PigParser.SetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#propertyValue}.
	 * @param ctx the parse tree
	 */
	void enterPropertyValue(PigParser.PropertyValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#propertyValue}.
	 * @param ctx the parse tree
	 */
	void exitPropertyValue(PigParser.PropertyValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#loadStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoadStatement(PigParser.LoadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#loadStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoadStatement(PigParser.LoadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#loadClause}.
	 * @param ctx the parse tree
	 */
	void enterLoadClause(PigParser.LoadClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#loadClause}.
	 * @param ctx the parse tree
	 */
	void exitLoadClause(PigParser.LoadClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#schema}.
	 * @param ctx the parse tree
	 */
	void enterSchema(PigParser.SchemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#schema}.
	 * @param ctx the parse tree
	 */
	void exitSchema(PigParser.SchemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void enterForEachStatement(PigParser.ForEachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void exitForEachStatement(PigParser.ForEachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#foreach_generate_simple}.
	 * @param ctx the parse tree
	 */
	void enterForeach_generate_simple(PigParser.Foreach_generate_simpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#foreach_generate_simple}.
	 * @param ctx the parse tree
	 */
	void exitForeach_generate_simple(PigParser.Foreach_generate_simpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#foreach_plan_complex}.
	 * @param ctx the parse tree
	 */
	void enterForeach_plan_complex(PigParser.Foreach_plan_complexContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#foreach_plan_complex}.
	 * @param ctx the parse tree
	 */
	void exitForeach_plan_complex(PigParser.Foreach_plan_complexContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#flatten_generated_item}.
	 * @param ctx the parse tree
	 */
	void enterFlatten_generated_item(PigParser.Flatten_generated_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#flatten_generated_item}.
	 * @param ctx the parse tree
	 */
	void exitFlatten_generated_item(PigParser.Flatten_generated_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#generate_as_clause}.
	 * @param ctx the parse tree
	 */
	void enterGenerate_as_clause(PigParser.Generate_as_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#generate_as_clause}.
	 * @param ctx the parse tree
	 */
	void exitGenerate_as_clause(PigParser.Generate_as_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#field_def_list}.
	 * @param ctx the parse tree
	 */
	void enterField_def_list(PigParser.Field_def_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#field_def_list}.
	 * @param ctx the parse tree
	 */
	void exitField_def_list(PigParser.Field_def_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#field_def}.
	 * @param ctx the parse tree
	 */
	void enterField_def(PigParser.Field_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#field_def}.
	 * @param ctx the parse tree
	 */
	void exitField_def(PigParser.Field_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#explicit_field_def}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_field_def(PigParser.Explicit_field_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#explicit_field_def}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_field_def(PigParser.Explicit_field_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#flatten_clause}.
	 * @param ctx the parse tree
	 */
	void enterFlatten_clause(PigParser.Flatten_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#flatten_clause}.
	 * @param ctx the parse tree
	 */
	void exitFlatten_clause(PigParser.Flatten_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#nested_blk}.
	 * @param ctx the parse tree
	 */
	void enterNested_blk(PigParser.Nested_blkContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#nested_blk}.
	 * @param ctx the parse tree
	 */
	void exitNested_blk(PigParser.Nested_blkContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#nested_command}.
	 * @param ctx the parse tree
	 */
	void enterNested_command(PigParser.Nested_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#nested_command}.
	 * @param ctx the parse tree
	 */
	void exitNested_command(PigParser.Nested_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#storeStatement}.
	 * @param ctx the parse tree
	 */
	void enterStoreStatement(PigParser.StoreStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#storeStatement}.
	 * @param ctx the parse tree
	 */
	void exitStoreStatement(PigParser.StoreStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#distinctStatement}.
	 * @param ctx the parse tree
	 */
	void enterDistinctStatement(PigParser.DistinctStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#distinctStatement}.
	 * @param ctx the parse tree
	 */
	void exitDistinctStatement(PigParser.DistinctStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void enterFilterStatement(PigParser.FilterStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void exitFilterStatement(PigParser.FilterStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#joinStatement}.
	 * @param ctx the parse tree
	 */
	void enterJoinStatement(PigParser.JoinStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#joinStatement}.
	 * @param ctx the parse tree
	 */
	void exitJoinStatement(PigParser.JoinStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinClause(PigParser.JoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinClause(PigParser.JoinClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(PigParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(PigParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#joinSubClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinSubClause(PigParser.JoinSubClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#joinSubClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinSubClause(PigParser.JoinSubClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#joinItem}.
	 * @param ctx the parse tree
	 */
	void enterJoinItem(PigParser.JoinItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#joinItem}.
	 * @param ctx the parse tree
	 */
	void exitJoinItem(PigParser.JoinItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#joinGroupByClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinGroupByClause(PigParser.JoinGroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#joinGroupByClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinGroupByClause(PigParser.JoinGroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(PigParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(PigParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterRel(PigParser.RelContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitRel(PigParser.RelContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#partitionCaluse}.
	 * @param ctx the parse tree
	 */
	void enterPartitionCaluse(PigParser.PartitionCaluseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#partitionCaluse}.
	 * @param ctx the parse tree
	 */
	void exitPartitionCaluse(PigParser.PartitionCaluseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#parallelClause}.
	 * @param ctx the parse tree
	 */
	void enterParallelClause(PigParser.ParallelClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#parallelClause}.
	 * @param ctx the parse tree
	 */
	void exitParallelClause(PigParser.ParallelClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#groupStatement}.
	 * @param ctx the parse tree
	 */
	void enterGroupStatement(PigParser.GroupStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#groupStatement}.
	 * @param ctx the parse tree
	 */
	void exitGroupStatement(PigParser.GroupStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#unionStatement}.
	 * @param ctx the parse tree
	 */
	void enterUnionStatement(PigParser.UnionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#unionStatement}.
	 * @param ctx the parse tree
	 */
	void exitUnionStatement(PigParser.UnionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#directory}.
	 * @param ctx the parse tree
	 */
	void enterDirectory(PigParser.DirectoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#directory}.
	 * @param ctx the parse tree
	 */
	void exitDirectory(PigParser.DirectoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PigParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PigParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#andCondition}.
	 * @param ctx the parse tree
	 */
	void enterAndCondition(PigParser.AndConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#andCondition}.
	 * @param ctx the parse tree
	 */
	void exitAndCondition(PigParser.AndConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#notCondition}.
	 * @param ctx the parse tree
	 */
	void enterNotCondition(PigParser.NotConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#notCondition}.
	 * @param ctx the parse tree
	 */
	void exitNotCondition(PigParser.NotConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#unaryCondition}.
	 * @param ctx the parse tree
	 */
	void enterUnaryCondition(PigParser.UnaryConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#unaryCondition}.
	 * @param ctx the parse tree
	 */
	void exitUnaryCondition(PigParser.UnaryConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PigParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PigParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#multiExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiExpr(PigParser.MultiExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#multiExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiExpr(PigParser.MultiExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterBasicExpression(PigParser.BasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitBasicExpression(PigParser.BasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#castType}.
	 * @param ctx the parse tree
	 */
	void enterCastType(PigParser.CastTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#castType}.
	 * @param ctx the parse tree
	 */
	void exitCastType(PigParser.CastTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#castExpr}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(PigParser.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#castExpr}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(PigParser.CastExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#parenExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(PigParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#parenExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(PigParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#scalar}.
	 * @param ctx the parse tree
	 */
	void enterScalar(PigParser.ScalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#scalar}.
	 * @param ctx the parse tree
	 */
	void exitScalar(PigParser.ScalarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(PigParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(PigParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#relStrOp}.
	 * @param ctx the parse tree
	 */
	void enterRelStrOp(PigParser.RelStrOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#relStrOp}.
	 * @param ctx the parse tree
	 */
	void exitRelStrOp(PigParser.RelStrOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#nullExpression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpression(PigParser.NullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#nullExpression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpression(PigParser.NullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(PigParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(PigParser.ClassNameContext ctx);
}