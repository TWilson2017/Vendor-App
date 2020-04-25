package net.androidbootcamp.myapplication.ui.store_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import net.androidbootcamp.myapplication.Product;
import net.androidbootcamp.myapplication.R;
import net.androidbootcamp.myapplication.itemList_adapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    protected RecyclerView item;
    protected itemList_adapter adapter;
    protected List<Product> store_inv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @NonNull ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home_items, container, false);
        return root;
    }// end oncreateview


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        item = view.findViewById(R.id.item);
        store_inv = new ArrayList<>();
        adapter = new itemList_adapter(getContext(), store_inv);
        item.setAdapter(adapter);
        item.setLayoutManager(new LinearLayoutManager(getContext()));

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