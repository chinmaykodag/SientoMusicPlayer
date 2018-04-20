package com.Siento.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {



    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Toast toast;
    private int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Name= (EditText)findViewById(R.id.editText);
        Password= (EditText)findViewById(R.id.editText2);
        Info= (TextView) findViewById(R.id.tvinfo);
        Login= (Button) findViewById(R.id.button);



        Info.setText("number of attempts remaining 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    private  void validate(String userName,String userPassword)
    {
        if((userName.equals("chinmay"))&&(userPassword.equals("4019"))){
            Intent intent= new Intent(LoginActivity.this,FolderActivity.class);
            startActivity(intent);
            toast=Toast.makeText(getApplicationContext(),"Welcome Chinmay",Toast.LENGTH_LONG);
            toast.show();
        }
        else if((userName.equals("sarita"))&&(userPassword.equals("4020"))){
            Intent intent= new Intent(LoginActivity.this,FolderActivity.class);
            startActivity(intent);
            toast=Toast.makeText(getApplicationContext(),"Welcome Sarita",Toast.LENGTH_LONG);
            toast.show();
        }
        else if((userName.equals("jayti"))&&(userPassword.equals("4023"))){
            Intent intent= new Intent(LoginActivity.this,FolderActivity.class);
            startActivity(intent);
            toast=Toast.makeText(getApplicationContext(),"Welcome Jayti",Toast.LENGTH_LONG);
            toast.show();
        }
        else if((userName.equals("manan"))&&(userPassword.equals("4030"))){
            Intent intent= new Intent(LoginActivity.this,FolderActivity.class);
            startActivity(intent);
            toast=Toast.makeText(getApplicationContext(),"Welcome Manan",Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            counter--;
            Info.setText("Number of attempts remaining is "+String.valueOf(counter));
            if(counter==0){
                Login.setEnabled(false);
                toast=Toast.makeText(getApplicationContext(),"ERROR: Login Attempt Limit Reached",Toast.LENGTH_LONG);
                toast.show();
            }
            
        }
    }
}
