package com.example.zarate.bdd;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zarate.bdd.Utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {

    EditText campoId, campoNombre, campoTelefono;
    Button enviar,volver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoId = (EditText) findViewById(R.id.etxt_id);
        campoNombre = (EditText) findViewById(R.id.etxt_nombre);
        campoTelefono = (EditText) findViewById(R.id.etxt_telefono);
        enviar = (Button) findViewById(R.id.btn_cargarusuario);
        volver = (Button) findViewById(R.id.btn_volver1);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(MainActivity.this, Principal.class);
                startActivity(volver);
            }
        });
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               registrarUsuarios();
               //registrarUsuariosSql();
            }
        });
    }

    private void registrarUsuariosSql() {
        Conexion conn = new Conexion(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        // INSERT INTO usuario (id,nombre,telefono) values (123,'Jose','122344444')
        String insert ="INSERT INTO "+Utilidades.Tabla_usuario+" ( "+Utilidades.Campo_id+","+Utilidades.Campo_nombre+","+Utilidades.Campo_telefono+
                " ) values(" +campoId.getText().toString()+",'"+campoNombre.getText().toString()+"','"+campoTelefono.getText()+"')" ;
        db.execSQL(insert);
        db.close();
    }

    private void registrarUsuarios() {
        Conexion conn = new Conexion(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Utilidades.Campo_id,campoId.getText().toString());
        values.put(Utilidades.Campo_nombre,campoNombre.getText().toString());
        values.put(Utilidades.Campo_telefono,campoTelefono.getText().toString());

        Long idResultante = db.insert(Utilidades.Tabla_usuario,Utilidades.Campo_id,values);
        Toast.makeText(getApplicationContext(), "ID Registro: "+idResultante ,Toast.LENGTH_SHORT).show();
        db.close();
    }
}
