package com.github.liyibo1110.design.multithread.pattern.producerconsumer;

public class Table {

    private final String[] buffer;
    private int tail;   // 下次put的下标
    private int head;   // 下次take的下标
    private int count;

    public Table(int count) {
        buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while(count >= buffer.length) wait();
        buffer[tail] = cake;
        tail = tail + 1 % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while(count <= 0) wait();
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
