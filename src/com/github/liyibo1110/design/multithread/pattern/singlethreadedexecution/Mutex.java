package com.github.liyibo1110.design.multithread.pattern.singlethreadedexecution;

public class Mutex {

    private long locks;
    private Thread owner = null;

    public synchronized void lock() {
        Thread me = Thread.currentThread();
        while(locks > 0 && owner != me) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assert locks == 0  || owner == me;
        owner = me;
        locks++;
    }

    public synchronized void unlock() {
        Thread me = Thread.currentThread();
        if(locks == 0 || owner != me) return;
        assert locks > 0 || owner == me;
        locks--;
        if(locks == 0) {
            owner = null;
            notifyAll();
        }
    }
}
