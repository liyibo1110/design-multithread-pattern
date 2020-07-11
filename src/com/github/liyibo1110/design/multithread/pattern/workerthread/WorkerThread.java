package com.github.liyibo1110.design.multithread.pattern.workerthread;

public class WorkerThread extends Thread {

    private final Channel channel;
    private volatile boolean terminated = false;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while(!terminated) {
            try {
                Request request = channel.takeRequest();
                // 并不知道具体工作内容
                request.execute();
            } catch (InterruptedException e) {
                terminated = true;
            }
        }
    }

    public void stopThread() {
        terminated = true;
        interrupt();
    }
}
