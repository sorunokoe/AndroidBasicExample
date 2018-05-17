package com.kitestart.androidbasiclesson;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends Activity {


    EditText loginField, passwordField;
    Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);

        setViews();


        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(validateLogin(loginField.getText().toString())){
                    if(validatePassword(passwordField.getText().toString())) {

                        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                        intent.putExtra("login", loginField.getText().toString());
                        startActivity(intent);


                    }else{
                        Toast.makeText(SignInActivity.this, "Not valid password field", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignInActivity.this, "Not valid login field", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    boolean validateLogin(String login){
        if(login != null && login.length()>3 && !login.contains("%")){
            return true;
        }
        return false;
    }
    boolean validatePassword(String password){
        if(password != null && password.length()>3 && !password.contains("%")){
            return true;
        }
        return false;
    }


    void setViews(){
        loginField = findViewById(R.id.loginField);
        passwordField = findViewById(R.id.passwordField);
        signInBtn = findViewById(R.id.signInBtn);
    }
}
