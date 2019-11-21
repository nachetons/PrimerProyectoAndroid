package com.tema3.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tema3.tema3ejemplo1.R;

public class SecondActivity extends AppCompatActivity {
    //Definimos las variables que vamos a usar
    private TextView textView;
    private Button btnNext;
    private Button btnDisabled;
    private TextView mostrarAnos;
    private SeekBar seekBar;
    private TextView tv1;
    private RadioButton btnSaludo;
    private RadioButton btnDespedida;
    private static int idBtn=0;
    private RadioGroup Grupo;
    private String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);


        //Definimos la relacion de las variables creadas con los campos que pusimos en el xml
        mostrarAnos = (TextView)findViewById(R.id.txtCargar);
        btnNext = (Button) findViewById(R.id.buttonGoSharing);
        btnDisabled = (Button) findViewById(R.id.buttonGoSharing2);
        tv1 = (TextView)findViewById(R.id.tv1);
        seekBar = (SeekBar)findViewById(R.id.seekbar);


        //Recogemos el dato recogido en el primer activity y lo imprimimos en pantalla
        dato = getIntent().getStringExtra("dato");
        tv1.setText("Bienvenido/a "+ dato + ". Selecciona entre estas opciones:");


        //Creamos anteriormente en el xml dos botones, con distinto color, para que al no cumplirse la funcion uno se viese y el otro no asi el usuario se de cuenta de que esta deshabilitado
        idBtn=0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnDisabled.setVisibility(View.GONE);

        //Decimos a la barra que empiece por el numero 18 y que imprima en el text view los años
        seekBar.setProgress(18);
        mostrarAnos.setText(18+" Años");


        //Creamos la funcion para que solo te deje pulsar el boton si el numero introducido esta en el rango entre 18 y 60
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser) {
                        mostrarAnos.setText(String.valueOf(progress)+" Años");
                        if(progress >= 18 && progress <=60){
                            btnNext.setEnabled(true);
                            btnNext.setVisibility(View.VISIBLE);
                            btnDisabled.setVisibility(View.GONE);



                        }else{
                            btnNext.setEnabled(false);
                            btnNext.setVisibility(View.GONE);
                            btnDisabled.setVisibility(View.VISIBLE);


                        }
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });


        //Ponemos la condicion de que los campos nose pueden quedar vacios
        btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (mostrarAnos.getText().toString().isEmpty() || mostrarAnos.getText().toString() == null) {
                    Toast.makeText(SecondActivity.this, "¡Campos vacíos!", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    Grupo = findViewById(R.id.radioGroup);
                    if (Grupo.getCheckedRadioButtonId() != 0) {
                        btnSaludo = findViewById(R.id.ButtonHola);
                        btnDespedida = findViewById(R.id.ButtonAdios);

                        if(btnSaludo.isChecked()){
                             idBtn=1;
                        }
                        if(btnDespedida.isChecked()){
                             idBtn=2;
                        }
                        if(idBtn==1 ||idBtn==2) {
                            //Recogemos los datos de los años el nombre y el saludo o la despedida
                            intent.putExtra("datoAnos", mostrarAnos.getText().toString());
                            intent.putExtra("dato2", dato);
                            intent.putExtra("seleccion", idBtn);
                            startActivity(intent);

                        }else{
                            Toast.makeText(SecondActivity.this, "¡Vayaaaa! No has seleccionado ninguna opción", Toast.LENGTH_LONG).show();

                        }
                    }else {
                        Toast.makeText(SecondActivity.this, "Campos Vacios", Toast.LENGTH_LONG).show();
                    }


                }
            }
        });
    }

    //Esto esta explicado al final del main activity
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
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                Intent intent2 = new Intent(SecondActivity.this, AboutActivity.class);
                Toast.makeText(SecondActivity.this,"¡Campos vacíos!",Toast.LENGTH_LONG).show();
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
