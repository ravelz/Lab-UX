package com.example.labux.ui.slideshow;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.labux.R;
import com.example.labux.databinding.FragmentSlideshowBinding;
import com.example.labux.databinding.FragmentTicketFormBinding;
import com.example.labux.ui.home.DataModel;

public class TicketFormFragment extends Fragment {

    private FragmentTicketFormBinding binding;
    private Double totalCost = Double.valueOf(0);
    private Integer qty = 0;
    private Boolean checked = false;
    private Handler handler = new Handler();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTicketFormBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        EditText quantityEditText = binding.quantityEditText;
        Button buttonBuy = binding.btnBuyTicket;
        EditText nameEditText = binding.customerNameEditText;
        TextView errorTextView = binding.errorMessageTextView;
        ImageView imageView = binding.imageView;


        DataModel ticket = (DataModel) getArguments().get("selected");
        totalCost = Double.valueOf(ticket.getPrice());

        binding.item1.setText(ticket.title);
        binding.item2.setText(ticket.location);
        binding.eventDate.setText(ticket.date);
        binding.description.setText(ticket.description);

        imageView.setImageResource(ticket.getDrawable());

        RadioGroup radioGroup = binding.radioGroup;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                Log.d(TAG, "onCheckedChanged: " + checkedId + "     " + R.id.radio_regular);
                checked = true;
            }
        });

        quantityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String apalah = quantityEditText.getText().toString();
                if(apalah.isEmpty() || apalah == "0"){
                    return;
                }

                quantityEditText.setText(apalah);
            }
        });

        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameEditText.getText().toString().isEmpty()){
                    String errorMessage = "Customer name must be filled";
                    errorTextView.setText(errorMessage);
                    errorTextView.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Setelah jeda, sembunyikan TextView
                            errorTextView.setVisibility(View.INVISIBLE);
                        }
                    }, 2000);
                }else if (!checked){
                    String errorMessage = "Booth type must be checked";
                    errorTextView.setText(errorMessage);
                    errorTextView.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Setelah jeda, sembunyikan TextView
                            errorTextView.setVisibility(View.INVISIBLE);
                        }
                    }, 2000);
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