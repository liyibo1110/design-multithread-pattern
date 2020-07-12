package com.github.liyibo1110.design.multithread.pattern.twophasetermination;

public class CountUpThread extends GracefulThread {

    private long counter = 0;

    @Override
    protected void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    @Override
    protected void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
