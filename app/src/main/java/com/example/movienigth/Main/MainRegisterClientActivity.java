package com.example.movienigth.Main;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import com.example.movienigth.MainActivity;
import com.example.movienigth.Model.ModelClient;
import com.example.movienigth.R;
import java.util.Calendar;

public class MainRegisterClientActivity extends AppCompatActivity {

    Button btnagregar, btncancelar,btnmapa,btnfecha;
    EditText etid,etnombre,etapellido,etci,etcelular,etemail,etdireccion,etlatitud,etlongitud;
    private EditText etdate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register_client);

        etid        = (EditText)findViewById(R.id.etaddid);
        etnombre    = (EditText)findViewById(R.id.etaddfirstname);
        etapellido  = (EditText)findViewById(R.id.etaddlastname);
        etci        = (EditText)findViewById(R.id.etaddci);
        etcelular   = (EditText)findViewById(R.id.etaddcellphone);
        etemail     = (EditText)findViewById(R.id.etaddemail);
        etdireccion = (EditText)findViewById(R.id.etaddaddress);
        etlatitud   = (EditText)findViewById(R.id.etaddlatitude);
        etlongitud  = (EditText)findViewById(R.id.etaddlongitude);
        etdate      = (EditText) findViewById(R.id.etfecha);
        btnfecha    = (Button)findViewById(R.id.btndate);
        btnagregar  = (Button)findViewById(R.id.btnadd);
        btncancelar = (Button)findViewById(R.id.btncancel);
        //btnmapa     = (Button)findViewById(R.id.btnaddmaps);

        btnfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year  = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day   = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainRegisterClientActivity.this,
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
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id       = etid.getText().toString();
                String nombre   = etnombre.getText().toString();
                String apellido = etapellido.getText().toString();
                String cedula   = etci.getText().toString();
                String celular  = etcelular.getText().toString();
                String email    = etemail.getText().toString();
                String direccion= etdireccion.getText().toString();
                String latitud  = etlatitud.getText().toString();
                String longitud = etlongitud.getText().toString();
                String fecha    = etdate.getText().toString();

                if(TextUtils.isEmpty(id) || TextUtils.isEmpty(nombre) || TextUtils.isEmpty(apellido) || TextUtils.isEmpty(cedula) || TextUtils.isEmpty(celular) || TextUtils.isEmpty(email) || TextUtils.isEmpty(direccion) || TextUtils.isEmpty(latitud) || TextUtils.isEmpty(longitud) || TextUtils.isEmpty(fecha)){

                    Toast.makeText(getApplicationContext(),"NO DEBEN HABER CAMPOS VACIOS",Toast.LENGTH_LONG).show();


                }else{

                    ModelClient client =new ModelClient(Integer.parseInt(id),nombre,apellido,cedula,Integer.parseInt(celular),email,direccion,latitud,longitud,fecha,1);

                    int i = MainActivity.adminDataBase.addClient(client);

                    if(i>0){
                        Toast.makeText(getApplicationContext(),"Cliente añadido",Toast.LENGTH_LONG).show();
                        InputMethodManager imm1 = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
                        imm1.hideSoftInputFromWindow(v.getWindowToken(), 0);
                        etid.setText("");
                        etnombre.setText("");
                        etapellido.setText("");
                        etci.setText("");
                        etcelular.setText("");
                        etemail.setText("");
                        etdireccion.setText("");
                        etlatitud.setText("");
                        etlongitud.setText("");
                        etdate.setText("");
                        Intent intent = new Intent(MainRegisterClientActivity.this,MainActivity.class);
                        startActivity(intent);


                    }else{
                        Toast.makeText(getApplicationContext(),"PRODUCTO NO AÑADIDO",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }



    @Override
    public void onBackPressed() {

        Intent intent = new Intent(MainRegisterClientActivity.this, MainActivity.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(),"Debe agregar o cancelar la funcion",Toast.LENGTH_LONG).show();
    }
}
