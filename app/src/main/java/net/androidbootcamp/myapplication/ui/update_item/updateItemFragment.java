package net.androidbootcamp.myapplication.ui.update_item;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class updateItemFragment extends Fragment {
    private EditText item_qty, prod_name, sku_num, item_type, item_price;
    private Button add_item;
    private UpdateViewModel galleryViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @NonNull ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.add_items, container, false);
        return root;
    }// end oncreateview

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //-------------------------------
        // Update item
        //-------------------------------

        final EditText item_qty = view.findViewById(R.id.item_qty);
        final EditText prod_name = view.findViewById(R.id.prod_name);
        final EditText sku_num = view.findViewById(R.id.sku_num);
        final EditText item_type = view.findViewById(R.id.item_type);
        final EditText item_price = view.findViewById(R.id.item_price);
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
                final String pro_type = item_type.getText().toString();
                final String pro_sku_num = sku_num.getText().toString();
                final String pro_price = item_price.getText().toString();
                final String pro_name = prod_name.getText().toString();
                final String pro_quantity = item_qty.getText().toString();
                String objectID = "";

                if (pro_type.isEmpty() || pro_name.isEmpty() || pro_price.isEmpty() ||
                        pro_quantity.isEmpty() || pro_sku_num.isEmpty()) {
                    Toast.makeText(getActivity(), "Complete the text fields.", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(getActivity(), "Item does not exist", Toast.LENGTH_LONG).show();
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
                                    Toast.makeText(getActivity(), "Item Updated.", Toast.LENGTH_SHORT).show();
                                    item_qty.getText().clear();
                                    prod_name.getText().clear();
                                    sku_num.getText().clear();
                                    item_type.getText().clear();
                                    item_price.getText().clear();
                                } else {
                                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}


