// Generated from /Users/xiaoli/IdeaProjects/common-utils/src/main/resources/PigParser3.g4 by ANTLR 4.7
package com.anshishagua.pigparser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PigParser3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PigParser3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#pigFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPigFile(PigParser3Parser.PigFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PigParser3Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#empty_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_statement(PigParser3Parser.Empty_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#declare_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_statement(PigParser3Parser.Declare_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#default_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefault_statement(PigParser3Parser.Default_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_op_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_op_clause(PigParser3Parser.Nested_op_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#general_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneral_statement(PigParser3Parser.General_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#identifier_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_assignment(PigParser3Parser.Identifier_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#foreach_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeach_statement(PigParser3Parser.Foreach_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#foreach_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeach_assignment(PigParser3Parser.Foreach_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#foreach_plan_complex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeach_plan_complex(PigParser3Parser.Foreach_plan_complexContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#foreach_generate_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeach_generate_simple(PigParser3Parser.Foreach_generate_simpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#macro_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_content(PigParser3Parser.Macro_contentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#macro_param_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_param_clause(PigParser3Parser.Macro_param_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#macro_return_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_return_clause(PigParser3Parser.Macro_return_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#macro_body_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_body_clause(PigParser3Parser.Macro_body_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#macro_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_clause(PigParser3Parser.Macro_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#inline_return_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_return_clause(PigParser3Parser.Inline_return_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(PigParser3Parser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#inline_param_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_param_clause(PigParser3Parser.Inline_param_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#inline_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_clause(PigParser3Parser.Inline_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#simple_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_type(PigParser3Parser.Simple_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#implicit_tuple_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicit_tuple_type(PigParser3Parser.Implicit_tuple_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#explicit_tuple_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_tuple_type(PigParser3Parser.Explicit_tuple_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#explicit_tuple_type_cast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_tuple_type_cast(PigParser3Parser.Explicit_tuple_type_castContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#tuple_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple_type(PigParser3Parser.Tuple_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#implicit_bag_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicit_bag_type(PigParser3Parser.Implicit_bag_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#explicit_bag_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_bag_type(PigParser3Parser.Explicit_bag_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#explicit_bag_type_cast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_bag_type_cast(PigParser3Parser.Explicit_bag_type_castContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#implicit_map_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicit_map_type(PigParser3Parser.Implicit_map_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#explicit_map_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_map_type(PigParser3Parser.Explicit_map_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#map_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap_type(PigParser3Parser.Map_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#explicit_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_type(PigParser3Parser.Explicit_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#implicit_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicit_type(PigParser3Parser.Implicit_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PigParser3Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#explicit_type_cast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_type_cast(PigParser3Parser.Explicit_type_castContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#import_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_clause(PigParser3Parser.Import_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#define_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_clause(PigParser3Parser.Define_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#set_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_clause(PigParser3Parser.Set_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_value(PigParser3Parser.Property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#register_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegister_clause(PigParser3Parser.Register_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#property_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_name(PigParser3Parser.Property_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#realias_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealias_clause(PigParser3Parser.Realias_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#parallel_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallel_clause(PigParser3Parser.Parallel_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#op_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_clause(PigParser3Parser.Op_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#rmf_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRmf_clause(PigParser3Parser.Rmf_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#dump_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDump_clause(PigParser3Parser.Dump_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#ship_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShip_clause(PigParser3Parser.Ship_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#path_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath_list(PigParser3Parser.Path_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#cache_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCache_clause(PigParser3Parser.Cache_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#input_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput_clause(PigParser3Parser.Input_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#output_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput_clause(PigParser3Parser.Output_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#error_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitError_clause(PigParser3Parser.Error_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#load_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad_clause(PigParser3Parser.Load_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#func_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_clause(PigParser3Parser.Func_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#func_name_zero_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_name_zero_args(PigParser3Parser.Func_name_zero_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#func_name_with_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_name_with_args(PigParser3Parser.Func_name_with_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#func_name_without_columns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_name_without_columns(PigParser3Parser.Func_name_without_columnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#func_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_name(PigParser3Parser.Func_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#func_args_string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_args_string(PigParser3Parser.Func_args_stringContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#func_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_args(PigParser3Parser.Func_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#group_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_clause(PigParser3Parser.Group_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#group_item_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_item_list(PigParser3Parser.Group_item_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#group_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_item(PigParser3Parser.Group_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#explicit_field_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_field_def(PigParser3Parser.Explicit_field_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#field_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_def(PigParser3Parser.Field_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#field_def_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_def_list(PigParser3Parser.Field_def_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#as_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs_clause(PigParser3Parser.As_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#stream_cmd_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStream_cmd_list(PigParser3Parser.Stream_cmd_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#stream_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStream_cmd(PigParser3Parser.Stream_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(PigParser3Parser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel(PigParser3Parser.RelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#previous_rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrevious_rel(PigParser3Parser.Previous_relContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#store_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStore_clause(PigParser3Parser.Store_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#filter_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter_clause(PigParser3Parser.Filter_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#stream_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStream_clause(PigParser3Parser.Stream_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#mr_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMr_clause(PigParser3Parser.Mr_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#split_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplit_clause(PigParser3Parser.Split_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#split_branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplit_branch(PigParser3Parser.Split_branchContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#split_otherwise}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplit_otherwise(PigParser3Parser.Split_otherwiseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#limit_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit_clause(PigParser3Parser.Limit_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#sample_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSample_clause(PigParser3Parser.Sample_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#rank_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRank_clause(PigParser3Parser.Rank_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#rank_by_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRank_by_statement(PigParser3Parser.Rank_by_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#rank_by_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRank_by_clause(PigParser3Parser.Rank_by_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#rank_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRank_list(PigParser3Parser.Rank_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#rank_col}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRank_col(PigParser3Parser.Rank_colContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#order_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_clause(PigParser3Parser.Order_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#order_by_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_by_clause(PigParser3Parser.Order_by_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#order_col_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_col_list(PigParser3Parser.Order_col_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#order_col}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_col(PigParser3Parser.Order_colContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#distinct_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistinct_clause(PigParser3Parser.Distinct_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#illustrate_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIllustrate_clause(PigParser3Parser.Illustrate_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#partition_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartition_clause(PigParser3Parser.Partition_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#rel_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_list(PigParser3Parser.Rel_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#cross_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCross_clause(PigParser3Parser.Cross_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#join_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_clause(PigParser3Parser.Join_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#join_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_type(PigParser3Parser.Join_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#join_sub_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_sub_clause(PigParser3Parser.Join_sub_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#join_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_item(PigParser3Parser.Join_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#join_group_by_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_group_by_clause(PigParser3Parser.Join_group_by_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#union_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion_clause(PigParser3Parser.Union_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#cube_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCube_clause(PigParser3Parser.Cube_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#cube_rollup_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCube_rollup_list(PigParser3Parser.Cube_rollup_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#flatten_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlatten_clause(PigParser3Parser.Flatten_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#generate_as_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerate_as_clause(PigParser3Parser.Generate_as_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#flatten_generated_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlatten_generated_item(PigParser3Parser.Flatten_generated_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#real_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_arg(PigParser3Parser.Real_argContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(PigParser3Parser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#not_cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_cond(PigParser3Parser.Not_condContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#unary_cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_cond(PigParser3Parser.Unary_condContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PigParser3Parser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#multi_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulti_expr(PigParser3Parser.Multi_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#func_name_suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_name_suffix(PigParser3Parser.Func_name_suffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#cast_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCast_expr(PigParser3Parser.Cast_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#identifier_with_projection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_with_projection(PigParser3Parser.Identifier_with_projectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#function_name_with_columns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name_with_columns(PigParser3Parser.Function_name_with_columnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(PigParser3Parser.Arg_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#identifier_with_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_with_function(PigParser3Parser.Identifier_with_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#paren_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen_expr(PigParser3Parser.Paren_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#after_left_paren}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfter_left_paren(PigParser3Parser.After_left_parenContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#curly_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurly_expr(PigParser3Parser.Curly_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#bracket_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracket_expr(PigParser3Parser.Bracket_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#projection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(PigParser3Parser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#col_ref_without_identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCol_ref_without_identifier(PigParser3Parser.Col_ref_without_identifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#col_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCol_ref(PigParser3Parser.Col_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#col_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCol_range(PigParser3Parser.Col_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#scalar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalar(PigParser3Parser.ScalarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#keyvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue(PigParser3Parser.KeyvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#literal_map}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_map(PigParser3Parser.Literal_mapContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#literal_bag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_bag(PigParser3Parser.Literal_bagContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#literal_tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_tuple(PigParser3Parser.Literal_tupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(PigParser3Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_blk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_blk(PigParser3Parser.Nested_blkContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_command(PigParser3Parser.Nested_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_op(PigParser3Parser.Nested_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_proj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_proj(PigParser3Parser.Nested_projContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#col_ref_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCol_ref_list(PigParser3Parser.Col_ref_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_filter(PigParser3Parser.Nested_filterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_sort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_sort(PigParser3Parser.Nested_sortContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_distinct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_distinct(PigParser3Parser.Nested_distinctContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_limit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_limit(PigParser3Parser.Nested_limitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_cross}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_cross(PigParser3Parser.Nested_crossContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_foreach}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_foreach(PigParser3Parser.Nested_foreachContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_op_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_op_input(PigParser3Parser.Nested_op_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#nested_op_input_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_op_input_list(PigParser3Parser.Nested_op_input_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#eid_without_columns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEid_without_columns(PigParser3Parser.Eid_without_columnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#eid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEid(PigParser3Parser.EidContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_op(PigParser3Parser.Rel_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigParser3Parser#rel_str_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_str_op(PigParser3Parser.Rel_str_opContext ctx);
}