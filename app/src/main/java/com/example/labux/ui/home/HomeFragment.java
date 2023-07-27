package com.example.labux.ui.home;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.labux.MainActivity;
import com.example.labux.R;
import com.example.labux.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);



        SliderView sliderView = binding.imageSlider;

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        sliderDataArrayList.add(new SliderData(R.drawable.jalihara_logo));
        sliderDataArrayList.add(new SliderData(R.drawable.image_example_ticketform));
        sliderDataArrayList.add(new SliderData(R.drawable.jalihara_logo));

        SliderAdapter adapter = new SliderAdapter(requireContext(), sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

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

    public void onSplitTypeChanged(RadioGroup radioGroup, int id) {
        // Is the button now checked?
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check which radio button was clicked
                if (checkedId == R.id.radio_regular){
                    Toast.makeText(getActivity(), "Regular", Toast.LENGTH_SHORT);

                }else if (checkedId == R.id.radio_silver){
                    Toast.makeText(getActivity(), "Silver", Toast.LENGTH_SHORT);

                }else if (checkedId == R.id.radio_gold){
                    Toast.makeText(getActivity(), "Gold", Toast.LENGTH_SHORT);

                }
            }
        });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }




}