package com.github.liyibo1110.design.multithread.pattern.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureData2 extends FutureTask<RealData> implements Data {

    public FutureData2(Callable<RealData> callable) {
        super(callable);
    }

    @Override
    public String getContent() {
        String str = null;
        try {
            str = get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return str;
    }
}
