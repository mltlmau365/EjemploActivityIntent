package com.example.curso3ver1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FormConfirma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_confirma);

        //Obteniendo clave del formulario1
        Bundle miextra2=getIntent().getExtras();
        final String stri_FormConfir_nomb= miextra2.getString("inte_form1_name");
        final String stri_FormConfir_date= miextra2.getString("inte_form1_date");
        final String stri_FormConfir_tele= miextra2.getString("inte_form1_tele");
        final String stri_FormConfir_mail= miextra2.getString("inte_form1_mail");
        final String stri_FormConfir_desc= miextra2.getString("inte_form1_desc");

        TextView ET2_obj_nomb= findViewById(R.id.textView_nombre);
        TextView ET2_obj_data= findViewById(R.id.textView_fec_nac);
        TextView ET2_obj_tele= findViewById(R.id.textView_tel);
        TextView ET2_obj_mail= findViewById(R.id.textView_mail);
        TextView ET2_obj_desc= findViewById(R.id.textView_descrip);

        ET2_obj_nomb.setText(stri_FormConfir_nomb);
        ET2_obj_data.setText(stri_FormConfir_date);
        ET2_obj_tele.setText(stri_FormConfir_tele);
        ET2_obj_mail.setText(stri_FormConfir_mail);
        ET2_obj_desc.setText(stri_FormConfir_desc);

        //Accion Boton Editar
        Button miboton_editar=findViewById(R.id.button_editar);
        miboton_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit_edit=new Intent(FormConfirma.this,Formulario1.class);

                submit_edit.putExtra("inte_FormConfir_nomb",stri_FormConfir_nomb);
                submit_edit.putExtra("inte_FormConfir_date",stri_FormConfir_date);
                submit_edit.putExtra("inte_FormConfir_tele",stri_FormConfir_tele);
                submit_edit.putExtra("inte_FormConfir_mail",stri_FormConfir_mail);
                submit_edit.putExtra("inte_FormConfir_desc",stri_FormConfir_desc);


                startActivity(submit_edit);
            }
        });

    }



}