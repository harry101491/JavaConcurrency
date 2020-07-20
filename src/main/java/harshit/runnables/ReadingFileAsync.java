package harshit.runnables;

import java.io.*;
import java.util.Objects;

public class ReadingFileAsync extends Thread {

    @Override
    public void run() {
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
    }
}
