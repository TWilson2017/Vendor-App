package net.androidbootcamp.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import net.androidbootcamp.myapplication.ui.addmanger.AddMangerFragment;

public class AddManger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_manger_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AddMangerFragment.newInstance())
                    .commitNow();
        }
    }
}
