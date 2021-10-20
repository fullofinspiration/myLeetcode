package com.fullofinspiration.github.interview;

import org.junit.Test;

public class TreeBuilderTest {
    @Test
    public void test00() {
        TreeBuilder treeBuilder = new TreeBuilder();
        TreeBuilder.Node parse = treeBuilder.parse("A(B(C(,),),E(,))");
        System.out.println(parse);
    }

}