package com.tema3.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tema3.tema3ejemplo1.R;


public class ThirdActivity extends AppCompatActivity {
    //Definimos las variables que vamos a usar
    private EditText editTextPhone;
    private EditText editTextWeb;
    private ImageButton imgBtnWeb;
    private ImageButton imgBtnPhone;
    private ImageButton imgBtnCamera;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private TextView tv2;
    private Button Exit;
    private Button Exitp;


    //Definimos la relacion de las variables creadas con los campos que pusimos en el xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv2 = (TextView)findViewById(R.id.acerca);
        btn2 = (Button) findViewById(R.id.BotonMostrar);
        btn3 = (Button) findViewById(R.id.BotonOcultar);
        btn4 = (Button) findViewById(R.id.BotonShare);
        Exit = (Button) findViewById(R.id.Exit);
        Exitp = (Button) findViewById(R.id.Exitp);

        //Estos 3 botones los ocultamos en un inicio y los habilitaremos posteriormento pulsando en el btn2
        Exitp.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);



        //Creamos en los 2 exit la funcion de cerrar la aplicacion
        Exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            }
            });

        Exitp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        //Creamos la funcion de compartir pulsando el boton btn4
        btn4.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, tv2.getText().toString());
                //intent.putExtra("tv2", );
                startActivity(Intent.createChooser(intent,"Selecciona una acción:"));

            }

        });


        //Esta funcion oculta el boton mostrar y salir grande y deja visible los demas
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn2.getVisibility() == View.VISIBLE)

                {
                    btn2.setVisibility(View.GONE);
                    btn3.setVisibility(View.VISIBLE);
                    btn4.setVisibility(View.VISIBLE);
                    Exitp.setVisibility(View.VISIBLE);
                    Exit.setVisibility(View.GONE);
                    String dato2 = getIntent().getStringExtra("dato2");
                    String datoAnos = getIntent().getStringExtra("datoAnos");
                    String Hi = getIntent().getStringExtra("Hi");
                    String Bye = getIntent().getStringExtra("Bye");
                    int seleccion = getIntent().getIntExtra("seleccion",0);
                    if(seleccion == 1){
                        tv2.setText( "Bienvenido " + dato2 +", "+ " que disfrutes de tus " + datoAnos + " y que cumplas muchos mas!! 🎉🎉🎉");

                    }else{
                        tv2.setText("Hasta luego " + dato2 + ", " + " Disfruta de tus " + datoAnos + " nos vemos 😜");
                    }
                }


            }

        });


        //Esta funcion solo se puede ejecuta si la otra se ejecuto antes y hace justo lo opuesto
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn3.getVisibility() == View.VISIBLE)
                {

                    btn2.setVisibility(View.VISIBLE);
                    btn3.setVisibility(View.GONE);
                    Exitp.setVisibility(View.GONE);
                    btn4.setVisibility(View.GONE);
                    Exit.setVisibility(View.VISIBLE);
                    tv2 = (TextView)findViewById(R.id.acerca);
                    String dato2 = getIntent().getStringExtra("dato2");
                    String datoAnos = getIntent().getStringExtra("datoAnos");
                    tv2.setText("");
                }

            }
        });
    }

    //Esta explicado al final del MainActivity
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.home:
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                Intent intent2 = new Intent(ThirdActivity.this, AboutActivity.class);
                Toast.makeText(ThirdActivity.this,"¡Campos vacíos!",Toast.LENGTH_LONG).show();
                startActivity(intent2);
                break;
            case R.id.salir:
                intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
        return true;
    }*/
}






