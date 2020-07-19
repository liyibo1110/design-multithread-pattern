package com.github.liyibo1110.design.multithread.pattern.activeobject.juc;

import java.util.concurrent.Future;

public interface ActiveObject {

    public Future<String> makeString(int count, char fillChar);

    public void displayString(String str);

    public void shutdown();
}
