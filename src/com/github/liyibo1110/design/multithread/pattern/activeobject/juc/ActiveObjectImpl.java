package com.github.liyibo1110.design.multithread.pattern.activeobject.juc;

import com.github.liyibo1110.design.multithread.pattern.activeobject.MakerClientThread;

import java.util.concurrent.*;

public class ActiveObjectImpl implements ActiveObject {

    private final ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    public void shutdown() {
        service.shutdown();
    }

    @Override
    public Future<String> makeString(final int count, final char fillChar) {
        class MakeStringRequest implements Callable<String> {
            @Override
            public String call() {
                char[] buffer = new char[count];
                for (int i = 0; i < count; i++) {
                    buffer[i] = fillChar;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return new String(buffer);
            }
        }
        return service.submit(new MakeStringRequest());
    }

    @Override
    public void displayString(final String str) {
        class DisplayStringRequest implements Runnable {
            @Override
            public void run() {
                try {
                    System.out.println("displayString: " + str);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        service.execute(new DisplayStringRequest());
    }
}
