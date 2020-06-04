package jm_program.github.io.constants;



public final class Constants {

    private Constants() {
    }


    /*
    for class   Сalculator
     */
    public final static String ARABIC_NUMERAL = "((10)|[1-9])";
    public final static String ARABIC_NUMERAL_ZERO = "0";
    public final static String ROMAN_NUMERAL = "((III)|(II)|(IV)|(VIII)|(VII)|(VI)|(IX)|(I)|(V)|(X))";
    public final static String OPERATION = "(\\+|\\-|\\*|\\/)";
    public final static String SPACES = "\\s*";
    public final static String ONE_TIME = "{1}";
    public final static String BEGIN_EXPRESSION = "^";
    public final static String END_EXPRESSION = "$";
    public final static String EMPTY = "";

    /*
    for class   Instance
     */
    public final static String OUT_DELIMITER = ";";

    /*
    for class   Runner
     */
    public final static String ABORT_PROGRAM = "stop";
    public final static String FINISH_PROGRAM_MSG = "The program is complete.";

    /*
    for class   ConsoleProcessorIn
     */
    public final static String EXAMPLE_MSG = "\n\tExample: \n\t 1 + 2 \n\t VI / III \n Enter an expression: ";


}
