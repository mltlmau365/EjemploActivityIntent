package com.example.curso3ver1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Locale;

public class Formulario1 extends AppCompatActivity {

    //Variables
    EditText ET_obj_nomb, ET_obj_Date,ET_obj_tel,ET_obj_mail,ET_obj_descrip;
    Calendar miCalendario = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario1);

        //Identificadores de editext
        ET_obj_nomb =findViewById(R.id.editText_Name);
        ET_obj_Date =findViewById(R.id.editTextDate);
        ET_obj_tel =findViewById(R.id.editText_Telefono);
        ET_obj_mail =findViewById(R.id.editText_Email);
        ET_obj_descrip =findViewById(R.id.editText_Descripcion);


        //Picker de Fecha
        ET_obj_Date =findViewById(R.id.editTextDate);
        ET_obj_Date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Formulario1.this, date,miCalendario.get(Calendar.YEAR),miCalendario.get(Calendar.MONTH),miCalendario.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        //Accion de boton siguiente
        Button miButton_sigui=findViewById(R.id.button_siguiente);
        miButton_sigui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent submit_intent= new Intent(Formulario1.this, FormConfirma.class);
                submit_intent.putExtra("inte_form1_name",ET_obj_nomb.getText().toString());
                submit_intent.putExtra("inte_form1_date",ET_obj_Date.getText().toString());
                submit_intent.putExtra("inte_form1_tele",ET_obj_tel.getText().toString());
                submit_intent.putExtra("inte_form1_mail",ET_obj_mail.getText().toString());
                submit_intent.putExtra("inte_form1_desc",ET_obj_descrip.getText().toString());

                startActivity(submit_intent);
            }
        });

        //validador de intent

        String miextra1=getIntent().getStringExtra("inte_FormConfir_nomb");

        if (miextra1!=null){
           ET_obj_nomb.setText(miextra1);
           ET_obj_Date.setText(getIntent().getStringExtra("inte_FormConfir_date"));
           ET_obj_tel.setText(getIntent().getStringExtra("inte_FormConfir_tele"));
           ET_obj_mail.setText(getIntent().getStringExtra("inte_FormConfir_mail"));
           ET_obj_descrip.setText(getIntent().getStringExtra("inte_FormConfir_desc"));
        }


    }

    //Picker para seleccionar fecha
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            miCalendario.set(Calendar.YEAR, year);
            miCalendario.set(Calendar.YEAR, month);
            miCalendario.set(Calendar.DAY_OF_MONTH, day);
            actualizarEdiText();
        }
    };

    //Actualiza caja de Fecha obtenido del Picker Fecha
        private void actualizarEdiText(){
            String formatoDate = "MM/dd/yy";
            SimpleDateFormat simpleDT = new SimpleDateFormat(formatoDate, Locale.US);

            ET_obj_Date.setText(simpleDT.format(miCalendario.getTime()));
        }







}