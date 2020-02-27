package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    TextView username_input;
    TextView password_input;
    Button signIn_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_register);

//--------------------------------------------------
// Sign in button
//---------------------------------------------------
        signIn_button = findViewById(R.id.signin_button3);
        signIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(Login.this, Vendor_Items.class);
                startActivity(inToMain);
            }
        });
//----------------------------------------------------
// User Sign in Input
//----------------------------------------------------
        username_input = findViewById(R.id.username_input);
        password_input = findViewById(R.id.password_input);
    }
}
