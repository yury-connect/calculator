package jm_program.github.io.logic;

import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class RomanArabicConverterTest {



    @Test
    public void given2018Roman__WhenConvertingToArabic__ThenReturn2018() {
        String roman2018 = "MMXVIII";
        int result = Converter.romanToArabic(roman2018);
        assertEquals(result,2018);
    }

    @Test
    public void given1999Arabic__WhenConvertingToRoman__ThenReturnMCMXCIX() {
        int arabic1999 = 1999;
        String result = Converter.arabicToRoman(arabic1999);
        assertEquals(result,"MCMXCIX");
    }

}
