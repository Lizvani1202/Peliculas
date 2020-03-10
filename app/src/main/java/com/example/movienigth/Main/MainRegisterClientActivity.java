package com.example.movienigth.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.movienigth.MainActivity;
import com.example.movienigth.R;

public class MainRegisterClientActivity extends AppCompatActivity {

    Button btnagregar, btncancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register_client);
        btnagregar = (Button)findViewById(R.id.btnadd);
        btncancelar = (Button)findViewById(R.id.btncancel);
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainRegisterClientActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Proceso cancelado",Toast.LENGTH_LONG).show();
            }
        });
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainRegisterClientActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Agregado con exito",Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainRegisterClientActivity.this, MainRegisterClientActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"Debe agregar o cancelar la funcion",Toast.LENGTH_LONG).show();
    }
}