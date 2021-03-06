import jm_program.github.io.beans.Instance;
import jm_program.github.io.constants.Constants;
import jm_program.github.io.exeptions.InputException;
import jm_program.github.io.inputProcessors.*;
import jm_program.github.io.logic.Сalculator;
import jm_program.github.io.outputProcessors.*;


/**
 * @author Yury Lapitskiy
 * Test "Calculator"
 * 2020-06-04
 */
public class Runner {

    public static void main(String[] args) {

        InProcessor input = new InConsoleProcessor();
        OutProcessor output = new OutConsoleProcessor();

        boolean executeProgram = true;
        try {
            while (executeProgram) {
                String expression = input.getData();
                if (expression.equals(Constants.ABORT_PROGRAM)) {
                    executeProgram = false;
                } else {
                    Instance instance = new Instance(expression);
                    Сalculator.calculate(instance);
                    output.outputInstance(instance);
                }
            }
        } catch (InputException inputException) {
            output.outputMessage(inputException.getMessage());   // Output a message to the output device
            inputException.printStackTrace();   // Logging to the console
        } finally {
            output.outputMessage(Constants.FINISH_PROGRAM_MSG);
        }
    }
}
