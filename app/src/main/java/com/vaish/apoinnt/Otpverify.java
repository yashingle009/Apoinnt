package com.vaish.apoinnt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vaish.apoinnt.HomeActivity;
import com.vaish.apoinnt.R;

public class Otpverify extends AppCompatActivity {
    EditText inputnumber1, inputnumber2, inputnumber3, inputnumber4, inputnumber5, inputnumber6;
    Button verify;
    String getotpbackend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_recieve);

        inputnumber1 = findViewById(R.id.inputotp1);
        inputnumber2 = findViewById(R.id.inputotp2);
        inputnumber3 = findViewById(R.id.inputotp3);
        inputnumber4 = findViewById(R.id.inputotp4);
        inputnumber5 = findViewById(R.id.inputotp5);
        inputnumber6 = findViewById(R.id.inputotp6);
        verify = findViewById(R.id.verifyotp);

        // Check if user is already signed in
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            // User is already signed in, navigate to HomeActivity
            startActivity(new Intent(Otpverify.this, HomeActivity.class));
            finish(); // Finish the current activity
        }

        getotpbackend = getIntent().getStringExtra("backendotp");

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your existing onClick logic for verifying OTP
                if (getotpbackend != null) {
                    // Your existing code to verify the OTP
                }
            }
        });

        numberotpmove();
    }

    private void numberotpmove() {
        // Your existing code for moving focus between EditTexts
    }
}
