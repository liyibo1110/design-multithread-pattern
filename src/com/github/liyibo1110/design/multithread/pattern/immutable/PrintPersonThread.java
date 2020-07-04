package com.github.liyibo1110.design.multithread.pattern.immutable;

public class PrintPersonThread extends Thread {

    private Person person;

    public PrintPersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName() + " prints " + person);
        }
    }
}
