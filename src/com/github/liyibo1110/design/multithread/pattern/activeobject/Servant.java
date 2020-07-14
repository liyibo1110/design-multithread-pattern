package com.github.liyibo1110.design.multithread.pattern.activeobject;

class Servant implements ActiveObject {

    @Override
    public Result<String> makeString(int count, char fillChar) {
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = fillChar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new RealResult<>(new String(buffer));
    }

    @Override
    public void displayString(String str) {
        try {
            System.out.println("displayString: " + str);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
