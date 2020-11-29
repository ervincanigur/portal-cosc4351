package uh.edu.portal.service;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
@Service
public class LoginService {

    private static final Map<String, String> VALID_USERS = new Hashtable<String, String>() {
        {
            put("support", "admin");
            put("finance", "admin");
            put("sales", "admin");
            put("hr", "admin");
            put("technology", "admin");
        }
    };

    public boolean validateLogin(String user, String password) {
        if (user == null || password == null)
            return false;
        if (VALID_USERS.containsKey(user)) {
            return VALID_USERS.get(user).equals(password);
        }
        return false;
    }
}