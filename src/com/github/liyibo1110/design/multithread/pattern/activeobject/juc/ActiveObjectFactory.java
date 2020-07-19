package com.github.liyibo1110.design.multithread.pattern.activeobject.juc;

public class ActiveObjectFactory {

    public static ActiveObject createActiveObject() {
        return new ActiveObjectImpl();
    }
}
