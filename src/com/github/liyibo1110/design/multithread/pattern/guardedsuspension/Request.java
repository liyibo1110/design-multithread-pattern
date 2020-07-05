package com.github.liyibo1110.design.multithread.pattern.guardedsuspension;

public class Request {

    private final String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[ Request " + name + " ]";
    }
}
