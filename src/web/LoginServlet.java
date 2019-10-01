package web;

import az.java.hospital.loginDao.LoginDao;
import az.java.hospital.loginDao.LoginDaoImple;
import az.java.hospital.loginService.LoginService;
import az.java.hospital.loginService.LoginServiceImple;
import az.java.hospital.model.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/ls")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address="";
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        LoginDao loginDao = new LoginDaoImple();
        LoginService loginService = new LoginServiceImple(loginDao);

        try {
            if(username!=null && !username.isEmpty() && password!=null && !password.isEmpty()){
               Login login = loginService.login(username,password);
               if(login!=null){
                   HttpSession session=request.getSession(true);
                   session.setAttribute("login",login);
                   address="index.jsp";
               }else {
                   request.setAttribute("invalid!","Username or Password invalid");
                address="login.jsp";
               }
            } else {
                request.setAttribute("invalid!","Username or Password is empty");
                address="login.jsp";
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(address);
        requestDispatcher.forward(request,response);
    }


}
