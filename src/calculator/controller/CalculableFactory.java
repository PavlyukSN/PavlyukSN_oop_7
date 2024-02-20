package calculator.controller;

import calculator.model.Calculable;
import calculator.model.ICalculableFactory;

public class CalculableFactory implements ICalculableFactory {
    public Calculable create(double primaryArg) {
        return new Calculator(primaryArg);
    }
}
