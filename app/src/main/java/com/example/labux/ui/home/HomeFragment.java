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
        TextView usernameTextView = binding.placeholderUsername;
        usernameTextView.setText(LoginActivity.usernameGlobal + "!");

        SliderView sliderView = binding.imageSlider;
        SliderView doubleSliderView = binding.imageSlider1;

        arrayList = new ArrayList();

        arrayList.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.slider_ticket1, R.drawable.ticket1, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 2", 5000000, "02 August 2023", R.drawable.slider_ticket2, R.drawable.ticket2, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 3", 5000000, "02 August 2023", R.drawable.slider_ticket3, R.drawable.ticket3,"10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 4", 5000000, "02 August 2023", R.drawable.slider_ticket3, R.drawable.ticket3,"10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayList.add(new DataModel("Title Event 5", 5000000, "02 August 2023", R.drawable.slider_ticket5, R.drawable.ticket5,"10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));

//        arrayList1 = new ArrayList();
//
//        arrayList1.add(new DataModel("Title Event 6", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
//        arrayList1.add(new DataModel("Title Event 5", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
//        arrayList1.add(new DataModel("Title Event 4", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
//        arrayList1.add(new DataModel("Title Event 3", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
//        arrayList1.add(new DataModel("Title Event 2", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
//        arrayList1.add(new DataModel("Title Event 1", 5000000, "02 August 2023", R.drawable.jalihara_logo, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));





        SliderAdapter adapter = new SliderAdapter(root, arrayList);

        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        ArrayList arrayTicketOdd = new ArrayList();
        arrayTicketOdd.add(new DataModel("Ephemeral Dreams", 5000000, "02 August 2023", R.drawable.slider_ticket1, R.drawable.ticket1, "10:00 PM", "Jakarta, Indonesia", "Experience the fleeting beauty of \"Ephemeral Dreams,\" an exquisite art exhibition that explores the transient nature of existence. Serenity Art Gallery invites you to immerse yourself in a world of delicate brushstrokes, fleeting emotions, and ephemeral visions captured by a collection of talented artists. Join us as we contemplate the impermanence of life through the lens of art."));
        arrayTicketOdd.add(new DataModel("Beyond Boundaries", 5000000, "02 August 2023", R.drawable.slider_ticket3, R.drawable.ticket3, "10:00 PM", "Jakarta, Indonesia", "Discover the power of human creativity at \"Beyond Boundaries,\" an eclectic art event that pushes the limits of artistic expression. Gallery X proudly presents a diverse showcase of paintings, sculptures, and multimedia installations that transcend conventional boundaries. Delve into a realm where art knows no limits and imagination takes flight."));
        arrayTicketOdd.add(new DataModel("Urban Rhythms", 5000000, "02 August 2023",R.drawable.slider_ticket5, R.drawable.ticket5, "10:00 PM", "Jakarta, Indonesia", "Embark on an artistic journey through the heart of the city with \"Urban Rhythms.\" This dynamic event celebrates the vibrant street art scene, transforming public spaces into captivating galleries. Join the free walking tour to witness the colorful murals, graffiti, and urban art installations that breathe life into the urban landscape."));
        arrayTicketOdd.add(new DataModel("Sculptures in Nature", 5000000, "02 August 2023", R.drawable.ticket7,R.drawable.ticket7, "10:00 PM", "Jakarta, Indonesia", "Nature and art converge at \"Sculptures in Nature,\" an enchanting outdoor art exhibition nestled within the lush surroundings of Enchanted Woods Park. Wander through the tranquil pathways to discover an array of stunning sculptures harmoniously integrated into the natural environment. Experience the symbiosis of art and nature like never before."));
        arrayTicketOdd.add(new DataModel("Digital Realms", 5000000, "02 August 2023", R.drawable.ticket9,R.drawable.ticket9, "10:00 PM", "Jakarta, Indonesia", "Embark on a virtual journey into \"Digital Realms,\" an innovative exhibition that merges art and technology. Accessible from the comfort of your home, this online gallery showcases cutting-edge digital art, interactive installations, and virtual reality experiences. Immerse yourself in a world where pixels and imagination collide."));

        ArrayList arrayTicketEven = new ArrayList();
        arrayTicketEven.add(new DataModel("Reflections of Identity", 5000000, "02 August 2023", R.drawable.slider_ticket2, R.drawable.ticket2, "10:00 PM", "Jakarta, Indonesia", "Heritage Art Center presents \"Reflections of Identity,\" a thought-provoking art show that delves into the complexities of personal and cultural identity. Experience the emotive power of art as artists express their unique narratives and examine the ever-evolving tapestry of human identity."));
        arrayTicketEven.add(new DataModel("Whimsical Wonders", 5000000, "02 August 2023", R.drawable.slider_ticket4, R.drawable.ticket4, "10:00 PM", "Jakarta, Indonesia", "Step into the enchanting world of \"Whimsical Wonders,\" an art event hosted within the captivating Fairyland Gardens. Delight in a magical display of fairy tale-inspired illustrations, fanciful sculptures, and fantastical installations that transport visitors to a realm where imagination reigns supreme."));
        arrayTicketEven.add(new DataModel("Abstract Visions", 5000000, "02 August 2023", R.drawable.ticket6,R.drawable.ticket6, "10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayTicketEven.add(new DataModel("Title Event 8", 5000000, "02 August 2023", R.drawable.ticket8, R.drawable.ticket8,"10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));
        arrayTicketEven.add(new DataModel("Title Event 10", 5000000, "02 August 2023", R.drawable.ticket10, R.drawable.ticket10,"10:00 PM", "Jakarta, Indonesia", "Deskripsi Event"));

        DoubleSliderAdapter doubleadapter = new DoubleSliderAdapter(root, arrayTicketOdd, arrayTicketEven);
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