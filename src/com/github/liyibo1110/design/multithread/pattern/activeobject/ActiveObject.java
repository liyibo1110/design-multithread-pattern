package com.github.liyibo1110.design.multithread.pattern.activeobject;

public interface ActiveObject {

    public Result<String> makeString(int count, char fillChar);

    public void displayString(String str);
}
