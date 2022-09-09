package servlets;

import service.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("user");

        if (login != null)
            req.getRequestDispatcher("/page.html").forward(req, resp);
        else {
            req.getRequestDispatcher("/login_page.html").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        SecurityService securityService = new SecurityService();

        if (securityService.checkIfUserLogged(req)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", login);

            req.getRequestDispatcher("/page.html").forward(req, resp);
        } else
            req.getRequestDispatcher("/login_error.html").forward(req, resp);
    }
}
