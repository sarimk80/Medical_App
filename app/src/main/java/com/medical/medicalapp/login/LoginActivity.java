package com.medical.medicalapp.login;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.medical.medicalapp.R;
import com.medical.medicalapp.main.MainActivity;
import com.medical.medicalapp.signup.Signup;


public class LoginActivity extends AppCompatActivity {
    /**
     * THIS ACTIVITY IS RESPONSIBLE FOR USER LOGIN
     * USER CAN LOGIN WITH THEIR GOOGLE ID
     */

    private FirebaseAuth mAuth;
    private EditText Edt_email;
    private EditText Edt_password;
    private Button Btn_signin;
    private TextView Txt_signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Edt_email = findViewById(R.id.Edt_email);
        Edt_password = findViewById(R.id.Edt_password);
        Btn_signin = findViewById(R.id.btn_signin);
        Txt_signup = findViewById(R.id.btn_signup);
        mAuth = FirebaseAuth.getInstance();

        Btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = Edt_email.getText().toString();
                String passwordString = Edt_password.getText().toString();
                if (emailString.isEmpty() || passwordString.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Error Try Again", Toast.LENGTH_LONG).show();
                } else {
                    SignInWithEmailandPassword(emailString, passwordString);
                }

            }
        });

        Txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Signup.class);
                startActivity(intent);
            }
        });

    }

    /**
     * It will check when the activity start weather the user in login or not
     * if it is login it will update the ui otherwise the ui will be the same
     */
    @Override
    protected void onStart() {
        super.onStart();

    }

    private void SignInWithEmailandPassword(String email, String password) {


        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Main", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Main", "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                        if (!task.isSuccessful()) {

                        }

                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }


    private void updateUI(FirebaseUser user) {

        if (user != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {

        }
    }


}
