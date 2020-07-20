package harshit.runnables;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingProcessor implements Callable<Boolean> {
    private static Integer counter = 0;

    @Override
    public Boolean call() throws Exception {
        Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO, "Inside Logging Service");
        counter ++;
        if(counter == 1) {
            throw new Exception();
        }
        return true;
    }
}
