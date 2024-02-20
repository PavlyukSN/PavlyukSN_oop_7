package calculator;

import calculator.controller.CalculableFactory;
import calculator.model.ICalculableFactory;
import calculator.view.ViewCalculator;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        ICalculableFactory calculableFactory = new CalculableFactory();
        ViewCalculator view = new ViewCalculator(calculableFactory);
        view.run();
    }
}
