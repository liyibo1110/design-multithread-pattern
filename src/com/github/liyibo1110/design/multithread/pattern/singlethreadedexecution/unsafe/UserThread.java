package com.github.liyibo1110.design.multithread.pattern.singlethreadedexecution.unsafe;

public class UserThread extends Thread {

    private final Gate gate;
    private final String name;
    private final String address;

    public UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        System.out.println(name + " BEGIN");
        while(true) {
            gate.pass(name, address);
        }
    }
}
