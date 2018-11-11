// Generated from /Users/lixiao/code/common-utils/src/main/resources/Pig.g4 by ANTLR 4.7
package com.anshishagua.pig;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PigParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PigVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PigParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PigParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PigParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(PigParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(PigParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#fieldDefinetion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDefinetion(PigParser.FieldDefinetionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(PigParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#bbb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBbb(PigParser.BbbContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetStatement(PigParser.SetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#propertyValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyValue(PigParser.PropertyValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#loadStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadStatement(PigParser.LoadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#loadClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadClause(PigParser.LoadClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#schema}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchema(PigParser.SchemaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#forEachStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEachStatement(PigParser.ForEachStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#foreach_generate_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeach_generate_simple(PigParser.Foreach_generate_simpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#foreach_plan_complex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeach_plan_complex(PigParser.Foreach_plan_complexContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#flatten_generated_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlatten_generated_item(PigParser.Flatten_generated_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#generate_as_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerate_as_clause(PigParser.Generate_as_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#field_def_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_def_list(PigParser.Field_def_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#field_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_def(PigParser.Field_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#explicit_field_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_field_def(PigParser.Explicit_field_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#flatten_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlatten_clause(PigParser.Flatten_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#nested_blk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_blk(PigParser.Nested_blkContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#nested_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_command(PigParser.Nested_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#storeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoreStatement(PigParser.StoreStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#distinctStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistinctStatement(PigParser.DistinctStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#filterStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterStatement(PigParser.FilterStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#joinStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinStatement(PigParser.JoinStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#joinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinClause(PigParser.JoinClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(PigParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#joinSubClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinSubClause(PigParser.JoinSubClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#joinItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinItem(PigParser.JoinItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#joinGroupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinGroupByClause(PigParser.JoinGroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(PigParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel(PigParser.RelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#partitionCaluse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionCaluse(PigParser.PartitionCaluseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#parallelClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelClause(PigParser.ParallelClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#groupStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupStatement(PigParser.GroupStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#unionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionStatement(PigParser.UnionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#directory}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectory(PigParser.DirectoryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PigParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#andCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCondition(PigParser.AndConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#notCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondition(PigParser.NotConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#unaryCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryCondition(PigParser.UnaryConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PigParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#multiExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiExpr(PigParser.MultiExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpression(PigParser.BasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#castType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastType(PigParser.CastTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#castExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpr(PigParser.CastExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#parenExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(PigParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#scalar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalar(PigParser.ScalarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#relOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(PigParser.RelOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#relStrOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelStrOp(PigParser.RelStrOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#nullExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullExpression(PigParser.NullExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(PigParser.ClassNameContext ctx);
}