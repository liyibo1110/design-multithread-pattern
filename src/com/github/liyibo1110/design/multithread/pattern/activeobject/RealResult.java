package com.github.liyibo1110.design.multithread.pattern.activeobject;

class RealResult<T> extends Result<T> {

    private final T resultValue;

    public RealResult(T resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public T getResultValue() {
        return resultValue;
    }
}
