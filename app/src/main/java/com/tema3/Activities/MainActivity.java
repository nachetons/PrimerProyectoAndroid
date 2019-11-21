package com.tema3.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tema3.tema3ejemplo1.R;

public class MainActivity extends AppCompatActivity{
    //Definimos las variables que vamos a usar
    private Button btn;
    private Button btn2;
    private EditText Nombre1;

    private final String GREETER = "Hola desde otro sitio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Definimos la relacion de las variables creadas con los campos que pusimos en el xml
        Nombre1 = (EditText)findViewById(R.id.Nombre1);
        btn = (Button)findViewById(R.id.buttonMain);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_foreground);


        //Creamos la funcion de apretar el boton en este caso dijimos que no te deje pulsarlo si el campo edittext se deja vacio
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if (Nombre1.getText().toString().isEmpty()||Nombre1.getText().toString()==null){
                    Toast.makeText(MainActivity.this,"¡Campos vacíos!",Toast.LENGTH_LONG).show();

                }else {
                    //Mandamos los datos introducidos a la segunda activity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("dato", Nombre1.getText().toString());
                    startActivity(intent);
                }
            }


        });


    }
    //Creamos unos botones que desplieguen una serie de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }


    //Damos la funcion a cada uno de los botones
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            //En esta opcion le indicamos que nos envie a la pestaña principal
            case R.id.home:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            //En esta opcion indicamos que nos envie a otra activity
            case R.id.about:
                Intent intent2 = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent2);
                break;
            //En esta opcion le indicamos que el programa se cierre que en verdad lo minimiza xD
            case R.id.salir:
                intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
        return true;
    }
}

