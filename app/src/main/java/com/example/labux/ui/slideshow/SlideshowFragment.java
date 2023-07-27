package com.example.labux.ui.slideshow;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.labux.R;
import com.example.labux.databinding.FragmentSlideshowBinding;
import com.example.labux.ui.home.DataModel;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        DataModel ticket = (DataModel) getArguments().get("selected");

        binding.item1.setText(ticket.title);
        binding.item2.setText(ticket.location);
        binding.eventDate.setText(ticket.date);
        binding.description.setText(ticket.description);

        RadioGroup radioGroup = binding.radioGroup;

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                Log.d(TAG, "onCheckedChanged: " + checkedId + "     " + R.id.radio_regular);
                if (checkedId == R.id.radio_regular){
                    binding.boothTypeLabel.setText("Sue");

                }else if (checkedId == R.id.radio_silver){
                    Toast.makeText(getContext(), "Silver", Toast.LENGTH_SHORT);
                    binding.boothTypeLabel.setText("Sue 1");

                }else if (checkedId == R.id.radio_gold){
                    Toast.makeText(getContext(), "Gold", Toast.LENGTH_SHORT);

                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}