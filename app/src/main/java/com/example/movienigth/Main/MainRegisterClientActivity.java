package com.example.movienigth.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movienigth.MainActivity;
import com.example.movienigth.R;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.movienigth.MainActivity;
import com.example.movienigth.R;

import java.util.Calendar;

public class MainRegisterClientActivity extends AppCompatActivity {

    Button btnagregar, btncancelar,btnmapa,btnfecha;
    private TextView tvdate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register_client);
        tvdate = (TextView)findViewById(R.id.tvfecha);
        btnfecha = (Button)findViewById(R.id.btndate);
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
                tvdate.setText(date);
            }
        };

    }



    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainRegisterClientActivity.this, MainRegisterClientActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"Debe agregar o cancelar la funcion",Toast.LENGTH_LONG).show();
    }
}
