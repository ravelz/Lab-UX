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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labux.R;
import com.example.labux.databinding.FragmentSlideshowBinding;
import com.example.labux.ui.home.DataModel;
import com.example.labux.ui.home.DoubleSliderAdapter;
import com.example.labux.ui.home.RecyclerViewAdapter;
import com.example.labux.ui.home.SliderAdapter;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment implements RecyclerViewAdapter.ItemListener {

    private FragmentSlideshowBinding binding;
    RecyclerView recyclerView;
    ArrayList arrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.recyclerView;
        arrayList = new ArrayList();
        SliderView sliderView = binding.imageSlider;

        arrayList.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.slider_ticket1, R.drawable.ticket1, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 2", 5000000, "02 August 2023", R.drawable.slider_ticket2, R.drawable.ticket2, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 3", 5000000, "02 August 2023", R.drawable.slider_ticket3, R.drawable.ticket3,"10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 4", 5000000, "02 August 2023", R.drawable.slider_ticket3, R.drawable.ticket3,"10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 5", 5000000, "02 August 2023", R.drawable.slider_ticket5, R.drawable.ticket5,"10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));


        TicketSliderAdapter adapter = new TicketSliderAdapter(root, arrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
        RecyclerViewAdapter adapterGrid = new RecyclerViewAdapter(getActivity(), arrayList, this, root);
        recyclerView.setAdapter(adapterGrid);

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}