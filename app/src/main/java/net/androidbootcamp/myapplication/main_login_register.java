package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class main_login_register extends AppCompatActivity {
   Button signin_button;
   Button register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_register);



        //------------------
        //signin
        //------------------
        signin_button = findViewById(R.id.submit_button);

        signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(main_login_register.this, MainActivity.class);
                startActivity(inToMain);
            }
        });

        //-----------------------
        //Register
        //-----------------------
        register_button = findViewById(R.id.register_button);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(main_login_register.this,Register_Vendor.class);
                startActivity(inToMain);

            }
        });

    }
}
