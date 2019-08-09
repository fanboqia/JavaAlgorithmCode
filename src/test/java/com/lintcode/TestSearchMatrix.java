package com.lintcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestSearchMatrix {

    @Test
    public void testMinSubArray(){
        int[][] matrix = new int[][]{{1,4,5},{6,7,8}};
        assertTrue(SearchMatrix.searchMatrix(matrix,6)==true);
    }
}
