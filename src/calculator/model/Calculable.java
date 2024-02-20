package calculator.model;

public interface Calculable {
    Calculable sum(double arg);
    Calculable multi(double arg);
    Calculable div(double arg);
    double getResult();
}
