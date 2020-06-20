package com.lintcode.AimForOffer;

public class JumpFloor {

    //题目描述
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    //f[n] = f[n-1] + f[n-2] + ... + f[0]
    //时间复杂度：O(n2)
    //空间复杂度：O(n)
    public static int JumpFloorII(int target) {
        int[] sum = new int[target+1];
        sum[0] = sum[1] = 1;
        for(int i = 2; i <= target; i++){
            for(int j = 0; j < i; j++ ){
                sum[i] += sum[j];
            }
        }
        return sum[target];
    }

    //易知 f(n)=f(n-1)+f(n-2)+……f(1)
    //f(n-1)=f(n-2)+……f(1)
    //两式相减得f(n)=2f(n-1)
    public static int JumpFloorIIFormula(int target) {
        int[] sum = new int[target+1];
        sum[0] = sum[1] = 1;
        for(int i = 2; i <= target; i++){
            sum[i] = 2*sum[i-1];
        }
        return sum[target];
    }

    public static int JumpFloorIIFormula2(int target) {
        int n = 1;
        for(int i = 2; i <= target; i++){
            n = n << 1;
        }
        return n;
    }

    public static void main(String[] args){
        System.out.println(JumpFloorII(16));
        System.out.println(JumpFloorIIFormula(16));
        System.out.println(JumpFloorIIFormula2(16));
    }
}
