package calculator.controller;

import calculator.model.Calculable;

public final class Calculator implements Calculable {

    private double primaryArg;

    public Calculator(double primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public Calculable sum(double arg) {
        primaryArg += arg;
        return this;
    }

    @Override
    public Calculable multi(double arg) {
        primaryArg *= arg;
        return this;
    }

    @Override
    public Calculable div(double arg) {
        primaryArg /= arg;
        return this;
    }

    @Override
    public double getResult() {
        return primaryArg;
    }
}
