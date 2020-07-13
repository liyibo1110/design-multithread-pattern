package com.github.liyibo1110.design.multithread.pattern.threadspecificstorage;

public class Log {

    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    public static void println(String str) {
        getTSLog().println(str);
    }

    public static void close() {
        getTSLog().close();
    }

    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();
        if(tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }
}
