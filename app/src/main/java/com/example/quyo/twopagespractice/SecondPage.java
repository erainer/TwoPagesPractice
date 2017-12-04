package com.example.quyo.twopagespractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        final EditText firstName = (EditText) findViewById(R.id.firstNameBox);
        final EditText lastName = (EditText) findViewById(R.id.lastNameBox);
        final EditText phone = (EditText) findViewById(R.id.phoneBox);
        final EditText day = (EditText) findViewById(R.id.dayBox);
        final EditText year = (EditText) findViewById(R.id.yearBox);
        Button next = (Button) findViewById(R.id.nextBtn);


        final Spinner monthSP = (Spinner) findViewById(R.id.monthSP);
        final TextView certSPLB = (TextView) findViewById(R.id.certSPLabel);
        final TextView degreeSPLB = (TextView) findViewById(R.id.degreeSPLabel);
        final Spinner certSP = (Spinner) findViewById(R.id.certSP);
        final Spinner degreeSP = (Spinner) findViewById(R.id.degreeSP);

        Switch certDegSW = (Switch) findViewById(R.id.certDegSW);

        certDegSW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    degreeSP.setVisibility(View.VISIBLE);
                    degreeSPLB.setVisibility(View.VISIBLE);
                    certSPLB.setVisibility(View.GONE);
                    certSP.setVisibility(View.GONE);
                }else{
                    degreeSP.setVisibility(View.GONE);
                    degreeSPLB.setVisibility(View.GONE);
                    certSPLB.setVisibility(View.VISIBLE);
                    certSP.setVisibility(View.VISIBLE);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (checkData()) {
                    Intent nextScreen = new Intent(SecondPage.this, ThirdPage.class);
                    String birthday = "";
                    birthday = monthSP.getSelectedItem().toString() + "/" + day.getText().toString() + "/" + year.getText().toString();
                    nextScreen.putExtra("FirstName", firstName.getText().toString());
                    nextScreen.putExtra("LastName", lastName.getText().toString());
                    nextScreen.putExtra("Phone", phone.getText().toString());
                    nextScreen.putExtra("Birthday", birthday);

                    //Start Activity
                    startActivity(nextScreen);
                    setContentView(R.layout.activity_third_page);
                }
            }
        });
    }


    private boolean checkData() {
        final EditText firstName = (EditText) findViewById(R.id.firstNameBox);
        final EditText lastName = (EditText) findViewById(R.id.lastNameBox);
        final EditText phone = (EditText) findViewById(R.id.phoneBox);
        final EditText day = (EditText) findViewById(R.id.dayBox);
        final EditText year = (EditText) findViewById(R.id.yearBox);


        if (firstName.getText().toString().isEmpty()) {
            firstName.setError("Invalid First Name");
            firstName.requestFocus();
            return false;
        }

        if (lastName.getText().toString().isEmpty()) {
            lastName.setError("Invalid Last Name");
            lastName.requestFocus();
            return false;
        }

        if (phone.getText().toString().isEmpty()) {
            phone.setError("Invalid Phone");
            phone.requestFocus();
            return false;
        }

        if (day.getText().toString().isEmpty()) {
            day.setError("Invalid Day");
            day.requestFocus();
            return false;
        }

        if (year.getText().toString().isEmpty()) {
            year.setError("Invalid Year");
            year.requestFocus();
            return false;
        }

        return true;
    }
}



