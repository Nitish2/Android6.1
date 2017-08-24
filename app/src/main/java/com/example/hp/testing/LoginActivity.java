package com.example.hp.testing;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText usernameView;
    private EditText passwordView;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Creating and initializing objects by ID.
        usernameView = (EditText) findViewById(R.id.username);
        passwordView = (EditText) findViewById(R.id.password);
        // Creating constructor object and calling it .
        presenter = new LoginPresenter(this, new LoginService());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void onLoginClicked(View view) {
        presenter.onLoginClicked(); // Calling onClick method
    }


    @Override
    public String getUsername() {
        return usernameView.getText().toString();
    }

    @Override
    public void showUsernameError(int resId) { // Calling method
        usernameView.setError(getString(resId));

    }

    @Override
    public String getPassword() {
        return passwordView.getText().toString();
    }

    @Override
    public void showPasswordError(int resId) { // Calling Method
        passwordView.setError(getString(resId));

    }

    @Override
    public void startMainActivity() {
        new ActivityUtil(this).startMainActivity();
    }

    @Override
    public void showLoginError(int resId) {
        Toast.makeText(getApplicationContext(),getString(resId),Toast.LENGTH_LONG).show();
    }
}
