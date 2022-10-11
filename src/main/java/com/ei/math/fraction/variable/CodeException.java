package com.ei.math.fraction.variable;

public enum CodeException {
    UnsupportedOperationException(-100);
    
    private final int value;

    private CodeException(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    
}
