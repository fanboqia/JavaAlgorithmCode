package com.lintcode.AimForOffer;

import java.util.Stack;

public class TwoStackToQueue {

    //链接：https://www.nowcoder.com/questionTerminal/54275ddae22f475981afa2244dd448c6
    //来源：牛客网
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
