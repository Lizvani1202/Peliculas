package com.example.movienigth.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movienigth.MainActivity;
import com.example.movienigth.Model.ModelClient;
import com.example.movienigth.R;

import java.util.Calendar;

public class MainEditClientActivity extends AppCompatActivity {

    Button btneditar, btncancelar,btnmapa,btnfecha,btnbuscar,btnnuevo;
    EditText etnombre,etapellido,etci,etcelular,etemail,etdireccion,etlatitud,etlongitud,etbuscar;
    private EditText etdate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edit_client);

        etnombre    = (EditText)findViewById(R.id.eteditfirstname);
        etapellido  = (EditText)findViewById(R.id.eteditlastname);
        etci        = (EditText)findViewById(R.id.eteditci);
        etcelular   = (EditText)findViewById(R.id.eteditellphone);
        etemail     = (EditText)findViewById(R.id.eteditemail);
        etdireccion = (EditText)findViewById(R.id.eteditaddress);
        etlatitud   = (EditText)findViewById(R.id.eteditlatitude);
        etlongitud  = (EditText)findViewById(R.id.eteditlongitude);
        etdate      = (EditText) findViewById(R.id.etfecha);
        btnfecha    = (Button)findViewById(R.id.btneditdate);
        btneditar   = (Button)findViewById(R.id.btnedit);
        btncancelar = (Button)findViewById(R.id.btncancel);
        etbuscar    = (EditText)findViewById(R.id.etbsci);
        btnbuscar   = (Button)findViewById(R.id.btneditbuscar);
        btnnuevo    = (Button)findViewById(R.id.btneditnuevo);
        //btnmapa     = (Button)findViewById(R.id.btneditmaps);

        btnfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year  = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day   = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainEditClientActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        onDateSetListener,
                        year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                Log.d("LVVD","Date:"+year+"/"+month+"/"+dayOfMonth);
                String date = month+"/"+dayOfMonth+"/"+year;
                etdate.setText(date);
            }
        };
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ci = etbuscar.getText().toString().trim();

                if(TextUtils.isEmpty(ci)){

                    Toast.makeText(getApplicationContext(),"Error, ingrese ci del cliente",Toast.LENGTH_LONG).show();

                }else{

                    ModelClient client = MainActivity.adminDataBase.serchClient(Integer.parseInt(ci));


                    if(client == null){

                        Toast.makeText(getApplicationContext(),"Error, cliente inexistente",Toast.LENGTH_LONG).show();

                    }else{
                        etbuscar.setEnabled(false);
                        etnombre.setText(client.getFirst_name());
                        etapellido.setText(client.getLast_name());
                        etci.setText(client.getCi());
//                        etcelular.setText(client.getCellphone());
                        etemail.setText(client.getEmail());
                        etdireccion.setText(client.getAddress());
                        etlatitud.setText(client.getLatitude());
                        etlongitud.setText(client.getLongitude());
                        etdate.setText(client.getBirthdate());

                    }
                }
            }
        });

        btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etbuscar.setEnabled(true);
                etnombre.setText(null);
                etapellido.setText(null);
                etci.setText(null);
                etcelular.setText(null);
                etemail.setText(null);
                etdireccion.setText(null);
                etlatitud.setText(null);
                etlongitud.setText(null);
                etdate.setText(null);
                etbuscar.requestFocus();

            }
        });
        etbuscar.requestFocus();

        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id       = etbuscar.getText().toString();
                String nombre   = etnombre.getText().toString();
                String apellido = etapellido.getText().toString().trim();
                String cedula   = etci.getText().toString().trim();
                String celular  = etcelular.getText().toString().trim();
                String email    = etemail.getText().toString().trim();
                String direccion= etdireccion.getText().toString().trim();
                String latitud  = etlatitud.getText().toString().trim();
                String longitud = etlongitud.getText().toString().trim();
                String fecha    = etdate.getText().toString().trim();

                if(TextUtils.isEmpty(id) || TextUtils.isEmpty(nombre) || TextUtils.isEmpty(apellido) || TextUtils.isEmpty(cedula) || TextUtils.isEmpty(celular) || TextUtils.isEmpty(email) || TextUtils.isEmpty(direccion) || TextUtils.isEmpty(latitud) || TextUtils.isEmpty(longitud) || TextUtils.isEmpty(fecha)){

                    Toast.makeText(getApplicationContext(),"Los campos no deben estar vacios",Toast.LENGTH_LONG).show();

                }else{

                    ModelClient client =new ModelClient(Integer.parseInt(id),nombre,apellido,cedula,Integer.parseInt(celular),email,direccion,latitud,longitud,fecha,1);

                    ModelClient modelClient =MainActivity.adminDataBase.serchIdName(Integer.parseInt(id),nombre);

                    if(modelClient == null){
                        MainActivity.adminDataBase.updateCLient(client);
                        Toast.makeText(getApplicationContext(), "Registro grabado exotosamente", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Error existe nombre, no se grabo", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });



    }
}
