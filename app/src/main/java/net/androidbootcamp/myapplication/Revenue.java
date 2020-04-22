package net.androidbootcamp.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import net.androidbootcamp.myapplication.ui.revenue.RevenueFragment;

public class Revenue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revenue_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, RevenueFragment.newInstance())
                    .commitNow();
        }
    }
}
