package com.example.aceri5.letsapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public String phoneNum;
    public int retryCounter = 3;
    public Activity loginactivitypointer = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button verifyBtn = (Button) findViewById(R.id.VerificationBtn);
        TextView sendAgainMsg = (TextView) findViewById(R.id.SendAgainMsg);
        Button sendAgainBtn = (Button) findViewById(R.id.SendAgainBtn);
        sendAgainBtn.setVisibility(View.INVISIBLE);
        sendAgainMsg.setVisibility(View.INVISIBLE);
        Button clk = (Button) findViewById(R.id.clk);

        clk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(loginactivitypointer,ChooseActivity.class);
                startActivity(intent);
            }
        });

        verifyBtn.setOnClickListener(new View.OnClickListener(){
            final String expectedCode = "123456";

            @Override
            public void onClick(View view){
                EditText input = (EditText) findViewById(R.id.PhoneNumandCode);
                TextView sendAgainMsg = (TextView) findViewById(R.id.SendAgainMsg);
                Button verifyBtn = (Button) findViewById(R.id.VerificationBtn);
                Button sendAgainBtn = (Button) findViewById(R.id.SendAgainBtn);
                if(input.getHint().toString().equals("Enter Your Phone Number")) {
                    phoneNum = input.getText().toString();
                    //TODO send verification code to phoneNum + check if NULL
                    //TODO ask server for this number
                    input.setText("");
                    input.setHint("Enter Verification Code");
                    verifyBtn.setText(" Verify ");
                    sendAgainBtn.setVisibility(View.VISIBLE);
                    sendAgainMsg.setVisibility(View.VISIBLE);
                } else {
                    if(input.getText().toString().equals(expectedCode)) {
                        retryCounter = 3;
                        Intent intent = new Intent(loginactivitypointer,ChooseActivity.class);
                        startActivity(intent);
                    } else {
                        if(retryCounter != 0) {
                            retryCounter--;
                            Toast.makeText(LoginActivity.this, " Wrong Code! ", Toast.LENGTH_SHORT).show();
                            input.setText("");
                        } else {
                            retryCounter = 3;
                            input.setHint("Enter Your Phone Number");
                            input.setText(phoneNum);
                            verifyBtn.setText("  Send Verification Code  ");
                            sendAgainBtn.setVisibility(View.INVISIBLE);
                            sendAgainMsg.setVisibility(View.INVISIBLE);
                        }
                    }
                }
            }
        });

        sendAgainBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText input = (EditText) findViewById(R.id.PhoneNumandCode);
                Button verifyBtn = (Button) findViewById(R.id.VerificationBtn);
                Button sendAgainBtn = (Button) findViewById(R.id.SendAgainBtn);
                TextView sendAgainMsg = (TextView) findViewById(R.id.SendAgainMsg);
                retryCounter = 3;
                input.setHint("Enter Your Phone Number");
                input.setText(phoneNum);
                verifyBtn.setText("  Send Verification Code  ");
                sendAgainBtn.setVisibility(View.INVISIBLE);
                sendAgainMsg.setVisibility(View.INVISIBLE);
            }

        });

    }
}
