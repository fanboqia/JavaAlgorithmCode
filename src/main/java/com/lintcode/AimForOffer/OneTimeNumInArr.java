package com.lintcode.AimForOffer;


//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class OneTimeNumInArr {

    //链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811
    //来源：牛客网

    //当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
    //依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
    public class Solution {
        public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2)    {
            int length = array.length;
            if(length == 2){
                num1[0] = array[0];
                num2[0] = array[1];
                return;
            }
            int bitResult = 0;
            for(int i = 0; i < length; ++i){
                bitResult ^= array[i];
            }
            int index = findFirst1(bitResult);
            for(int i = 0; i < length; ++i){
                if(isBit1(array[i], index)){
                    num1[0] ^= array[i];
                }else{
                    num2[0] ^= array[i];
                }
            }
        }

        private int findFirst1(int bitResult){
            int index = 0;
            while(((bitResult & 1) == 0) && index < 32){
                bitResult >>= 1;
                index++;
            }
            return index;
        }

        private boolean isBit1(int target, int index){
            return ((target >> index) & 1) == 1;
        }
    }

}
