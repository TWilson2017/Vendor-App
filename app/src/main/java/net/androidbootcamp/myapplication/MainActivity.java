package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button signIn_button;
    Button register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------
        // Sign In
        //------------------
        signIn_button = findViewById(R.id.signin_button2);
        signIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(MainActivity.this, Login.class);
                startActivity(inToMain);
            }
        });

        //-----------------------
        // Register
        //-----------------------
        register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(MainActivity.this, Register_Vendor.class);
                startActivity(inToMain);
            }
        });
    }
}