package net.androidbootcamp.myapplication.ui.addmanger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import net.androidbootcamp.myapplication.R;

public class AddMangerFragment extends Fragment {

    private AddMangerViewModel mViewModel;

    public static AddMangerFragment newInstance() {
        return new AddMangerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_manger_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddMangerViewModel.class);
        // TODO: Use the ViewModel
    }

}
