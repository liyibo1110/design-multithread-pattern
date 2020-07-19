package com.github.liyibo1110.design.multithread.pattern.activeobject.juc;

import com.github.liyibo1110.design.multithread.pattern.activeobject.juc.ActiveObject;
import com.github.liyibo1110.design.multithread.pattern.activeobject.juc.ActiveObjectFactory;
import com.github.liyibo1110.design.multithread.pattern.activeobject.juc.DisplayClientThread;
import com.github.liyibo1110.design.multithread.pattern.activeobject.juc.MakerClientThread;

public class Main {

    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        try {
            new MakerClientThread("Alice", activeObject).start();
            new MakerClientThread("Bobby", activeObject).start();
            new DisplayClientThread("Chris", activeObject).start();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("**** shutdown ****");
            activeObject.shutdown();
        }
    }
}
