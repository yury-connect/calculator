package jm_program.github.io.outputProcessors;

import jm_program.github.io.beans.Instance;
import jm_program.github.io.enums.NumberSystem;
import jm_program.github.io.logic.Converter;


public abstract class AbstractProcessorOut {

    protected String prepareResult(Instance instance) {
        String result = (instance.getNumberSystem() == NumberSystem.ARABIC)
                ? String.valueOf(instance.getResult())
                : Converter.arabicToRoman((int) instance.getResult());
        return result;
    }

}
