package service;

import model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class SecurityService {

    User user1 = new User("Bob", "12");
    User user2 = new User("Dima", "123");
    User user3 = new User("Mike", "1234");

    List<User> userList = Arrays.asList(user1, user2, user3);

    public boolean checkIfUserLogged(HttpServletRequest request) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        for (User user : userList) {

            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
