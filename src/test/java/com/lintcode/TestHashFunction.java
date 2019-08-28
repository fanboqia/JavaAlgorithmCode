package com.lintcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestHashFunction {

    @Test
    public void testHashFunction()
    {
        assertTrue( HashFuncition.hashCode("ubuntu".toCharArray(),1007) == 549);
    }

    @Test
    public void testHashFunction1()
    {
        assertTrue( HashFuncition.hashCode("abcdefghijklmnopqrstuvwxyz".toCharArray(),2607) == 1673);
    }
}
