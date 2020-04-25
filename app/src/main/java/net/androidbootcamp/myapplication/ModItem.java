package net.androidbootcamp.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.androidbootcamp.myapplication.ui.moditem.ModItemFragment;

public class ModItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mod_item_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    //.replace(R.id.container,ModItemFragment.newInstance())
                    .replace(R.id.container, ModItemFragment.newInstance())
                    .commitNow();

            final TextView itemQty = findViewById(R.id.itemQty);
            final TextView itemPrice = findViewById(R.id.itemPrice);
            final TextView itemName = findViewById(R.id.itemName);
            final TextView itemType = findViewById(R.id.itemType);

            final Button updateButton = findViewById(R.id.updateButton);


        }
    }
}
