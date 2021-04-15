package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Final extends AppCompatActivity {
    Button btn;
    EditText Name, Pass, ConfPass, Email;
    boolean isNameValid,isEmailValid,isPasswordValid,isCPasswordValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        //initialization of all editText
        Name=(EditText)findViewById(R.id.Name);
        Pass=(EditText)findViewById(R.id.Password);
        ConfPass=(EditText)findViewById(R.id.ConfirmPassword);
        Email=(EditText)findViewById(R.id.Email);

        //Initialization of Register Button
        btn=(Button)findViewById(R.id.register);

        //Registration button functionality
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Name.getText().toString().length()==0){
                   Name.setError("UserName not entered");
                    Name.requestFocus();
                    isNameValid=false;
                }
                else{
                    isNameValid=true;
                }
                if (Email.getText().toString().isEmpty()) {
                    Email.setError("Email not entered");
                    Email.requestFocus();
                    isEmailValid=false;
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString()).matches()) {
                    Email.setError("Email not Valid");
                    Email.requestFocus();
                    isEmailValid=false;
                }
                else{
                    isEmailValid=true;
                }
                if(Pass.getText().toString().length()==0){
                    Pass.setError("Password not entered");
                    Pass.requestFocus();
                    isPasswordValid=false;
                }
                else if(Pass.getText().toString().length()<8) {
                    Pass.setError("Password should be atleast of 8 charactors");
                    Pass.requestFocus();
                    isPasswordValid=false;
                }
                else{
                    isPasswordValid=true;
                }
                if(ConfPass.getText().toString().length()==0){
                   ConfPass.setError("Please confirm password");
                   ConfPass.requestFocus();
                    isCPasswordValid=false;
                }
                else if(!Pass.getText().toString().equals(ConfPass.getText().toString())){
                    ConfPass.setError("Password Not matched");
                    ConfPass.requestFocus();
                    isCPasswordValid=false;
                }
                else{
                    isCPasswordValid=true;
                }


                if(isNameValid && isEmailValid && isPasswordValid && isCPasswordValid) {
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}