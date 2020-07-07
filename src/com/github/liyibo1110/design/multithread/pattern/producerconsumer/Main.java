package com.github.liyibo1110.design.multithread.pattern.producerconsumer;

public class Main {

    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("MakerThread-1", table, 1111).start();
        new MakerThread("MakerThread-2", table, 2222).start();
        new MakerThread("MakerThread-3", table, 3333).start();
        new EaterThread("EaterThread-1", table, 4444).start();
        new EaterThread("EaterThread-2", table, 5555).start();
        new EaterThread("EaterThread-3", table, 6666).start();
    }
}
