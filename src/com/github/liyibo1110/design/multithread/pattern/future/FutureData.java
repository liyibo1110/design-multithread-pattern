package com.github.liyibo1110.design.multithread.pattern.future;

public class FutureData implements Data {

    private RealData realData = null;
    private boolean ready = false;

    public void setRealData(RealData realData) {
        // 保护丢弃模式
        if(ready) return;
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        // 保护暂挂模式
        while(!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getContent();
    }
}
