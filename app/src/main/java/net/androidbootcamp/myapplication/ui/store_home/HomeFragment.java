package net.androidbootcamp.myapplication.ui.store_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import net.androidbootcamp.myapplication.Product;
import net.androidbootcamp.myapplication.R;
import net.androidbootcamp.myapplication.itemList_adapter;
import net.androidbootcamp.myapplication.ui.update_item.updateItemFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    protected RecyclerView item;
    protected itemList_adapter adapter;
    protected List<Product> store_inv;
    protected Button EditBtn;
    protected TextView skuNum;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @NonNull ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home_items, container, false);
        return root;
    }// end oncreateview


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        item = view.findViewById(R.id.item);
        EditBtn = view.findViewById(R.id.EditBtn);
        skuNum = view.findViewById(R.id.skuNum);
        store_inv = new ArrayList<>();
        adapter = new itemList_adapter(getContext(), store_inv);
        item.setAdapter(adapter);
        item.setLayoutManager(new LinearLayoutManager(getContext()));


        EditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = getActivity().getIntent();
                i.putExtra("sku", skuNum.getText().toString());

                updateItemFragment newGamefragment = new updateItemFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.itemView, newGamefragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });



        ParseQuery<Product> query = ParseQuery.getQuery("Product");
        query.findInBackground(new FindCallback<Product>() {
            @Override
            public void done(List<Product> inv, ParseException e) {
                if (e == null) {
                    adapter.clear();
                    adapter.addAll(inv);
                }//end if

            }
        });

    }//end onViewCreated
}