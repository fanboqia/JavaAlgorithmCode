package com.lintcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestStackToQueue {

    @Test
    public void testStackToQueue(){
        TwoStackToQueue queue = new TwoStackToQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("top:"+queue.top());
        System.out.println(queue.pop());
        System.out.println("top:"+queue.top());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println("top:"+queue.top());
    }
}
