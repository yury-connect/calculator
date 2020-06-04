package jm_program.github.io.logic;

import jm_program.github.io.beans.Instance;
import jm_program.github.io.enums.Operations;
import jm_program.github.io.enums.NumberSystem;
import jm_program.github.io.exeptions.InputException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static jm_program.github.io.constants.Constants.*;


public final class Сalculator {

    private Сalculator() {
    }

    public static void calculate(Instance instance) {
        String inputExpression = instance.getExpression();

        boolean isArabic = isArabicLanguage(inputExpression);
        boolean isRoman = isRomanLanguage(inputExpression);
        boolean isInvalidCharacter = (inputExpression
                .replaceAll(ARABIC_NUMERAL, EMPTY)
                .replaceAll(ARABIC_NUMERAL_ZERO, EMPTY)
                .replaceAll(ROMAN_NUMERAL, EMPTY)
                .replaceAll(OPERATION, EMPTY)
                .replaceAll(SPACES, EMPTY)
                .replaceAll(ARABIC_NUMERAL_ZERO, EMPTY)
                .length() == 0
        ) ? false : true;

        // validate
        if (isInvalidCharacter) {
            throw new InputException("Invalid characters entered!");
        } else {
            if (!isArabic && !isRoman) {
                throw new InputException("The expression is not fully entered!");
            } else {
                if (isArabic && isRoman) {
                    throw new InputException("The input line contains both Arabic and Roman numerals!");
                }
            }
        }

        instance.setNumberSystem((isArabic) ? NumberSystem.ARABIC : NumberSystem.ROMAN);

        // calculation of results
        String numOneStr;
        String numTwoStr;
        String operationStr;

        String numeral = (isArabic) ? ARABIC_NUMERAL : ROMAN_NUMERAL;
        Pattern numberPattern = Pattern.compile(numeral);
        Matcher numberMatcher = numberPattern.matcher(inputExpression);
        Pattern operationPattern = Pattern.compile(OPERATION);
        Matcher operationMatcher = operationPattern.matcher(inputExpression);
        numberMatcher.find();
        numOneStr = numberMatcher.group();
        numberMatcher.find();
        numTwoStr = numberMatcher.group();
        operationMatcher.find();
        operationStr = operationMatcher.group();

        int numOne;
        int numTwo;
        double result = -0.0;
        if (instance.getNumberSystem() == NumberSystem.ROMAN) {
            numOne = Converter.romanToArabic(numOneStr);
            numTwo = Converter.romanToArabic(numTwoStr);
        } else {
            numOne = Integer.parseInt(numOneStr);
            numTwo = Integer.parseInt(numTwoStr);
        }

        Operations[] operationSet = Operations.values();
        for (Operations operation: operationSet) {
            if (operation.getOperation().equals(operationStr)) {
                result = operation.calculate(numOne, numTwo);
            }
        }
        instance.setResult(result);
    }


    public static boolean isArabicLanguage(String inputExpression) {
        Pattern isArabicPattern = Pattern.compile(BEGIN_EXPRESSION
                + SPACES + ARABIC_NUMERAL + ONE_TIME
                + SPACES + OPERATION + ONE_TIME
                + SPACES + ARABIC_NUMERAL + ONE_TIME
                + SPACES + END_EXPRESSION);
        Matcher isArabicMatcher = isArabicPattern.matcher(inputExpression);
        boolean isArabicResult = (isArabicMatcher.find()) ? true : false;
        return isArabicResult;
    }


    public static boolean isRomanLanguage(String inputExpression) {
        Pattern isRomanPattern = Pattern.compile(BEGIN_EXPRESSION
                + SPACES + ROMAN_NUMERAL + ONE_TIME
                + SPACES + OPERATION + ONE_TIME
                + SPACES + ROMAN_NUMERAL + ONE_TIME
                + SPACES + END_EXPRESSION);
        Matcher isRomanMatcher = isRomanPattern.matcher(inputExpression);
        boolean isRomanResult = (isRomanMatcher.find()) ? true : false;
        return isRomanResult;
    }

}