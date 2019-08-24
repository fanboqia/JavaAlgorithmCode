package com.lintcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestUniquePath {

    @Test
    public void testUniquePath(){
        //assertTrue(new UniquePath().uniquePaths(1,3) == 1);
        //assertTrue(new UniquePath().uniquePaths(2,3) == 3);
        assertTrue(new UniquePath().uniquePaths2(3,3) == 6);
        //assertTrue(new UniquePath().uniquePaths(6,63) == 9657648);
        //assertTrue(new UniquePath().uniquePaths2(6,63) == 9657648);
    }
}
