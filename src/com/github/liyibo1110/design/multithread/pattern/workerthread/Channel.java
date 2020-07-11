package com.github.liyibo1110.design.multithread.pattern.workerthread;

public class Channel {

    private static final int MAX_REQUEST = 100;
    private final Request[] requestQueue;
    private int tail;   // 下次putRequest的位置
    private int head;   // 下次takeRequest的位置
    private int count;

    private final WorkerThread[] threadPool;

    public Channel(int threads) {
        this.requestQueue = new Request[MAX_REQUEST];
        this.tail = 0;
        this.head = 0;
        this.count = 0;

        this.threadPool = new WorkerThread[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void startWorkers() {
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].start();
        }
    }

    public void stopAllWorkers() {
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].stopThread();
        }
    }

    public synchronized void putRequest(Request request) throws InterruptedException {
        while(count >= requestQueue.length) {
           wait();
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() throws InterruptedException {
        while(count <= 0) {
           wait();
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
