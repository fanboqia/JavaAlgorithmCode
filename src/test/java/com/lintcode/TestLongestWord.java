package com.lintcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TestLongestWord {

    @Test
    public void testBinarySearch()
    {
        System.out.println(Arrays.toString(LongestWords.longestWords(new String[]{"123","abc","12"}).toArray()));
    }
}
