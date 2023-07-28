package com.example.labux.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labux.LoginActivity;
import com.example.labux.R;
import com.example.labux.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    ArrayList arrayList, arrayList1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView usernameTextView = binding.welcomeTextView;
        usernameTextView.setText("Welcome back " + LoginActivity.usernameGlobal + "!");

        SliderView sliderView = binding.imageSlider;
        SliderView doubleSliderView = binding.imageSlider1;

        arrayList = new ArrayList();

        arrayList.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 2", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 3", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 4", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 5", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 6", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));

        arrayList1 = new ArrayList();

        arrayList1.add(new DataModel("Title Event 6", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList1.add(new DataModel("Title Event 5", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList1.add(new DataModel("Title Event 4", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList1.add(new DataModel("Title Event 3", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList1.add(new DataModel("Title Event 2", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList1.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));



        SliderAdapter adapter = new SliderAdapter(root, arrayList);
        DoubleSliderAdapter doubleadapter = new DoubleSliderAdapter(root, arrayList, arrayList1);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        doubleSliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        doubleSliderView.setSliderAdapter(doubleadapter);
        doubleSliderView.setScrollTimeInSec(3);
        doubleSliderView.setAutoCycle(true);
        doubleSliderView.startAutoCycle();



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