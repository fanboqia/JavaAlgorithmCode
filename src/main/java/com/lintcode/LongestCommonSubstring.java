package com.lintcode;

public class LongestCommonSubstring {
    public static int longestCommonSubstring(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }

        int n = A.length();
        int m = B.length();

        // 动态规划
        // 初始化：第0行和第0列初始值为0
        int[][] LCS = new int[n + 1][m + 1];
        int max = 0;

        // 计算
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    max = Math.max(max, LCS[i][j]);
                }// else { LCS[i][j] = 0; }
            }
        }

        return max;
    }
}
