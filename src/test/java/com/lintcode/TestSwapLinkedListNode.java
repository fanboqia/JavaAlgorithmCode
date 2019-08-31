package com.lintcode;

import com.lintcode.Utils.CommonUtils;
import org.junit.Test;

public class TestSwapLinkedListNode {

    @Test
    public void testBinarySearch()
    {
        int[] arr = new int[]{1,2,3};
        int[] arr1 = new int[]{1,2,3,4};
        //CommonUtils.printList(SwapLinkedListNode.swapPairs(CommonUtils.ArrToList(arr)));
        CommonUtils.printList(SwapLinkedListNode.swapPairs(CommonUtils.ArrToList(arr1)));
    }
}
