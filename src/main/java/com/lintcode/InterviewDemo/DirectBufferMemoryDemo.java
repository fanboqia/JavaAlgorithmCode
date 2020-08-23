package com.lintcode.InterviewDemo;

import java.nio.ByteBuffer;

//堆外直接内存超出限制
//-Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m -XX:+PrintGCDetails
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("MaxDirectMemory:"+sun.misc.VM.maxDirectMemory() / ((double) 1024 / 1024) + "MB" );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
