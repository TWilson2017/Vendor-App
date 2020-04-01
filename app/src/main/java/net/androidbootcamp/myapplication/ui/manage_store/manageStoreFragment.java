package net.androidbootcamp.myapplication.ui.manage_store;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import net.androidbootcamp.myapplication.Product;
import net.androidbootcamp.myapplication.R;

import java.util.List;

public class manageStoreFragment extends Fragment {
    private EditText item_qty, prod_name, sku_num, item_type, item_price;
    private Button add_item;
    private GalleryViewModel galleryViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @NonNull ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.add_items, container, false);
        return root;
    }// end oncreateview

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //-------------------------------
        // add new item  Input
        //-------------------------------

        final TextView item_qty = view.findViewById(R.id.item_qty);
        final TextView prod_name = view.findViewById(R.id.prod_name);
        final TextView sku_num = view.findViewById(R.id.sku_num);
        final TextView item_type = view.findViewById(R.id.item_type);
        final TextView item_price = view.findViewById(R.id.item_price);
        final Button add_item_btn = view.findViewById(R.id.add_item_btn);

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

                //ParseQuery<ParseObject> query = ParseQuery.getQuery("Brand");
                //                query.getInBackground(from store table(storeId), new GetCallback<Store>()

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Brand");
                query.getInBackground("9N3gENt4cE", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                        Product products = new Product();
                        products.setpro_name(prod_name.getText().toString());
                        products.setpro_price(Double.parseDouble(item_price.getText().toString()));
                        products.setpro_quantity(Integer.parseInt(item_qty.getText().toString()));
                        products.setsku_num(Integer.parseInt(sku_num.getText().toString()));
                        products.setpro_type(item_type.getText().toString());
                        products.setBrandId(object);

                        products.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    Toast toast = Toast.makeText(getContext(), "Item Added", Toast.LENGTH_LONG);
                                    toast.show();
                                } else {
                                    Log.d("unable add item", e.toString());
                                    Toast toast = Toast.makeText(getContext(), "Unable to Add New Item.", Toast.LENGTH_LONG);
                                    toast.show();

                                }//end if
                            }//end done
                        });//end query


                    }//end done
                });//end getinbackground
            }//end on click
        });//onclicklistener
    }
}//end galleryFragment


