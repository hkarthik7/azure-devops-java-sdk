package org.azd.maven.types;

public enum BatchOperation {
    PROMOTE(0), DELETE(1), PERMANENT_DELETE(2), RESTORE_TO_FEED(3);
    
    private final int value;
    private BatchOperation(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}