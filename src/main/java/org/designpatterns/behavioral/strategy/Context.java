package org.designpatterns.behavioral.strategy;

public class Context {
    private Strategy strategy;
    public Context(Strategy s) {
        this.strategy = s;
    }

    public float executeStrategy(float num1, float num2) {
        return strategy.doOperation(num1, num2);
    }
}
