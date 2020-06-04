package jm_program.github.io.inputProcessors;

import jm_program.github.io.constants.Constants;

import java.util.Scanner;



public final class InConsoleProcessor implements InProcessor {

    Scanner scanner;

    public String getData() {
        scanner = new Scanner(System.in);
        System.out.println(Constants.EXAMPLE_MSG);
        String expression = scanner.nextLine().trim().toUpperCase();
        return expression;
    }

    public void closeResources() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
