package net.androidbootcamp.myapplication.ui.manage_store;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import net.androidbootcamp.myapplication.R;

public class manageStoreFragment extends Fragment {
    private EditText item_qty, prod_name, sku_num, item_type, item_price;
    private Button add_item;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.add_items, container, false);

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            //    textView.setText(s);
            }
        });


        return root;
    }
    public void goToAttract(View v)
    {
        Intent intent = new Intent(getActivity(), manageStore.class);
        startActivity(intent);
    }//end gotoattract

}//end galleryFragment


