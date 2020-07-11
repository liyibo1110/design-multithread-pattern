package com.github.liyibo1110.design.multithread.pattern.future;

public class Host {

    public Data request(final int count, final char c) {
        System.out.println("request (" + count + ", " + c + ") BEGIN");
        // 先创建FutureData实例
        FutureData future = new FutureData();
        // 再启动新线程，创建RealData实例
        new Thread(() -> {
            RealData realData = new RealData(count, c);
            future.setRealData(realData);
        }).start();
        System.out.println("request (" + count + ", " + c + ") END");
        // 返回FutureData实例
        return future;
    }
}
