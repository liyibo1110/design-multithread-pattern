package com.github.liyibo1110.design.multithread.pattern.future;

public class RealData implements Data {

    private final String content;

    public RealData(int count, char c) {
        System.out.println("making ReadData(" + count + ", " + c + ") BEGIN");
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("making ReadData(" + count + ", " + c + ") END");
        content = new String(buffer);
    }

    @Override
    public String getContent() {
        return content;
    }
}
