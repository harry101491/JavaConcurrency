import harshit.dao.UserDao;
import harshit.runnables.UserProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExecutors {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<String> userList = getUserRecords("/Users/harshitpareek/Downloads/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter3/03_04/begin/new_users.txt");
        UserDao dao = new UserDao();
        // for every user record we are submitting a callable object
        for(String user: userList) {
            executorService.submit(new UserProcessor (dao, user));
        }
        // easily shutdown by service
        executorService.shutdown();
        System.out.println("Main method Over!");
    }

    private static List<String> getUserRecords(String fileName) {
        List<String> userList = new ArrayList<>();
        try {
            File userFileName = new File(fileName);
            FileReader fileReader = new FileReader(userFileName);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while(Objects.nonNull(line = reader.readLine())) {
                userList.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return userList;
    }
}
