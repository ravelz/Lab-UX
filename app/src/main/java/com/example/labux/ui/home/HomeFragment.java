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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labux.LoginActivity;
import com.example.labux.MainActivity;
import com.example.labux.R;
import com.example.labux.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.SliderView;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeFragment extends Fragment implements RecyclerViewAdapter.ItemListener {

    private FragmentHomeBinding binding;
    RecyclerView recyclerView;
    ArrayList arrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView usernameTextView = binding.username;
        usernameTextView.setText(LoginActivity.usernameGlobal);



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


//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView = binding.recyclerView;
        arrayList = new ArrayList();

        arrayList.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));

        RecyclerViewAdapter adapterGrid = new RecyclerViewAdapter(getActivity(), arrayList, this);
        recyclerView.setAdapter(adapterGrid);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        /*AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);*/


        /**
         Simple GridLayoutManager that spans two columns
         **/
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);



        return root;
    }
    @Override
    public void onItemClick(DataModel item) {
        Toast.makeText(requireContext(), item.title + " is clicked", Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putSerializable("selected", item);
        Navigation.findNavController(getView()).navigate(R.id.action_nav_home_to_ticket_form, bundle);
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