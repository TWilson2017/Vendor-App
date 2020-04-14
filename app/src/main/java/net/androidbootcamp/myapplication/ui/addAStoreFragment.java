package net.androidbootcamp.myapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import net.androidbootcamp.myapplication.R;

public class addAStoreFragment extends Fragment {
    EditText store_name, street_address, store_city, zip_code, tax_id, phone_num, acct_num, routing_num, state_id, username, password;
    Button submit_button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @NonNull ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.add_store, container, false);
        return root;
    }// end oncreateview

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //-------------------------------
        // Vendor Registration Input
        //-------------------------------
        store_name = view.findViewById(R.id.store_name);
        street_address = view.findViewById(R.id.street_address);
        store_city = view.findViewById(R.id.store_city);
        zip_code = view.findViewById(R.id.zip_code);
        /*tax_id = findViewById(R.id.tax_id);
        phone_num = findViewById(R.id.phone_num);
        acct_num = findViewById(R.id.acct_num);
        routing_num = findViewById(R.id.routing_num);
        state_id = findViewById(R.id.state_id);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);*/

        //-----------------------------------
        //submit vendor registry info
        //------------------------------------
        submit_button = view.findViewById(R.id.submit4_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String storeNameResult = store_name.getText().toString();
                final String streetAddressResult = street_address.getText().toString();
                final String storeCityResult = store_city.getText().toString();
                final String zipCodeResult = zip_code.getText().toString();
                /*final String taxIdResult = tax_id.getText().toString();
                final String phoneNumberResult = phone_num.getText().toString();
                final String accountNumberResult = acct_num.getText().toString();
                final String routingNumberResult = routing_num.getText().toString();
                final String stateResult = state_id.getText().toString();
                final String passwordResult = password.getText().toString();
                final String usernameResult = username.getText().toString();*/

                if (storeNameResult.isEmpty() || streetAddressResult.isEmpty() || storeCityResult.isEmpty() ||
                        zipCodeResult.isEmpty()) {//|| taxIdResult.isEmpty() || phoneNumberResult.isEmpty() ||
                    //accountNumberResult.isEmpty() || routingNumberResult.isEmpty() || stateResult.isEmpty() || passwordResult.isEmpty() || usernameResult.isEmpty()) {
                    //Toast.makeText(Register_Vendor.this, "Complete the registration fields.", Toast.LENGTH_SHORT).show();
                } else {
                    ParseObject newStore = new ParseObject("Store");
                    newStore.put("sto_name", storeNameResult);
                    newStore.put("sto_city", storeCityResult);
                    //newStore.put("ven_routing_num", Integer.parseInt(routingNumberResult));
                    //newStore.put("ven_phone", Integer.parseInt(phoneNumberResult));
                    newStore.put("sto_zipcode", zipCodeResult);
                    //newStore.put("ven_tax_id", Integer.parseInt(taxIdResult));
                    //newStore.put("ven_state", stateResult);
                    //newStore.put("ven_account_num", Integer.parseInt(accountNumberResult));
                    //.put("ven_street_address", streetAddressResult);
                    //newStore.put("password", passwordResult);
                    //newStore.put("username", usernameResult);

                    newStore.saveInBackground(new SaveCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                /*Toast.makeText(Register_Vendor.this, "Store Created.", Toast.LENGTH_SHORT).show();
                                Intent c = new Intent(Register_Vendor.this, Manager_Vendor_Login.class);
                                startActivity(c);*/
                            } else {
                                // Error occurred
                                //Toast.makeText(Register_Vendor.this, e.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
            }
        });
    }
}
