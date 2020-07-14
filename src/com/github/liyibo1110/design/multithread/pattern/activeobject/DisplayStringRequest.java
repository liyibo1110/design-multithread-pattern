package com.github.liyibo1110.design.multithread.pattern.activeobject;

class DisplayStringRequest extends MethodRequest<String> {

    private final String str;

    public DisplayStringRequest(Servant servant, String str) {
        super(servant, null);
        this.str = str;
    }

    @Override
    public void execute() {
        servant.displayString(str);
    }
}
