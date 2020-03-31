package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class Register_Vendor extends AppCompatActivity {
    EditText store_name, street_address, store_city, zip_code, tax_id, phone_num, acct_num, routing_num, state_id, username, password;
    Button submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__vendor);

        //-------------------------------
        // Vendor Registration Input
        //-------------------------------
        store_name = findViewById(R.id.store_name);
        street_address = findViewById(R.id.street_address);
        store_city = findViewById(R.id.store_city);
        zip_code = findViewById(R.id.zip_code);
        tax_id = findViewById(R.id.tax_id);
        phone_num = findViewById(R.id.phone_num);
        acct_num = findViewById(R.id.acct_num);
        routing_num = findViewById(R.id.routing_num);
        state_id = findViewById(R.id.state_id);
       username = findViewById(R.id.username);
       password = findViewById(R.id.password);
        //-----------------------------------
        //submit vendor registry info
        //------------------------------------
        submit_button = findViewById(R.id.submit4_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String storeNameResult = store_name.getText().toString();
                final String streetAddressResult = street_address.getText().toString();
                final String storeCityResult = store_city.getText().toString();
                final String zipCodeResult = zip_code.getText().toString();
                final String taxIdResult = tax_id.getText().toString();
                final String phoneNumberResult = phone_num.getText().toString();
                final String accountNumberResult = acct_num.getText().toString();
                final String routingNumberResult = routing_num.getText().toString();
                final String stateResult = state_id.getText().toString();
                final String passwordResult = password.getText().toString();
                final String usernameResult = username.getText().toString();

                if (storeNameResult.isEmpty() || streetAddressResult.isEmpty() || storeCityResult.isEmpty() ||
                        zipCodeResult.isEmpty() || taxIdResult.isEmpty() || phoneNumberResult.isEmpty() ||
                        accountNumberResult.isEmpty() || routingNumberResult.isEmpty() || stateResult.isEmpty()|| passwordResult.isEmpty() || usernameResult.isEmpty()){
                    Toast.makeText(Register_Vendor.this, "Complete the registration fields.", Toast.LENGTH_SHORT).show();
                } else {
                    ParseObject newStore = new ParseObject("Vendor");
                    newStore.put("ven_city", storeCityResult);
                    newStore.put("ven_name", storeNameResult);
                    newStore.put("ven_routing_num", Integer.parseInt(routingNumberResult));
                    newStore.put("ven_phone", Integer.parseInt(phoneNumberResult));
                    newStore.put("ven_zipcode", zipCodeResult);
                    newStore.put("ven_tax_id", Integer.parseInt(taxIdResult));
                    newStore.put("ven_state", stateResult);
                    newStore.put("ven_account_num", Integer.parseInt(accountNumberResult));
                    newStore.put("ven_street_address", streetAddressResult);
                    newStore.put("password", passwordResult);
                    newStore.put("username", usernameResult);

                    newStore.saveInBackground(new SaveCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(Register_Vendor.this, "Store Created.", Toast.LENGTH_SHORT).show();
                                Intent c = new Intent(Register_Vendor.this, Manager_Vendor_Login.class);
                                startActivity(c);
                            } else {
                                // Error occurred
                                Toast.makeText(Register_Vendor.this, e.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
            }
        });
    }
}
