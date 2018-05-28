package com.example.zarate.bdd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Principal extends AppCompatActivity {
    Button btningresar,btnconsultar,btneliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btningresar = (Button) findViewById(R.id.btn_ingresar);
        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actingresar = new Intent(Principal.this,MainActivity.class);
                startActivity(actingresar);
            }
        });

        btnconsultar = (Button) findViewById(R.id.btn_consultar);
        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actconsult = new Intent(Principal.this,ConsultarActivity.class);
                startActivity(actconsult);
            }
        });

    }
}
