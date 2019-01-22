// Generated from /Users/xiaoli/IdeaProjects/common-utils/src/main/resources/PigParser3.g4 by ANTLR 4.7
package com.anshishagua.pigparser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PigParser3Parser}.
 */
public interface PigParser3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#pigFile}.
	 * @param ctx the parse tree
	 */
	void enterPigFile(PigParser3Parser.PigFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#pigFile}.
	 * @param ctx the parse tree
	 */
	void exitPigFile(PigParser3Parser.PigFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PigParser3Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PigParser3Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#empty_statement}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_statement(PigParser3Parser.Empty_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#empty_statement}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_statement(PigParser3Parser.Empty_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#declare_statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_statement(PigParser3Parser.Declare_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#declare_statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_statement(PigParser3Parser.Declare_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#default_statement}.
	 * @param ctx the parse tree
	 */
	void enterDefault_statement(PigParser3Parser.Default_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#default_statement}.
	 * @param ctx the parse tree
	 */
	void exitDefault_statement(PigParser3Parser.Default_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_op_clause}.
	 * @param ctx the parse tree
	 */
	void enterNested_op_clause(PigParser3Parser.Nested_op_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_op_clause}.
	 * @param ctx the parse tree
	 */
	void exitNested_op_clause(PigParser3Parser.Nested_op_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#general_statement}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_statement(PigParser3Parser.General_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#general_statement}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_statement(PigParser3Parser.General_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#identifier_assignment}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_assignment(PigParser3Parser.Identifier_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#identifier_assignment}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_assignment(PigParser3Parser.Identifier_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#foreach_statement}.
	 * @param ctx the parse tree
	 */
	void enterForeach_statement(PigParser3Parser.Foreach_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#foreach_statement}.
	 * @param ctx the parse tree
	 */
	void exitForeach_statement(PigParser3Parser.Foreach_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#foreach_assignment}.
	 * @param ctx the parse tree
	 */
	void enterForeach_assignment(PigParser3Parser.Foreach_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#foreach_assignment}.
	 * @param ctx the parse tree
	 */
	void exitForeach_assignment(PigParser3Parser.Foreach_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#foreach_plan_complex}.
	 * @param ctx the parse tree
	 */
	void enterForeach_plan_complex(PigParser3Parser.Foreach_plan_complexContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#foreach_plan_complex}.
	 * @param ctx the parse tree
	 */
	void exitForeach_plan_complex(PigParser3Parser.Foreach_plan_complexContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#foreach_generate_simple}.
	 * @param ctx the parse tree
	 */
	void enterForeach_generate_simple(PigParser3Parser.Foreach_generate_simpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#foreach_generate_simple}.
	 * @param ctx the parse tree
	 */
	void exitForeach_generate_simple(PigParser3Parser.Foreach_generate_simpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#macro_content}.
	 * @param ctx the parse tree
	 */
	void enterMacro_content(PigParser3Parser.Macro_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#macro_content}.
	 * @param ctx the parse tree
	 */
	void exitMacro_content(PigParser3Parser.Macro_contentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#macro_param_clause}.
	 * @param ctx the parse tree
	 */
	void enterMacro_param_clause(PigParser3Parser.Macro_param_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#macro_param_clause}.
	 * @param ctx the parse tree
	 */
	void exitMacro_param_clause(PigParser3Parser.Macro_param_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#macro_return_clause}.
	 * @param ctx the parse tree
	 */
	void enterMacro_return_clause(PigParser3Parser.Macro_return_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#macro_return_clause}.
	 * @param ctx the parse tree
	 */
	void exitMacro_return_clause(PigParser3Parser.Macro_return_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#macro_body_clause}.
	 * @param ctx the parse tree
	 */
	void enterMacro_body_clause(PigParser3Parser.Macro_body_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#macro_body_clause}.
	 * @param ctx the parse tree
	 */
	void exitMacro_body_clause(PigParser3Parser.Macro_body_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#macro_clause}.
	 * @param ctx the parse tree
	 */
	void enterMacro_clause(PigParser3Parser.Macro_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#macro_clause}.
	 * @param ctx the parse tree
	 */
	void exitMacro_clause(PigParser3Parser.Macro_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#inline_return_clause}.
	 * @param ctx the parse tree
	 */
	void enterInline_return_clause(PigParser3Parser.Inline_return_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#inline_return_clause}.
	 * @param ctx the parse tree
	 */
	void exitInline_return_clause(PigParser3Parser.Inline_return_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(PigParser3Parser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(PigParser3Parser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#inline_param_clause}.
	 * @param ctx the parse tree
	 */
	void enterInline_param_clause(PigParser3Parser.Inline_param_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#inline_param_clause}.
	 * @param ctx the parse tree
	 */
	void exitInline_param_clause(PigParser3Parser.Inline_param_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#inline_clause}.
	 * @param ctx the parse tree
	 */
	void enterInline_clause(PigParser3Parser.Inline_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#inline_clause}.
	 * @param ctx the parse tree
	 */
	void exitInline_clause(PigParser3Parser.Inline_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#simple_type}.
	 * @param ctx the parse tree
	 */
	void enterSimple_type(PigParser3Parser.Simple_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#simple_type}.
	 * @param ctx the parse tree
	 */
	void exitSimple_type(PigParser3Parser.Simple_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#implicit_tuple_type}.
	 * @param ctx the parse tree
	 */
	void enterImplicit_tuple_type(PigParser3Parser.Implicit_tuple_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#implicit_tuple_type}.
	 * @param ctx the parse tree
	 */
	void exitImplicit_tuple_type(PigParser3Parser.Implicit_tuple_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#explicit_tuple_type}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_tuple_type(PigParser3Parser.Explicit_tuple_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#explicit_tuple_type}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_tuple_type(PigParser3Parser.Explicit_tuple_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#explicit_tuple_type_cast}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_tuple_type_cast(PigParser3Parser.Explicit_tuple_type_castContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#explicit_tuple_type_cast}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_tuple_type_cast(PigParser3Parser.Explicit_tuple_type_castContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#tuple_type}.
	 * @param ctx the parse tree
	 */
	void enterTuple_type(PigParser3Parser.Tuple_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#tuple_type}.
	 * @param ctx the parse tree
	 */
	void exitTuple_type(PigParser3Parser.Tuple_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#implicit_bag_type}.
	 * @param ctx the parse tree
	 */
	void enterImplicit_bag_type(PigParser3Parser.Implicit_bag_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#implicit_bag_type}.
	 * @param ctx the parse tree
	 */
	void exitImplicit_bag_type(PigParser3Parser.Implicit_bag_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#explicit_bag_type}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_bag_type(PigParser3Parser.Explicit_bag_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#explicit_bag_type}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_bag_type(PigParser3Parser.Explicit_bag_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#explicit_bag_type_cast}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_bag_type_cast(PigParser3Parser.Explicit_bag_type_castContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#explicit_bag_type_cast}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_bag_type_cast(PigParser3Parser.Explicit_bag_type_castContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#implicit_map_type}.
	 * @param ctx the parse tree
	 */
	void enterImplicit_map_type(PigParser3Parser.Implicit_map_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#implicit_map_type}.
	 * @param ctx the parse tree
	 */
	void exitImplicit_map_type(PigParser3Parser.Implicit_map_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#explicit_map_type}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_map_type(PigParser3Parser.Explicit_map_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#explicit_map_type}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_map_type(PigParser3Parser.Explicit_map_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#map_type}.
	 * @param ctx the parse tree
	 */
	void enterMap_type(PigParser3Parser.Map_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#map_type}.
	 * @param ctx the parse tree
	 */
	void exitMap_type(PigParser3Parser.Map_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#explicit_type}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_type(PigParser3Parser.Explicit_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#explicit_type}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_type(PigParser3Parser.Explicit_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#implicit_type}.
	 * @param ctx the parse tree
	 */
	void enterImplicit_type(PigParser3Parser.Implicit_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#implicit_type}.
	 * @param ctx the parse tree
	 */
	void exitImplicit_type(PigParser3Parser.Implicit_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PigParser3Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PigParser3Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#explicit_type_cast}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_type_cast(PigParser3Parser.Explicit_type_castContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#explicit_type_cast}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_type_cast(PigParser3Parser.Explicit_type_castContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#import_clause}.
	 * @param ctx the parse tree
	 */
	void enterImport_clause(PigParser3Parser.Import_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#import_clause}.
	 * @param ctx the parse tree
	 */
	void exitImport_clause(PigParser3Parser.Import_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#define_clause}.
	 * @param ctx the parse tree
	 */
	void enterDefine_clause(PigParser3Parser.Define_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#define_clause}.
	 * @param ctx the parse tree
	 */
	void exitDefine_clause(PigParser3Parser.Define_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#set_clause}.
	 * @param ctx the parse tree
	 */
	void enterSet_clause(PigParser3Parser.Set_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#set_clause}.
	 * @param ctx the parse tree
	 */
	void exitSet_clause(PigParser3Parser.Set_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#property_value}.
	 * @param ctx the parse tree
	 */
	void enterProperty_value(PigParser3Parser.Property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#property_value}.
	 * @param ctx the parse tree
	 */
	void exitProperty_value(PigParser3Parser.Property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#register_clause}.
	 * @param ctx the parse tree
	 */
	void enterRegister_clause(PigParser3Parser.Register_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#register_clause}.
	 * @param ctx the parse tree
	 */
	void exitRegister_clause(PigParser3Parser.Register_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#property_name}.
	 * @param ctx the parse tree
	 */
	void enterProperty_name(PigParser3Parser.Property_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#property_name}.
	 * @param ctx the parse tree
	 */
	void exitProperty_name(PigParser3Parser.Property_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#realias_clause}.
	 * @param ctx the parse tree
	 */
	void enterRealias_clause(PigParser3Parser.Realias_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#realias_clause}.
	 * @param ctx the parse tree
	 */
	void exitRealias_clause(PigParser3Parser.Realias_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#parallel_clause}.
	 * @param ctx the parse tree
	 */
	void enterParallel_clause(PigParser3Parser.Parallel_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#parallel_clause}.
	 * @param ctx the parse tree
	 */
	void exitParallel_clause(PigParser3Parser.Parallel_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#op_clause}.
	 * @param ctx the parse tree
	 */
	void enterOp_clause(PigParser3Parser.Op_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#op_clause}.
	 * @param ctx the parse tree
	 */
	void exitOp_clause(PigParser3Parser.Op_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#rmf_clause}.
	 * @param ctx the parse tree
	 */
	void enterRmf_clause(PigParser3Parser.Rmf_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#rmf_clause}.
	 * @param ctx the parse tree
	 */
	void exitRmf_clause(PigParser3Parser.Rmf_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#dump_clause}.
	 * @param ctx the parse tree
	 */
	void enterDump_clause(PigParser3Parser.Dump_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#dump_clause}.
	 * @param ctx the parse tree
	 */
	void exitDump_clause(PigParser3Parser.Dump_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#ship_clause}.
	 * @param ctx the parse tree
	 */
	void enterShip_clause(PigParser3Parser.Ship_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#ship_clause}.
	 * @param ctx the parse tree
	 */
	void exitShip_clause(PigParser3Parser.Ship_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#path_list}.
	 * @param ctx the parse tree
	 */
	void enterPath_list(PigParser3Parser.Path_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#path_list}.
	 * @param ctx the parse tree
	 */
	void exitPath_list(PigParser3Parser.Path_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#cache_clause}.
	 * @param ctx the parse tree
	 */
	void enterCache_clause(PigParser3Parser.Cache_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#cache_clause}.
	 * @param ctx the parse tree
	 */
	void exitCache_clause(PigParser3Parser.Cache_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#input_clause}.
	 * @param ctx the parse tree
	 */
	void enterInput_clause(PigParser3Parser.Input_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#input_clause}.
	 * @param ctx the parse tree
	 */
	void exitInput_clause(PigParser3Parser.Input_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#output_clause}.
	 * @param ctx the parse tree
	 */
	void enterOutput_clause(PigParser3Parser.Output_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#output_clause}.
	 * @param ctx the parse tree
	 */
	void exitOutput_clause(PigParser3Parser.Output_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#error_clause}.
	 * @param ctx the parse tree
	 */
	void enterError_clause(PigParser3Parser.Error_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#error_clause}.
	 * @param ctx the parse tree
	 */
	void exitError_clause(PigParser3Parser.Error_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#load_clause}.
	 * @param ctx the parse tree
	 */
	void enterLoad_clause(PigParser3Parser.Load_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#load_clause}.
	 * @param ctx the parse tree
	 */
	void exitLoad_clause(PigParser3Parser.Load_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#func_clause}.
	 * @param ctx the parse tree
	 */
	void enterFunc_clause(PigParser3Parser.Func_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#func_clause}.
	 * @param ctx the parse tree
	 */
	void exitFunc_clause(PigParser3Parser.Func_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#func_name_zero_args}.
	 * @param ctx the parse tree
	 */
	void enterFunc_name_zero_args(PigParser3Parser.Func_name_zero_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#func_name_zero_args}.
	 * @param ctx the parse tree
	 */
	void exitFunc_name_zero_args(PigParser3Parser.Func_name_zero_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#func_name_with_args}.
	 * @param ctx the parse tree
	 */
	void enterFunc_name_with_args(PigParser3Parser.Func_name_with_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#func_name_with_args}.
	 * @param ctx the parse tree
	 */
	void exitFunc_name_with_args(PigParser3Parser.Func_name_with_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#func_name_without_columns}.
	 * @param ctx the parse tree
	 */
	void enterFunc_name_without_columns(PigParser3Parser.Func_name_without_columnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#func_name_without_columns}.
	 * @param ctx the parse tree
	 */
	void exitFunc_name_without_columns(PigParser3Parser.Func_name_without_columnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#func_name}.
	 * @param ctx the parse tree
	 */
	void enterFunc_name(PigParser3Parser.Func_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#func_name}.
	 * @param ctx the parse tree
	 */
	void exitFunc_name(PigParser3Parser.Func_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#func_args_string}.
	 * @param ctx the parse tree
	 */
	void enterFunc_args_string(PigParser3Parser.Func_args_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#func_args_string}.
	 * @param ctx the parse tree
	 */
	void exitFunc_args_string(PigParser3Parser.Func_args_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#func_args}.
	 * @param ctx the parse tree
	 */
	void enterFunc_args(PigParser3Parser.Func_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#func_args}.
	 * @param ctx the parse tree
	 */
	void exitFunc_args(PigParser3Parser.Func_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#group_clause}.
	 * @param ctx the parse tree
	 */
	void enterGroup_clause(PigParser3Parser.Group_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#group_clause}.
	 * @param ctx the parse tree
	 */
	void exitGroup_clause(PigParser3Parser.Group_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#group_item_list}.
	 * @param ctx the parse tree
	 */
	void enterGroup_item_list(PigParser3Parser.Group_item_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#group_item_list}.
	 * @param ctx the parse tree
	 */
	void exitGroup_item_list(PigParser3Parser.Group_item_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#group_item}.
	 * @param ctx the parse tree
	 */
	void enterGroup_item(PigParser3Parser.Group_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#group_item}.
	 * @param ctx the parse tree
	 */
	void exitGroup_item(PigParser3Parser.Group_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#explicit_field_def}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_field_def(PigParser3Parser.Explicit_field_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#explicit_field_def}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_field_def(PigParser3Parser.Explicit_field_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#field_def}.
	 * @param ctx the parse tree
	 */
	void enterField_def(PigParser3Parser.Field_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#field_def}.
	 * @param ctx the parse tree
	 */
	void exitField_def(PigParser3Parser.Field_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#field_def_list}.
	 * @param ctx the parse tree
	 */
	void enterField_def_list(PigParser3Parser.Field_def_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#field_def_list}.
	 * @param ctx the parse tree
	 */
	void exitField_def_list(PigParser3Parser.Field_def_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#as_clause}.
	 * @param ctx the parse tree
	 */
	void enterAs_clause(PigParser3Parser.As_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#as_clause}.
	 * @param ctx the parse tree
	 */
	void exitAs_clause(PigParser3Parser.As_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#stream_cmd_list}.
	 * @param ctx the parse tree
	 */
	void enterStream_cmd_list(PigParser3Parser.Stream_cmd_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#stream_cmd_list}.
	 * @param ctx the parse tree
	 */
	void exitStream_cmd_list(PigParser3Parser.Stream_cmd_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#stream_cmd}.
	 * @param ctx the parse tree
	 */
	void enterStream_cmd(PigParser3Parser.Stream_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#stream_cmd}.
	 * @param ctx the parse tree
	 */
	void exitStream_cmd(PigParser3Parser.Stream_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(PigParser3Parser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(PigParser3Parser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#rel}.
	 * @param ctx the parse tree
	 */
	void enterRel(PigParser3Parser.RelContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#rel}.
	 * @param ctx the parse tree
	 */
	void exitRel(PigParser3Parser.RelContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#previous_rel}.
	 * @param ctx the parse tree
	 */
	void enterPrevious_rel(PigParser3Parser.Previous_relContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#previous_rel}.
	 * @param ctx the parse tree
	 */
	void exitPrevious_rel(PigParser3Parser.Previous_relContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#store_clause}.
	 * @param ctx the parse tree
	 */
	void enterStore_clause(PigParser3Parser.Store_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#store_clause}.
	 * @param ctx the parse tree
	 */
	void exitStore_clause(PigParser3Parser.Store_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#filter_clause}.
	 * @param ctx the parse tree
	 */
	void enterFilter_clause(PigParser3Parser.Filter_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#filter_clause}.
	 * @param ctx the parse tree
	 */
	void exitFilter_clause(PigParser3Parser.Filter_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#stream_clause}.
	 * @param ctx the parse tree
	 */
	void enterStream_clause(PigParser3Parser.Stream_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#stream_clause}.
	 * @param ctx the parse tree
	 */
	void exitStream_clause(PigParser3Parser.Stream_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#mr_clause}.
	 * @param ctx the parse tree
	 */
	void enterMr_clause(PigParser3Parser.Mr_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#mr_clause}.
	 * @param ctx the parse tree
	 */
	void exitMr_clause(PigParser3Parser.Mr_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#split_clause}.
	 * @param ctx the parse tree
	 */
	void enterSplit_clause(PigParser3Parser.Split_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#split_clause}.
	 * @param ctx the parse tree
	 */
	void exitSplit_clause(PigParser3Parser.Split_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#split_branch}.
	 * @param ctx the parse tree
	 */
	void enterSplit_branch(PigParser3Parser.Split_branchContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#split_branch}.
	 * @param ctx the parse tree
	 */
	void exitSplit_branch(PigParser3Parser.Split_branchContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#split_otherwise}.
	 * @param ctx the parse tree
	 */
	void enterSplit_otherwise(PigParser3Parser.Split_otherwiseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#split_otherwise}.
	 * @param ctx the parse tree
	 */
	void exitSplit_otherwise(PigParser3Parser.Split_otherwiseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void enterLimit_clause(PigParser3Parser.Limit_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void exitLimit_clause(PigParser3Parser.Limit_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#sample_clause}.
	 * @param ctx the parse tree
	 */
	void enterSample_clause(PigParser3Parser.Sample_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#sample_clause}.
	 * @param ctx the parse tree
	 */
	void exitSample_clause(PigParser3Parser.Sample_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#rank_clause}.
	 * @param ctx the parse tree
	 */
	void enterRank_clause(PigParser3Parser.Rank_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#rank_clause}.
	 * @param ctx the parse tree
	 */
	void exitRank_clause(PigParser3Parser.Rank_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#rank_by_statement}.
	 * @param ctx the parse tree
	 */
	void enterRank_by_statement(PigParser3Parser.Rank_by_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#rank_by_statement}.
	 * @param ctx the parse tree
	 */
	void exitRank_by_statement(PigParser3Parser.Rank_by_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#rank_by_clause}.
	 * @param ctx the parse tree
	 */
	void enterRank_by_clause(PigParser3Parser.Rank_by_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#rank_by_clause}.
	 * @param ctx the parse tree
	 */
	void exitRank_by_clause(PigParser3Parser.Rank_by_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#rank_list}.
	 * @param ctx the parse tree
	 */
	void enterRank_list(PigParser3Parser.Rank_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#rank_list}.
	 * @param ctx the parse tree
	 */
	void exitRank_list(PigParser3Parser.Rank_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#rank_col}.
	 * @param ctx the parse tree
	 */
	void enterRank_col(PigParser3Parser.Rank_colContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#rank_col}.
	 * @param ctx the parse tree
	 */
	void exitRank_col(PigParser3Parser.Rank_colContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#order_clause}.
	 * @param ctx the parse tree
	 */
	void enterOrder_clause(PigParser3Parser.Order_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#order_clause}.
	 * @param ctx the parse tree
	 */
	void exitOrder_clause(PigParser3Parser.Order_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_clause(PigParser3Parser.Order_by_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_clause(PigParser3Parser.Order_by_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#order_col_list}.
	 * @param ctx the parse tree
	 */
	void enterOrder_col_list(PigParser3Parser.Order_col_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#order_col_list}.
	 * @param ctx the parse tree
	 */
	void exitOrder_col_list(PigParser3Parser.Order_col_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#order_col}.
	 * @param ctx the parse tree
	 */
	void enterOrder_col(PigParser3Parser.Order_colContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#order_col}.
	 * @param ctx the parse tree
	 */
	void exitOrder_col(PigParser3Parser.Order_colContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#distinct_clause}.
	 * @param ctx the parse tree
	 */
	void enterDistinct_clause(PigParser3Parser.Distinct_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#distinct_clause}.
	 * @param ctx the parse tree
	 */
	void exitDistinct_clause(PigParser3Parser.Distinct_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#illustrate_clause}.
	 * @param ctx the parse tree
	 */
	void enterIllustrate_clause(PigParser3Parser.Illustrate_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#illustrate_clause}.
	 * @param ctx the parse tree
	 */
	void exitIllustrate_clause(PigParser3Parser.Illustrate_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#partition_clause}.
	 * @param ctx the parse tree
	 */
	void enterPartition_clause(PigParser3Parser.Partition_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#partition_clause}.
	 * @param ctx the parse tree
	 */
	void exitPartition_clause(PigParser3Parser.Partition_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#rel_list}.
	 * @param ctx the parse tree
	 */
	void enterRel_list(PigParser3Parser.Rel_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#rel_list}.
	 * @param ctx the parse tree
	 */
	void exitRel_list(PigParser3Parser.Rel_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#cross_clause}.
	 * @param ctx the parse tree
	 */
	void enterCross_clause(PigParser3Parser.Cross_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#cross_clause}.
	 * @param ctx the parse tree
	 */
	void exitCross_clause(PigParser3Parser.Cross_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#join_clause}.
	 * @param ctx the parse tree
	 */
	void enterJoin_clause(PigParser3Parser.Join_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#join_clause}.
	 * @param ctx the parse tree
	 */
	void exitJoin_clause(PigParser3Parser.Join_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#join_type}.
	 * @param ctx the parse tree
	 */
	void enterJoin_type(PigParser3Parser.Join_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#join_type}.
	 * @param ctx the parse tree
	 */
	void exitJoin_type(PigParser3Parser.Join_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#join_sub_clause}.
	 * @param ctx the parse tree
	 */
	void enterJoin_sub_clause(PigParser3Parser.Join_sub_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#join_sub_clause}.
	 * @param ctx the parse tree
	 */
	void exitJoin_sub_clause(PigParser3Parser.Join_sub_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#join_item}.
	 * @param ctx the parse tree
	 */
	void enterJoin_item(PigParser3Parser.Join_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#join_item}.
	 * @param ctx the parse tree
	 */
	void exitJoin_item(PigParser3Parser.Join_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#join_group_by_clause}.
	 * @param ctx the parse tree
	 */
	void enterJoin_group_by_clause(PigParser3Parser.Join_group_by_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#join_group_by_clause}.
	 * @param ctx the parse tree
	 */
	void exitJoin_group_by_clause(PigParser3Parser.Join_group_by_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#union_clause}.
	 * @param ctx the parse tree
	 */
	void enterUnion_clause(PigParser3Parser.Union_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#union_clause}.
	 * @param ctx the parse tree
	 */
	void exitUnion_clause(PigParser3Parser.Union_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#cube_clause}.
	 * @param ctx the parse tree
	 */
	void enterCube_clause(PigParser3Parser.Cube_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#cube_clause}.
	 * @param ctx the parse tree
	 */
	void exitCube_clause(PigParser3Parser.Cube_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#cube_rollup_list}.
	 * @param ctx the parse tree
	 */
	void enterCube_rollup_list(PigParser3Parser.Cube_rollup_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#cube_rollup_list}.
	 * @param ctx the parse tree
	 */
	void exitCube_rollup_list(PigParser3Parser.Cube_rollup_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#flatten_clause}.
	 * @param ctx the parse tree
	 */
	void enterFlatten_clause(PigParser3Parser.Flatten_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#flatten_clause}.
	 * @param ctx the parse tree
	 */
	void exitFlatten_clause(PigParser3Parser.Flatten_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#generate_as_clause}.
	 * @param ctx the parse tree
	 */
	void enterGenerate_as_clause(PigParser3Parser.Generate_as_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#generate_as_clause}.
	 * @param ctx the parse tree
	 */
	void exitGenerate_as_clause(PigParser3Parser.Generate_as_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#flatten_generated_item}.
	 * @param ctx the parse tree
	 */
	void enterFlatten_generated_item(PigParser3Parser.Flatten_generated_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#flatten_generated_item}.
	 * @param ctx the parse tree
	 */
	void exitFlatten_generated_item(PigParser3Parser.Flatten_generated_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#real_arg}.
	 * @param ctx the parse tree
	 */
	void enterReal_arg(PigParser3Parser.Real_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#real_arg}.
	 * @param ctx the parse tree
	 */
	void exitReal_arg(PigParser3Parser.Real_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(PigParser3Parser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(PigParser3Parser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#not_cond}.
	 * @param ctx the parse tree
	 */
	void enterNot_cond(PigParser3Parser.Not_condContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#not_cond}.
	 * @param ctx the parse tree
	 */
	void exitNot_cond(PigParser3Parser.Not_condContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#unary_cond}.
	 * @param ctx the parse tree
	 */
	void enterUnary_cond(PigParser3Parser.Unary_condContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#unary_cond}.
	 * @param ctx the parse tree
	 */
	void exitUnary_cond(PigParser3Parser.Unary_condContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PigParser3Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PigParser3Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#multi_expr}.
	 * @param ctx the parse tree
	 */
	void enterMulti_expr(PigParser3Parser.Multi_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#multi_expr}.
	 * @param ctx the parse tree
	 */
	void exitMulti_expr(PigParser3Parser.Multi_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#func_name_suffix}.
	 * @param ctx the parse tree
	 */
	void enterFunc_name_suffix(PigParser3Parser.Func_name_suffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#func_name_suffix}.
	 * @param ctx the parse tree
	 */
	void exitFunc_name_suffix(PigParser3Parser.Func_name_suffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#cast_expr}.
	 * @param ctx the parse tree
	 */
	void enterCast_expr(PigParser3Parser.Cast_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#cast_expr}.
	 * @param ctx the parse tree
	 */
	void exitCast_expr(PigParser3Parser.Cast_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#identifier_with_projection}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_with_projection(PigParser3Parser.Identifier_with_projectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#identifier_with_projection}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_with_projection(PigParser3Parser.Identifier_with_projectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#function_name_with_columns}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name_with_columns(PigParser3Parser.Function_name_with_columnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#function_name_with_columns}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name_with_columns(PigParser3Parser.Function_name_with_columnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(PigParser3Parser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(PigParser3Parser.Arg_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#identifier_with_function}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_with_function(PigParser3Parser.Identifier_with_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#identifier_with_function}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_with_function(PigParser3Parser.Identifier_with_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#paren_expr}.
	 * @param ctx the parse tree
	 */
	void enterParen_expr(PigParser3Parser.Paren_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#paren_expr}.
	 * @param ctx the parse tree
	 */
	void exitParen_expr(PigParser3Parser.Paren_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#after_left_paren}.
	 * @param ctx the parse tree
	 */
	void enterAfter_left_paren(PigParser3Parser.After_left_parenContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#after_left_paren}.
	 * @param ctx the parse tree
	 */
	void exitAfter_left_paren(PigParser3Parser.After_left_parenContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#curly_expr}.
	 * @param ctx the parse tree
	 */
	void enterCurly_expr(PigParser3Parser.Curly_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#curly_expr}.
	 * @param ctx the parse tree
	 */
	void exitCurly_expr(PigParser3Parser.Curly_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#bracket_expr}.
	 * @param ctx the parse tree
	 */
	void enterBracket_expr(PigParser3Parser.Bracket_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#bracket_expr}.
	 * @param ctx the parse tree
	 */
	void exitBracket_expr(PigParser3Parser.Bracket_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#projection}.
	 * @param ctx the parse tree
	 */
	void enterProjection(PigParser3Parser.ProjectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#projection}.
	 * @param ctx the parse tree
	 */
	void exitProjection(PigParser3Parser.ProjectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#col_ref_without_identifier}.
	 * @param ctx the parse tree
	 */
	void enterCol_ref_without_identifier(PigParser3Parser.Col_ref_without_identifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#col_ref_without_identifier}.
	 * @param ctx the parse tree
	 */
	void exitCol_ref_without_identifier(PigParser3Parser.Col_ref_without_identifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#col_ref}.
	 * @param ctx the parse tree
	 */
	void enterCol_ref(PigParser3Parser.Col_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#col_ref}.
	 * @param ctx the parse tree
	 */
	void exitCol_ref(PigParser3Parser.Col_refContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#col_range}.
	 * @param ctx the parse tree
	 */
	void enterCol_range(PigParser3Parser.Col_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#col_range}.
	 * @param ctx the parse tree
	 */
	void exitCol_range(PigParser3Parser.Col_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#scalar}.
	 * @param ctx the parse tree
	 */
	void enterScalar(PigParser3Parser.ScalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#scalar}.
	 * @param ctx the parse tree
	 */
	void exitScalar(PigParser3Parser.ScalarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void enterKeyvalue(PigParser3Parser.KeyvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void exitKeyvalue(PigParser3Parser.KeyvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#literal_map}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_map(PigParser3Parser.Literal_mapContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#literal_map}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_map(PigParser3Parser.Literal_mapContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#literal_bag}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_bag(PigParser3Parser.Literal_bagContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#literal_bag}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_bag(PigParser3Parser.Literal_bagContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#literal_tuple}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_tuple(PigParser3Parser.Literal_tupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#literal_tuple}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_tuple(PigParser3Parser.Literal_tupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(PigParser3Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(PigParser3Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_blk}.
	 * @param ctx the parse tree
	 */
	void enterNested_blk(PigParser3Parser.Nested_blkContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_blk}.
	 * @param ctx the parse tree
	 */
	void exitNested_blk(PigParser3Parser.Nested_blkContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_command}.
	 * @param ctx the parse tree
	 */
	void enterNested_command(PigParser3Parser.Nested_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_command}.
	 * @param ctx the parse tree
	 */
	void exitNested_command(PigParser3Parser.Nested_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_op}.
	 * @param ctx the parse tree
	 */
	void enterNested_op(PigParser3Parser.Nested_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_op}.
	 * @param ctx the parse tree
	 */
	void exitNested_op(PigParser3Parser.Nested_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_proj}.
	 * @param ctx the parse tree
	 */
	void enterNested_proj(PigParser3Parser.Nested_projContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_proj}.
	 * @param ctx the parse tree
	 */
	void exitNested_proj(PigParser3Parser.Nested_projContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#col_ref_list}.
	 * @param ctx the parse tree
	 */
	void enterCol_ref_list(PigParser3Parser.Col_ref_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#col_ref_list}.
	 * @param ctx the parse tree
	 */
	void exitCol_ref_list(PigParser3Parser.Col_ref_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_filter}.
	 * @param ctx the parse tree
	 */
	void enterNested_filter(PigParser3Parser.Nested_filterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_filter}.
	 * @param ctx the parse tree
	 */
	void exitNested_filter(PigParser3Parser.Nested_filterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_sort}.
	 * @param ctx the parse tree
	 */
	void enterNested_sort(PigParser3Parser.Nested_sortContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_sort}.
	 * @param ctx the parse tree
	 */
	void exitNested_sort(PigParser3Parser.Nested_sortContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_distinct}.
	 * @param ctx the parse tree
	 */
	void enterNested_distinct(PigParser3Parser.Nested_distinctContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_distinct}.
	 * @param ctx the parse tree
	 */
	void exitNested_distinct(PigParser3Parser.Nested_distinctContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_limit}.
	 * @param ctx the parse tree
	 */
	void enterNested_limit(PigParser3Parser.Nested_limitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_limit}.
	 * @param ctx the parse tree
	 */
	void exitNested_limit(PigParser3Parser.Nested_limitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_cross}.
	 * @param ctx the parse tree
	 */
	void enterNested_cross(PigParser3Parser.Nested_crossContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_cross}.
	 * @param ctx the parse tree
	 */
	void exitNested_cross(PigParser3Parser.Nested_crossContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_foreach}.
	 * @param ctx the parse tree
	 */
	void enterNested_foreach(PigParser3Parser.Nested_foreachContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_foreach}.
	 * @param ctx the parse tree
	 */
	void exitNested_foreach(PigParser3Parser.Nested_foreachContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_op_input}.
	 * @param ctx the parse tree
	 */
	void enterNested_op_input(PigParser3Parser.Nested_op_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_op_input}.
	 * @param ctx the parse tree
	 */
	void exitNested_op_input(PigParser3Parser.Nested_op_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#nested_op_input_list}.
	 * @param ctx the parse tree
	 */
	void enterNested_op_input_list(PigParser3Parser.Nested_op_input_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#nested_op_input_list}.
	 * @param ctx the parse tree
	 */
	void exitNested_op_input_list(PigParser3Parser.Nested_op_input_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#eid_without_columns}.
	 * @param ctx the parse tree
	 */
	void enterEid_without_columns(PigParser3Parser.Eid_without_columnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#eid_without_columns}.
	 * @param ctx the parse tree
	 */
	void exitEid_without_columns(PigParser3Parser.Eid_without_columnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#eid}.
	 * @param ctx the parse tree
	 */
	void enterEid(PigParser3Parser.EidContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#eid}.
	 * @param ctx the parse tree
	 */
	void exitEid(PigParser3Parser.EidContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(PigParser3Parser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(PigParser3Parser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigParser3Parser#rel_str_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_str_op(PigParser3Parser.Rel_str_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigParser3Parser#rel_str_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_str_op(PigParser3Parser.Rel_str_opContext ctx);
}