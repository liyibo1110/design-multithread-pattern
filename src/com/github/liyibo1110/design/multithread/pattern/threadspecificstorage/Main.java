package com.github.liyibo1110.design.multithread.pattern.threadspecificstorage;

public class Main {

    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }
}
