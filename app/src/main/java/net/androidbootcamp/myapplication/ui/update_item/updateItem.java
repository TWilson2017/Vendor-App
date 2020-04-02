package net.androidbootcamp.myapplication.ui.update_item;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import net.androidbootcamp.myapplication.Product;
import net.androidbootcamp.myapplication.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class updateItem extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_items);
        //-------------------------------
        // Update item
        //-------------------------------

        final EditText item_qty = findViewById(R.id.item_qty);
        final EditText prod_name = findViewById(R.id.prod_name);
        final EditText sku_num = findViewById(R.id.sku_num);
        final EditText item_type = findViewById(R.id.item_type);
        final EditText item_price = findViewById(R.id.item_price);
        final Button add_item_btn = findViewById(R.id.add_item_btn);

        final ParseQuery<Product> query = ParseQuery.getQuery("Product");
        query.whereEqualTo("pro_sku_num", sku_num);
        query.findInBackground(new FindCallback<Product>() {
            @Override
            public void done(List<Product> products, ParseException e) {
                if (e == null) {

                    item_qty.setText(products.get(0).getpro_quantity());
                    prod_name.setText(products.get(0).getpro_name());
                    item_type.setText(products.get(0).getpro_type());
                    item_price.setText(Double.toString(products.get(0).getpro_price()));
                    sku_num.setText(Integer.toString(products.get(0).getpro_quantity()));

                }//end if
            }//end done
        });//findInBackground

        add_item_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String pro_type = item_type.getText().toString();
                final String pro_sku_num = sku_num.getText().toString();
                final String pro_price = item_price.getText().toString();
                final String pro_name = prod_name.getText().toString();
                final String pro_quantity = item_qty.getText().toString();
                String objectID = "";

                if (pro_type.isEmpty() || pro_name.isEmpty() || pro_price.isEmpty() ||
                        pro_quantity.isEmpty() || pro_sku_num.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Complete the text fields.", Toast.LENGTH_SHORT).show();
                } else {
                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Product");
                    query.whereEqualTo("pro_sku_num", Integer.parseInt(pro_sku_num));
                    List<ParseObject> results = null;

                    try {
                        results = query.find();
                        if (!results.isEmpty()) {
                            objectID = results.get(0).getObjectId();
                        }
                    } catch (ParseException e) {
                        System.out.println("Something went wrong.");
                    }
                    if (objectID.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Item does not exist", Toast.LENGTH_LONG).show();
                    } else {
                        // Retrieve the object by id
                        query.getInBackground(objectID, new GetCallback<ParseObject>() {
                            public void done(ParseObject object, ParseException e) {
                                if (e == null) {
                                    object.put("pro_type", pro_type);
                                    object.put("pro_sku_num", Integer.parseInt(pro_sku_num));
                                    object.put("pro_price", Double.parseDouble(pro_price));
                                    object.put("pro_name", pro_name);
                                    object.put("pro_quantity", Integer.parseInt(pro_quantity));
                                    object.saveInBackground();
                                } else {
                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}
