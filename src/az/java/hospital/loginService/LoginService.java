package az.java.hospital.loginService;

import az.java.hospital.model.Login;

public interface LoginService {

    Login login(String username,String password) throws Exception;
}
