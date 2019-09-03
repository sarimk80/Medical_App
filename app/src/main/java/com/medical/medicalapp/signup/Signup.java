package com.medical.medicalapp.signup;

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
import com.medical.medicalapp.login.LoginActivity;

import io.reactivex.annotations.NonNull;

public class Signup extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtPassword2;
    private Button btnSignUp;
    private TextView btnSignIn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPassword2 = findViewById(R.id.edtPassword2);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_edit = edtEmail.getText().toString();
                String password_edit = edtPassword.getText().toString();
                String password_edt2 = edtPassword2.getText().toString();
                if (email_edit.isEmpty() || password_edit.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Error Try Again", Toast.LENGTH_LONG).show();
                } else {
                    if (password_edit.equals(password_edt2)) {
                        CreateUser(email_edit, password_edit);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error Try Again", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CreateUser(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(), "Success!! you can Login now", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(Signup.this, LoginActivity.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("SignUp", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Signup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // [START_EXCLUDE]

                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
    }
}
