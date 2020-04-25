package net.androidbootcamp.myapplication.ui.moditem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.androidbootcamp.myapplication.R;

public class ModItemFragment extends Fragment {
    private EditText itemQty, itemPrice, itemName, itemType;
    private Button updateButton;


    public static ModItemFragment newInstance() {
        return new ModItemFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.mod_item_fragment, container, false);
        View root = inflater.inflate(R.layout.mod_item_fragment, container, false);
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        final TextView itemQty = view.findViewById(R.id.itemQty);
        final TextView itemPrice = view.findViewById(R.id.itemPrice);
        final TextView itemName = view.findViewById(R.id.itemName);
        final TextView itemType = view.findViewById(R.id.itemType);

        final Button updateButton = view.findViewById(R.id.updateButton);
    }

}
