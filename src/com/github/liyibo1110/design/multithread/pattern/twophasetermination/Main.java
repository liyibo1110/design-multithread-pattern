package com.github.liyibo1110.design.multithread.pattern.twophasetermination;

public class Main {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try {
            CountUpThread t = new CountUpThread();
            t.start();
            // 运行10秒
            Thread.sleep(10000);
            // 对线程发出终止请求
            System.out.println("main: shutdownRequest");
            t.shutdownRequest();
            System.out.println("main: join");
            // 等待线程终止
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: END");
    }
}
