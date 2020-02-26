package net.androidbootcamp.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
TextView username_input;
TextView password_input;
Button signin_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//--------------------------------------------------
//Sign in button
//---------------------------------------------------
       signin_button = findViewById(R.id.submit_button);

//----------------------------------------------------
// User Sign In Input
//----------------------------------------------------
username_input = findViewById(R.id.username_input);

password_input = findViewById(R.id.password_input);
    }
}
