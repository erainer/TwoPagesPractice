package com.example.quyo.twopagespractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        final EditText id = (EditText) findViewById(R.id.loginBox);
        final EditText password = (EditText) findViewById(R.id.passwordBox);
        final TextView incorrect = (TextView) findViewById(R.id.incorrectTxt);
        final Button loginButton = (Button) findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString().matches("Emily") && password.getText().toString().matches("Password")) {
                    setContentView(R.layout.activity_second_page);
                }else {
                    incorrect.setText("Incorrect user name or password!");
                }
            }
        });
    }
}
