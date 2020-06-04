package jm_program.github.io.exeptions;


public class InputException extends ArithmeticException  {

    public InputException(String message) {
        super("\n\n " + message + " \n");
    }

}
