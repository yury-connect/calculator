package jm_program.github.io.outputProcessors;

import jm_program.github.io.beans.Instance;


public final class ConsoleProcessorOut extends AbstractProcessorOut implements OutputProcessor{

    @Override
    public void outputInstance(Instance instance) {
        System.out.println("The expression you entered: " + instance.getExpression());
        System.out.println("Result of calculation: " + prepareResult(instance));
        System.out.println("Number system: " + instance.getNumberSystem());
    }

    @Override
    public void outputMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void closeResources() {
        // NOP
    }

}
