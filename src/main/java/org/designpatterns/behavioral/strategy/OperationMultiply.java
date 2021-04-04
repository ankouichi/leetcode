package org.designpatterns.behavioral.strategy;

public class OperationMultiply implements Strategy{
    @Override
    public float doOperation(float f1, float f2) {
        return f1 * f2;
    }
}
