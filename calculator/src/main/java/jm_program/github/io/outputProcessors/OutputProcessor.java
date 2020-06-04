package jm_program.github.io.outputProcessors;

import jm_program.github.io.beans.Instance;


public interface OutputProcessor {

    public void outputInstance(Instance instance);

    public void outputMessage(String message);

    public void closeResources();

}
