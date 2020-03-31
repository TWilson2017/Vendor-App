package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainLoginRegister extends AppCompatActivity {
    Button signIn_button;
    Button register_button;
    Button storeManLogin;
    Button storeManRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------
        // Vendor Sign In
        //------------------
        signIn_button = findViewById(R.id.signin_button2);
        signIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(MainLoginRegister.this, Manager_Vendor_Login.class);
                startActivity(inToMain);
            }
        });

        //------------------
        // Manager Sign In
        //------------------
        storeManLogin = findViewById(R.id.storeManLogin);
        storeManLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(MainLoginRegister.this, Manager_Vendor_Login.class);
                startActivity(inToMain);
            }
        });

        //-----------------------
        // Register Vendor
        //-----------------------
        register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(MainLoginRegister.this, Register_Vendor.class);
                startActivity(inToMain);
            }
        });

        //-----------------------
        // Register manager
        //-----------------------
        storeManRegister = findViewById(R.id.storeManRegister);
        storeManRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(MainLoginRegister.this, RegisterManager.class);//change to register manager page
                startActivity(inToMain);
            }
        });


    }//onCreate
}//class