package com.example.seemovie;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seemovie.helper.LocaleHelper;

import io.paperdb.Paper;


public class inicioActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Paper.init(this);

        textView = (TextView)findViewById(R.id.textinicio);

     String language = Paper.book().read("language");
     if(language == null)
        Paper.book().write("language","en");

     updateView((String)Paper.book().read("language"));

    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        textView.setText(resources.getString(R.string.app_name));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(item.getItemId() == R.id.language_en)
        {
           Paper.book().write("language" , "en");
           updateView((String)Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_es)
        {
            Paper.book().write("language" , "es");
            updateView((String)Paper.book().read("language"));
        }
        return true;
    }

    public void recomendado(View view) {
        Intent intent = new Intent(this,RecomActivity.class);
        startActivity(intent);
    }

    public void peliculas(View view) {
        Intent intent = new Intent(this,MovieActivity.class);
        startActivity(intent);
    }


    public void funcion(View view) {
        Intent intent = new Intent(this,FuncionActivity.class);
        startActivity(intent);
    }

    public void perfil(View view) {
        Intent intent = new Intent(this,PerfilActivity.class);
        startActivity(intent);
    }

    public void historial(View view) {
        Intent intent = new Intent(this,HistorialActivity.class);
        startActivity(intent);
    }


}