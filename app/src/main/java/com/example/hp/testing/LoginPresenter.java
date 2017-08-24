package com.example.hp.testing;

/**
 * Created by Hp on 22-08-2017.
 */

class LoginPresenter {
    // Creating objects
    private LoginView view;
    private LoginService service;

    public LoginPresenter(LoginView view, LoginService service) { //Creates constructor
        this.view = view;
        this.service = service;
    }

    public void onLoginClicked() { //Creates onClick Method
        String username = view.getUsername();
        if (username.isEmpty()) { // If username is empty
            view.showUsernameError(R.string.username_error); // Show error message
            return;
        }
        String password = view.getPassword();
        if (password.isEmpty()) { // If password is empty
            view.showPasswordError(R.string.password_error); // Show error message
            return;
        }
        boolean loginSucceeded = service.login(username, password);
        if (loginSucceeded) { // If LogIn is successful
            view.startMainActivity(); // View Main activity
            return;
        }
        view.showLoginError(R.string.logIn_error); //  Show LogIn error message
    }
    }
