package net.androidbootcamp.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterManager extends AppCompatActivity {
    TextView manFname, manLname, storeId, managerUser, mangerPassword;
    Button registerManagerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_manager);

        manFname = findViewById(R.id.manFname);
        manLname = findViewById(R.id.manLname);
        storeId = findViewById(R.id.storeId);
        managerUser = findViewById(R.id.managerUser);
        mangerPassword = findViewById(R.id.mangerPassword);
        registerManagerBtn = findViewById(R.id.registerManagerBtn);

        //connect to database
    }
}
