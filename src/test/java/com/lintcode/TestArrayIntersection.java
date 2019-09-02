package com.lintcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestArrayIntersection {

    @Test
    public void testArrayIntersection()
    {
        //ArrayIntersection.intersection2(new int[]{1,2,2,1},new int[]{2,2});
        //ArrayIntersection.intersection2(new int[]{1},new int[]{1});
        ArrayIntersection.intersection2(new int[]{4,7,9,7,6,7},new int[]{5,0,0,6,1,6,2,2,4});
    }
}
