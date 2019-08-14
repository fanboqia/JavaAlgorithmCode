package com.lintcode;

import java.util.Stack;

/*
* As the title described, you should only use two stacks to implement a queue's actions.

The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

Both pop and top methods should return the value of first element.
*/
public class TwoStackToQueue {

    private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> s2 = new Stack<Integer>();

    public TwoStackToQueue() {
        // do intialization if necessary
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        s1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            if(s2.empty()){
                return -1;
            }else{
                return s2.pop();
            }
        }else{
            if(s2.empty()){
                return -1;
            }else{
                return s2.pop();
            }
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if(!s2.empty()){
            if(s2.empty()){
                return -1;
            }else{
                return s2.peek();
            }
        }else{
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            if(s2.empty()){
                return -1;
            }else{
                return s2.peek();
            }
        }
    }
}
