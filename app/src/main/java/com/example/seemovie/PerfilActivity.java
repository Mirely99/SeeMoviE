package com.example.seemovie;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PerfilActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);






        
    }

    public void cerrar(View view) {
        Intent intent = new Intent(PerfilActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void atrase(View view) {
        Intent intent  = new Intent(this,inicioActivity.class);
        startActivity(intent);
    }
}