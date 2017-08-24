package com.example.hp.testing;

/**
 * Created by Hp on 22-08-2017.
 */

interface LoginView { // Creating interface
    String getUsername();

    void showUsernameError(int resId);

    String getPassword();

    void showPasswordError(int resId);

    void startMainActivity();

    void showLoginError(int resId);
}
