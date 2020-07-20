package harshit.runnables;

import harshit.beans.User;
import harshit.dao.UserDao;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

public class UserProcessor implements Callable<Integer> {

    private UserDao userDao;
    // every thread will process the one userRecord
    private String userString;

    public UserProcessor(UserDao userDao, String userString) {
        this.userString = userString;
        this.userDao = userDao;
    }

    @Override
    public Integer call() throws Exception {
        int rows = -1;
        System.out.println("Thread " + Thread.currentThread().getName() + " processing "+ userString);
        StringTokenizer tokenizer = new StringTokenizer(userString, ",");
        User user = null;
        while (tokenizer.hasMoreTokens()) {
            user = new User();
            user.setEmail(tokenizer.nextToken());
            user.setName(tokenizer.nextToken());
            user.setId(Integer.valueOf(tokenizer.nextToken()));
            rows = userDao.saveUser(user);
        }

        return rows;
    }
}
