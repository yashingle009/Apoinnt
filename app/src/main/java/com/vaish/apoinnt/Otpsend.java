package com.vaish.apoinnt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

 
    



    public class Otpsend extends AppCompatActivity {
        Button login_btn;
        EditText inputnumber;
        ProgressBar progressBar;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_otp_send);

            login_btn = findViewById(R.id.get_otp);
            inputnumber = findViewById(R.id.input_mobile_number);
            final ProgressBar progressBar=findViewById(R.id.progressbar_verify_otp);

            login_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if  (!inputnumber.getText().toString().trim().isEmpty()) {
                        if ((inputnumber.getText().toString().trim()).length() == 10) {
                            progressBar.setVisibility(View.VISIBLE);
                            login_btn.setVisibility(View.INVISIBLE);


                            progressBar.setVisibility(View.VISIBLE);
                            login_btn.setVisibility(View.INVISIBLE);

                            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                    "+91" + inputnumber.getText().toString(), 60,TimeUnit.SECONDS,
                                    Otpsend.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                        @Override
                                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                            progressBar.setVisibility(View.GONE);
                                            login_btn.setVisibility(View.VISIBLE);

                                        }





                                        @Override
                                        public void onVerificationFailed(@NonNull FirebaseException e) {
                                            progressBar.setVisibility(View.GONE);
                                            login_btn.setVisibility(View.VISIBLE);
                                Toast.makeText(Otpsend.this,e.getMessage() ,
                                        Toast.LENGTH_SHORT).show();
                                        }
                            @Override
                            public void onCodeSent(@NonNull String backendotp,
                                    @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                progressBar.setVisibility(View.GONE);
                                login_btn.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(),Otpverify.class);
                                intent.putExtra("mobile", inputnumber.getText().toString());
                                intent.putExtra("backendotp",backendotp);
                                startActivity(intent);

                            }
                        }
                        );

                    } else {
                        Toast.makeText(Otpsend.this, "Please enter correct number",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Otpsend.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }

                                    }

                        }
                            );
                        }
                    }




