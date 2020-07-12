package com.github.liyibo1110.design.multithread.pattern.twophasetermination;

public class GracefulThread extends Thread {

    private volatile boolean shutdownRequested = false;

    public final void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    public final boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override
    public void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            doShutdown();
        }
    }

    protected void doWork() throws InterruptedException {

    }

    protected void doShutdown() {

    }
}