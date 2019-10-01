package az.java.hospital.loginDao;

import az.java.hospital.model.Login;

public interface LoginDao {

    Login login(String username, String password) throws Exception;
}
