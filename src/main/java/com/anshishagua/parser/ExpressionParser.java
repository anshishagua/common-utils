package com.anshishagua.parser;

import com.anshishagua.object.nodes.Expression;
import com.anshishagua.parser.generated.ExpressionLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * ExpressionParser.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class ExpressionParser {
    public static Expression parse(String string) {
        CharStream inputStream = CharStreams.fromString(string);
        ExpressionLexer lexer = new ExpressionLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        com.anshishagua.parser.generated.ExpressionParser parser = new com.anshishagua.parser.generated.ExpressionParser(tokenStream);

        ParseTree parseTree = parser.start();
        ExpressionVisitor visitor = new ExpressionVisitor();

        Expression expression = visitor.visit(parseTree);

        return expression;
    }
}
