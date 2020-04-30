package net.androidbootcamp.myapplication.ui.moditem;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.androidbootcamp.myapplication.Product;
import net.androidbootcamp.myapplication.R;
import net.androidbootcamp.myapplication.itemList_adapter;

import java.util.ArrayList;

public class ModItemFragment extends Fragment {
    private final Context context;
    ArrayAdapter adapter;
    private Button updateButton;
    itemList_adapter items;
    int current_page = 1;
    SearchView searchView;
    ListView listOfProducts;
    private EditText itemQty, itemPrice, itemName, itemType, skuDisplay;
    private ArrayList<Product> products;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.mod_item_fragment, container, false);
        View root = inflater.inflate(R.layout.mod_item_fragment, container, false);
        return root;
    }

    public ModItemFragment(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }
    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        final TextView itemQty = view.findViewById(R.id.itemQty);
        final TextView itemPrice = view.findViewById(R.id.itemPrice);
        final TextView itemName = view.findViewById(R.id.itemName);
        final TextView itemType = view.findViewById(R.id.itemType);
        final TextView skuDisplay = view.findViewById(R.id.skuDisplay);
        final Button updateButton = view.findViewById(R.id.updateButton);
        final ListView listOfProducts = view.findViewById(R.id.listOfProducts);


        items.addAll(products);
        ArrayList<Product> products = new ArrayList<>();
        adapter = new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1,
                products);

        listOfProducts.setAdapter(adapter);



    }


}
