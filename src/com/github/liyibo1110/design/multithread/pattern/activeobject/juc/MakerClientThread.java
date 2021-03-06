package com.github.liyibo1110.design.multithread.pattern.activeobject.juc;

import com.github.liyibo1110.design.multithread.pattern.activeobject.juc.ActiveObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MakerClientThread extends Thread {

    private final ActiveObject activeObject;
    private final char fillChar;

    public MakerClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        this.fillChar = name.charAt(0);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Future<String> future = activeObject.makeString(i, fillChar);
                Thread.sleep(10);
                String value = future.get();
                System.out.println(Thread.currentThread().getName() + ": value = " + value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
