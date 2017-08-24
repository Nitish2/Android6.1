package com.example.hp.testing;

/**
 * Created by Hp on 22-08-2017.
 */

class LoginService {
    public boolean login(String username, String password) {
        // Returns the actual username and password
        return "Nitish".equals(username) && "undertaker".equals(password);
    }
}
