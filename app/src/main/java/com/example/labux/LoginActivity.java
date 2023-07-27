package com.example.labux;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    public static String usernameGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });
    }

    //    Agar label di hide ketika user menginput sesuatu di text field
    //    Validasi Section
    private Handler handler = new Handler();
    private void validateInput(){
        TextInputLayout usernameField = findViewById(R.id.usernameField);
        TextInputLayout passwordField = findViewById(R.id.passwordField);
        TextInputEditText usernameEditText = findViewById(R.id.usernameEditText);
        TextInputEditText passwordEditText = findViewById(R.id.passwordEditText);
        TextView errorMessageTextView = findViewById(R.id.errorMessageTextView);

        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

//        Validasi pertama : memastikan username terisi
        if(username.isEmpty()){
            String errorMessage = "Username must be filled";
            errorMessageTextView.setText(errorMessage);
            errorMessageTextView.setVisibility(View.VISIBLE);

            // Tambahkan delay selama 2000 milidetik (2 detik)
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Setelah jeda, sembunyikan TextView
                    errorMessageTextView.setVisibility(View.INVISIBLE);
                }
            }, 2000);

            return;
        }

//        Validasi kedua : memastikan password terisi
        if(password.isEmpty()){
            String errorMessage = "Password must be filled";
            errorMessageTextView.setText(errorMessage);
            errorMessageTextView.setVisibility(View.VISIBLE);

            // Tambahkan delay selama 2000 milidetik (2 detik)
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Setelah jeda, sembunyikan TextView
                    errorMessageTextView.setVisibility(View.INVISIBLE);
                }
            }, 2000);

            return;
        }

//        Validasi ketiga : username length > 5 karakter
        if (username.length() <= 5){
            String errorMessage = "Username length must be greater than 5";
            errorMessageTextView.setText(errorMessage);
            errorMessageTextView.setVisibility(View.VISIBLE);

            // Tambahkan delay selama 2000 milidetik (2 detik)
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Setelah jeda, sembunyikan TextView
                    errorMessageTextView.setVisibility(View.INVISIBLE);
                }
            }, 2000);

            return;
        }

//        Validasi keempat : password length > 8 karakter
        if(password.length() <= 8){
            String errorMessage = "Password length must be greater than 8";
            errorMessageTextView.setText(errorMessage);
            errorMessageTextView.setVisibility(View.VISIBLE);

            // Tambahkan delay selama 2000 milidetik (2 detik)
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Setelah jeda, sembunyikan TextView
                    errorMessageTextView.setVisibility(View.INVISIBLE);
                }
            }, 2000);

            return;
        }
        usernameGlobal = username;
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
//
//        errorMessageTextView.setText("SUCCESS CUY");
//        errorMessageTextView.setVisibility(View.VISIBLE);
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // Setelah jeda, sembunyikan TextView
//                errorMessageTextView.setVisibility(View.INVISIBLE);
//
//            }
//        }, 2000);

    }

}
