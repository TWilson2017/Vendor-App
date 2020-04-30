package net.androidbootcamp.myapplication.ui.AddStore;

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

                if (storeNameResult.isEmpty() || streetAddressResult.isEmpty() || storeCityResult.isEmpty() ||
                        zipCodeResult.isEmpty()) {

                } else {
                    ParseObject newStore = new ParseObject("Store");
                    newStore.put("sto_name", storeNameResult);
                    newStore.put("sto_city", storeCityResult);
                    newStore.put("sto_zipcode", zipCodeResult);
                    newStore.saveInBackground(new SaveCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                            } else {

                            }
                        }
                    });
                }
            }
        });
    }
}
