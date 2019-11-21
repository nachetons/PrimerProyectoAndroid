package com.tema3.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tema3.tema3ejemplo1.R;

public class AboutActivity extends AppCompatActivity{
    //Definimos las variables que vamos a usar
    private TextView acerca;
    private TextView acerca2;
    private Button buttonfacebook;
    private Button buttontwitter;
    private Button buttonwhatsapp;
    private Button buttoninstagram;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Definimos la relacion de las variables creadas con los campos que pusimos en el xml
        acerca = (TextView)findViewById(R.id.acerca);
        acerca2 = (TextView)findViewById(R.id.acerca2);
        buttonfacebook = (Button)findViewById(R.id.buttonFacebook);
        buttontwitter = (Button)findViewById(R.id.buttonTwitter);
        buttonwhatsapp = (Button)findViewById(R.id.buttonWhatsapp);
        buttoninstagram = (Button)findViewById(R.id.buttonInstagram);

        //Imprimimos mensaje en pantalla
        acerca.setText("Acerca de");
        acerca2.setText("Creado por Nacho Pinto y Miguel Angel Sánchez");



    }

    //Creamos los metodos para asociar cada web activity con su clase
    public void web1 (View view){
    Intent intent = new Intent(AboutActivity.this, Web1Activity.class);
    startActivity(intent);
    }

    public void web2(View view) {
        Intent intent = new Intent(AboutActivity.this, Web2Activity.class);
        startActivity(intent);
    }

    public void web3(View view) {
        Intent intent = new Intent(AboutActivity.this, Web3Activity.class);
        startActivity(intent);
    }

    public void web4(View view) {
        Intent intent = new Intent(AboutActivity.this, Web4Activity.class);
        startActivity(intent);
    }
}


