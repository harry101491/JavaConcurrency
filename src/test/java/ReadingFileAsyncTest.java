import harshit.runnables.ReadingFileAsync;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ReadingFileAsyncTest {
    public static void main(String args[]) {
//        ReadingFileAsync thread1 = new ReadingFileAsync();
//        ReadingFileAsync thread2 = new ReadingFileAsync();
//        ReadingFileAsync thread3 = new ReadingFileAsync();
//
//        thread1.start();
//        thread2.start();
//        thread3.start();

        Runnable runnable = () -> {
            try {
                File harryPotterFile = new File("/Users/harshitpareek/Downloads/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter2/02_03/begin/sample.txt");
                FileReader fileReader = new FileReader(harryPotterFile);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                while(Objects.nonNull(line = reader.readLine())) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " reads text: "+ line);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        };

        // Using the thread method to invoke runnable instance
//        Thread thread = new Thread(runnable);
//        thread.start();

        // Using the executor method
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);

    }
}
