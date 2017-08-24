package com.example.hp.testing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/*
   MockitoJUnitRunner gives you automatic validation of framework usage, as well as an automatic
    initMocks().
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock  // Mocking objects
    private LoginView view;
    @Mock
    private LoginService service;

    private LoginPresenter presenter;

    // @Before test class invokes this code block before each test.
    @Before
    public void setUp() throws Exception{
        presenter=new LoginPresenter(view,service);
    }

    // @Test is used to mark test method
    @Test // //Test method 1 to check whether username is empty or not .
    public void usernameEmpty() throws Exception {
        // Creating when method to check username is empty
        when(view.getUsername()).thenReturn("");
        presenter.onLoginClicked();
        // Verifying the method on a mock
        verify(view).showUsernameError(R.string.username_error);
    }

    @Test //Test method 2 to check whether password is empty or not .
    public void passwordEmpty() throws Exception {
        // Creating when method to check password is empty
        when(view.getUsername()).thenReturn("Nitish");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked(); // Calling method
        // Verifying the method on a mock
        verify(view).showPasswordError(R.string.password_error);

    }

    @Test //Test method 3 to check whether username & password is valid or invalid
    public void startMainActivity() throws Exception {
        // Creating when method to check username and password is valid
        when(view.getUsername()).thenReturn("Nitish");
        when(view.getPassword()).thenReturn("undertaker");
        when(service.login("Nitish","undertaker")).thenReturn(true);
        presenter.onLoginClicked(); // Calling method
        // Verifying the method on a mock
        verify(view).startMainActivity();
    }

    @Test //Test method 4 to check when LogIn failed  .
    public void logInError() throws Exception {
        when(view.getPassword()).thenReturn("undertaker");
        when(service.login("Nitish","undertaker")).thenReturn(false);
        presenter.onLoginClicked();
        verify(view).showLoginError(R.string.logIn_error);

    }
}