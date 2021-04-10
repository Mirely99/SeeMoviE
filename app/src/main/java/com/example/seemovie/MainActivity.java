package com.example.seemovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = (EditText) findViewById(R.id.loginusername);
        passwordEditText = (EditText) findViewById(R.id.loginpassword);

        firebaseAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {


                    if(!user.isEmailVerified()){
                        Toast.makeText(MainActivity.this,"Correo no verificado" , Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Navegar en la actividad del chat", Toast.LENGTH_LONG).show();

                    }
                }
            }
        };
    }




    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener !=null)
            firebaseAuth.removeAuthStateListener(authStateListener);
    }

    public void login(View view) {

        Intent intent = new Intent(this,inicioActivity.class);
        startActivity(intent);

         String username = usernameEditText.getText().toString();
         String password = passwordEditText.getText().toString();

         firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if (!task.isSuccessful()){
                     Toast.makeText(MainActivity.this,"Hubo un error" , Toast.LENGTH_LONG).show();
                 }
             }
         });

    }

    public void signup(View view) {
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
}