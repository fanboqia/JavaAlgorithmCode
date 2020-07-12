package com.lintcode.HuaWei;

import java.util.Scanner;

public class MP3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            sc.nextLine();
            char[] commands = sc.nextLine().toCharArray();
            if(num <= 0){
                continue;
            }
            if(num <= 4){
                int i = 1;
                for(char com : commands){
                    if(com == 'U'){
                        if(i == 1){
                            i = num;
                        }else{
                            i--;
                        }
                    }
                    if(com == 'D'){
                        if(i == num){
                            i = 1;
                        }else{
                            i++;
                        }
                    }
                }
                for(int j = 1; j <= num; j++){
                    System.out.print(j+" ");
                }
                System.out.println();
                System.out.print(i);
            }else{
                int i = 1;
                int j = 1;
                int k = 4;
                for(char com : commands){
                    if(com == 'U'){
                        if(j == 1){
                            i = num - 3;
                            j = num;
                            k = num;
                        }else{
                            if(i == j){
                                i--;
                                k = i + 3;
                            }
                            j--;
                        }
                    }
                    if(com == 'D'){
                        if(j == num){
                            i = 1;
                            j = 1;
                            k = i+3;
                        }else{
                            if(j == k){
                                i++;
                                k = i + 3;
                            }
                            j++;
                        }
                    }
                }
                for(int x = i; x <= k; x++){
                    System.out.print(x+" ");
                }
                System.out.println();
                System.out.print(j);
            }
            System.out.println();
        }
        sc.close();
    }

}
