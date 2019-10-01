package az.java.hospital.loginService;

import az.java.hospital.loginDao.LoginDao;
import az.java.hospital.model.Login;

public class LoginServiceImple implements LoginService {
    private LoginDao loginDao;

    public LoginServiceImple(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public Login login(String username, String password) throws Exception {
        return loginDao.login(username,password);
    }
}
