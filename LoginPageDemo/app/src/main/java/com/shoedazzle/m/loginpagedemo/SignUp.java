package com.shoedazzle.m.loginpagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    //Variable;
    EditText name,email,username,password;
    Button signup;

    //UserDetails class Object;
    UserDetails userDetails;
    //MyDatabaseHelper class Object;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //UserDetails Class Object;
        userDetails = new UserDetails();
        //MyDatabaseHelper class Object;
        myDatabaseHelper = new MyDatabaseHelper(this);

        //Find Data;
        name = findViewById(R.id.nameid);
        email = findViewById(R.id.emailid);
        username = findViewById(R.id.usernameid);
        password = findViewById(R.id.passwordid);
        signup = findViewById(R.id.signupid);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String UserName = username.getText().toString();
        String Password = password.getText().toString();

        userDetails.setName(Name);
        userDetails.setEmail(Email);
        userDetails.setUsername(UserName);
        userDetails.setPassword(Password);

       long rawID = myDatabaseHelper.insertData(userDetails);

        if (rawID ==-1){
            Toast.makeText(getApplicationContext(),"Not Successfull Insert",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Successfull Insert",Toast.LENGTH_LONG).show();
        }


    }
}
