import harshit.runnables.LoggingProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class LoggingProcessorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Boolean>> callableList = new ArrayList<>();

        for(int i = 0; i<5; i++) {
            callableList.add(new LoggingProcessor());
        }

//        try {
//            // In the invokeAll it will call all the callable in the list and return all futures
//            // in futures list
//            List<Future<Boolean>> futureList = executorService.invokeAll(callableList);
//            for(Future<Boolean> future: futureList) {
//                System.out.println("Value of the Future is: " + future.get());
//            }
//        } catch (InterruptedException inEx) {
//            inEx.printStackTrace();
//        } catch (ExecutionException exeEx) {
//            exeEx.printStackTrace();
//        }

        try {
            System.out.println("InvokeAny: " + executorService.invokeAny(callableList));
        } catch (InterruptedException inEx) {
            inEx.printStackTrace();
        } catch (ExecutionException exeEx) {
            exeEx.printStackTrace();
        }

    }
}
