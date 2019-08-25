package com.lintcode;
import com.lintcode.Utils.CommonUtils;
import org.junit.Test;

public class TestMergeTwoLists {

    @Test
    public void testMergeTwoLists() {
        int[] l1 = new int[]{0, 1, 1, 2, 4};
        int[] l2 = new int[]{1, 2, 3};
        MergeTwoLists.mergeTwoLists(CommonUtils.ArrToList(l1), CommonUtils.ArrToList(l2));
    }

    @Test
    public void testMergeTwoLists1() {
        int[] l1 = new int[]{4, 4, 9, 15, 20, 27, 32, 32};
        int[] l2 = new int[]{12,13,14,25,26,37,38};
        MergeTwoLists.mergeTwoLists(CommonUtils.ArrToList(l1), CommonUtils.ArrToList(l2));
    }

}
