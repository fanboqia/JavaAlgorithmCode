package com.lintcode;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestLCS {

    @Test
    public void testLCS()
    {
        assertTrue(LongestCommonSubstring.longestCommonSubstring("abc","a") == 1);
        assertTrue(LongestCommonSubstring.longestCommonSubstring("abc","ab") == 2);
    }
}
