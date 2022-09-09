package service;

import model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SecurityService {
    List<User> userList = new ArrayList<>();

    User user1 = new User("Bob", "12");
    User user2 = new User("Dima", "123");
    User user3 = new User("Mike", "1234");

    public boolean checkIfUserLogged(HttpServletRequest request) {

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

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
