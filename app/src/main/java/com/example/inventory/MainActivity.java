package com.example.inventory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private ProgressDialog processDialog;
    private EditText password;
    private EditText email;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = (Button) findViewById(R.id.Login);

        TextView signup = findViewById(R.id.signup);
        TextView forgotPassword = findViewById(R.id.forgotPassword);

        email = (EditText) findViewById(R.id.emailSignIn);
        password = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        auth = FirebaseAuth.getInstance();
        processDialog = new ProgressDialog(this);


        //Login button clicked
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(email.getText().toString(), password.getText().toString());
            }

        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        //Hide ActionBar from any particular activity using Java code
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    //validate

    public void validate(String userEmail, String userPassword){

        processDialog.setMessage("................Please Wait.............");
        processDialog.show();

        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    processDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                }
                else{
                    Toast.makeText(MainActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
                    processDialog.dismiss();

                }
            }
        });
    }
}