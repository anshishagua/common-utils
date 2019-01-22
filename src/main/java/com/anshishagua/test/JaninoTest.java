package com.anshishagua.test;

import com.google.common.collect.Maps;
import org.codehaus.commons.compiler.CompilerFactoryFactory;
import org.codehaus.commons.compiler.IExpressionEvaluator;
import org.springframework.boot.autoconfigure.cache.CacheProperties;

public class JaninoTest {
    public static void main(String[] args) throws Exception {
        // Convert command line argument to call argument "total".
        Object[] arguments = { new Double("11") };

        // Create "ExpressionEvaluator" object.
        IExpressionEvaluator ee = CompilerFactoryFactory.getDefaultCompilerFactory().newExpressionEvaluator();
        ee.setExpressionType(double.class);
        ee.setParameters(new String[] { "total" }, new Class[] { double.class });
        ee.cook("total >= 100.0 ? 0.0 : 7.95");

        // Evaluate expression with actual parameter values.
        Object res = ee.evaluate(arguments);

        // Print expression result.
        System.out.println("Result = " + String.valueOf(res));
        System.out.printf("%012d", Integer.toBinaryString(247));

        Maps maps;
    }
}
