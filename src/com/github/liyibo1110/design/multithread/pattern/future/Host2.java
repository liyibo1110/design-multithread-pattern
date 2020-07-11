package com.github.liyibo1110.design.multithread.pattern.future;

public class Host2 {

    public Data request(final int count, final char c) {
        System.out.println("request (" + count + ", " + c + ") BEGIN");
        // 先创建FutureData2实例
        FutureData2 future = new FutureData2(() -> new RealData(count, c));
        // 再启动新线程，创建RealData实例
        new Thread(future).start();
        System.out.println("request (" + count + ", " + c + ") END");
        // 返回FutureData实例
        return future;
    }
}
