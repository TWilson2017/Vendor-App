package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register_Vendor extends AppCompatActivity {
    TextView store_num,street_address,store_city,zip_code,tax_id,phone_num,acct_num,routing_num;
    Button submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__vendor);

        //-------------------------------
        //vendor registration input
        //-------------------------------
        store_num = findViewById(R.id.store_num);

        street_address = findViewById(R.id.street_address);

        store_city = findViewById(R.id.store_city);

        zip_code = findViewById(R.id.zip_code);

        tax_id = findViewById(R.id.tax_id);
        phone_num = findViewById(R.id.phone_num);

        acct_num = findViewById(R.id.acct_num);

        routing_num = findViewById(R.id.routing_num);

        //-----------------------------------
        //submit vendor registry info
        //------------------------------------
        submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register_Vendor.this,"Store Created.", Toast.LENGTH_SHORT).show();
                Intent c = new Intent(Register_Vendor.this,Register_Vendor.class);
           startActivity(c);
            }
        });





    }
}
