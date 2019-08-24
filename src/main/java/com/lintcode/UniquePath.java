package com.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A robot is located at the top-left corner of a m x n grid.
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
 *
 * How many possible unique paths are there?
 */
public class UniquePath {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        return this.findPaths(new ArrayList<Integer>(),m,n,0,0);
    }

    public int findPaths(List<Integer> count, int m, int n, int i, int j){
        if(i > m - 1 || j > n - 1){
            return 0;
        }
        if(i == m-1 && j == n-1){
            count.add(0);
            return count.size();
        }
        findPaths(count,m,n,i+1,j);
        findPaths(count,m,n,i,j+1);
        return count.size();
    }

    public int uniquePaths2(int m, int n) {
        if(m==0||n==0)
            return 0;
        int[][] array = new int[m][n];
        for(int i=0;i<m;i++)
            array[i][0]=1;
        for(int i=0;i<n;i++)
            array[0][i]=1;
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                array[i][j]=array[i-1][j]+array[i][j-1];
            }
        }
        return array[m-1][n-1];
    }
}
