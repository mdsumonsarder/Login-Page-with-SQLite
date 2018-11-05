package com.shoedazzle.m.loginpagedemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyDatabaseHelper myDatabaseHelper;

    EditText name,password;
    Button signin,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Database Return;
        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase =  myDatabaseHelper.getWritableDatabase();

        //Find Id;
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);

        signin.setOnClickListener(this);
        signup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String UserName = name.getText().toString();
        String Password = password.getText().toString();

        if (v.getId()==R.id.signin){

            //Toast.makeText(getApplicationContext(),"SignIn",Toast.LENGTH_LONG).show();

            Boolean result = myDatabaseHelper.findPassword(UserName,Password);

            if (result == true){
                Intent intent = new Intent(MainActivity.this,Success.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(),"User Name and Password Don't match!",Toast.LENGTH_LONG).show();
            }

        }
        if (v.getId()==R.id.signup){

            Toast.makeText(getApplicationContext(),"SignUp",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivity.this,SignUp.class);
            startActivity(intent);
        }


    }
}
