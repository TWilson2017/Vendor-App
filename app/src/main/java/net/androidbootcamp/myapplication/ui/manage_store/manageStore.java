package net.androidbootcamp.myapplication.ui.manage_store;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import net.androidbootcamp.myapplication.Product;
import net.androidbootcamp.myapplication.R;
import net.androidbootcamp.myapplication.ui.store_home.HomeFragment;

import java.util.List;

public class manageStore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gallery);

        //-------------------------------
        // add new item  Input
        //-------------------------------
        final TextView item_qty = findViewById(R.id.item_qty);
        final TextView prod_name = findViewById(R.id.prod_name);
        final TextView sku_num = findViewById(R.id.sku_num);
        final TextView item_type = findViewById(R.id.item_type);
        final TextView item_price = findViewById(R.id.item_price);
        final Button btnResolve = findViewById(R.id.add_item);

        // Bundle extra = getIntent().getExtras();

        final ParseQuery<Product> query =
                ParseQuery.getQuery("Product");
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
        });//onCreate
        btnResolve.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ParseQuery<Product> query = ParseQuery.getQuery("Product");

                query.getInBackground(sku_num.getText().toString(), new GetCallback<Product>() {
                    @Override
                    public void done(Product products, ParseException e) {
                        if (e == null) {
                            products.setpro_name(prod_name.getText().toString());
                            products.setpro_price(Double.parseDouble(item_price.getText().toString()));
                            products.setpro_quantity(Integer.parseInt(item_qty.getText().toString()));
                            products.setsku_num(Integer.parseInt(sku_num.getText().toString()));
                            products.setpro_type(item_type.getText().toString());
                            products.saveInBackground();

                            Toast toast = Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_LONG);
                            toast.show();

                            Intent inToMain = new Intent(manageStore.this, HomeFragment.class);
                            startActivity(inToMain);
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), "Unable to Add New Item.", Toast.LENGTH_LONG);
                            toast.show();

                        }//end if
                    }//end done
                });//end query
            }//end on click
        });//onclicklistener
    }//onCreate
}//Class