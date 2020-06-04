package jm_program.github.io.logic;

import jm_program.github.io.enums.RomanNumeral;
import java.util.List;


/*
source:   https://www.codeflow.site/ru/article/java-convert-roman-arabic
 */
public final class Converter {


    private Converter() {
    }


    public static int romanToArabic(String inputString) throws IllegalArgumentException{
        String romanNumeral = inputString.toUpperCase();
        int result = 0;
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(inputString + " cannot be converted to a Roman Numeral");
        }
        return result;
    }



    public static String arabicToRoman(int inputNumber) throws IllegalArgumentException{
        if ((inputNumber <= 0) || (inputNumber > 4000)) {
            throw new IllegalArgumentException(inputNumber + " is not in range (0,4000]");
        }
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ((inputNumber > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= inputNumber) {
                sb.append(currentSymbol.name());
                inputNumber -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

}
