package com.github.liyibo1110.design.multithread.pattern.guardedsuspension;

public class Main {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice", 1234L).start();
        new ServerThread(requestQueue, "Bobby", 5678L).start();
    }
}
