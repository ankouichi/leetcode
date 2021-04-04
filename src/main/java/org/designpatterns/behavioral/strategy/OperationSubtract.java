package org.designpatterns.behavioral.strategy;

public class OperationSubtract implements Strategy {
    @Override
    public float doOperation(float f1, float f2) {
        return f1 - f2;
    }
}
