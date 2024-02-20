package calculator.view;

import calculator.model.Calculable;
import calculator.model.ICalculableFactory;

import java.io.*;
import java.util.Scanner;

public class ViewCalculator {

    File myFile = new File("LogCalk.txt");
    FileOutputStream outputStream = new FileOutputStream(myFile);
    private ICalculableFactory calculableFactory;

    public ViewCalculator(ICalculableFactory calculableFactory) throws FileNotFoundException {
        this.calculableFactory = calculableFactory;
    }

    public void run() throws IOException {
        while (true) {
            double primaryArg = promptInt("Введите первый аргумент: ");
            Calculable calculator = calculableFactory.create(primaryArg);
            outputStream.write((" Первый аргумент " + primaryArg).getBytes());
            while (true) {
                String cmd = prompt("Введите команду (*, +, /, =) : ");
                outputStream.write((" Операция " + cmd).getBytes());
                if (cmd.equals("*")) {
                    double arg = promptInt("Введите второй аргумент: ");
                    outputStream.write((" Второй аргумент " + arg).getBytes());
                    calculator.multi(arg);
                    continue;
                }
                if (cmd.equals("+")) {
                    double arg = promptInt("Введите второй аргумент: ");
                    outputStream.write((" Второй аргумент " + arg).getBytes());
                    calculator.sum(arg);
                    continue;
                }
                outputStream.write((" Операция "+ cmd).getBytes());
                if (cmd.equals("/")) {
                    double arg = promptInt("Введите второй аргумент: ");
                    outputStream.write((" Второй аргумент " + arg).getBytes());
                    calculator.div(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    double result = calculator.getResult();
                    outputStream.write((" Результат " + result).getBytes());
                    System.out.println("Результат "+ result);
                    break;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y") || cmd.equals("y")) {
                continue;
            }
            break;
        }
        outputStream.close();
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private double promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}
