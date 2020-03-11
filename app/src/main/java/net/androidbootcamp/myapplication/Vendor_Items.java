package net.androidbootcamp.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Vendor_Items extends AppCompatActivity {

    static String vendorName;

    static void setVendorName(String vendorName2) {
        vendorName = vendorName2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_items);

        System.out.println(vendorName);
        if (vendorName.equals("name")) {
            final TextView store = findViewById(R.id.textView5);
            store.setText("Lucky's: 1964 W Tennessee St. Tallahassee, Florida 32304 ");
        } else {
            final TextView store = findViewById(R.id.textView5);
            store.setText("");
        }

        /***Parse.enableLocalDatastore(this);
         Parse.initialize(new Parse.Configuration.Builder(this)
         .applicationId("tishauna-instagram-codepath") // should correspond to APP_ID env variable
         .clientKey(null)  // set explicitly unless clientKey is explicitly configured on Parse server
         .server("http://tishauna-instagram-codepath.herokuapp.com/parse/").build());***/


        /***final ParseQuery<ParseObject> query = ParseQuery.getQuery("Vendor");
         query.whereEqualTo("ven_name", vendorName);
         query.findInBackground(new FindCallback<ParseObject>() {
         public void done(List<ParseObject> list, ParseException e) {
         if (e == null) {
         String objectId = list.get();
         } else {
         Log.d("score", "Error: " + e.getMessage());
         }
         }
         });***/
    }
}
