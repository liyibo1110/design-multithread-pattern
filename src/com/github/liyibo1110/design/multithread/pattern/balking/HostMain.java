package com.github.liyibo1110.design.multithread.pattern.balking;

import java.util.concurrent.TimeoutException;

public class HostMain {

    public static void main(String[] args) {
        Host host = new Host(10000);
        try {
            System.out.println("execute BEGIN");
            host.execute();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
