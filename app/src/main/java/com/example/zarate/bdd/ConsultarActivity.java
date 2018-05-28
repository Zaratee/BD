package com.example.zarate.bdd;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zarate.bdd.Utilidades.Utilidades;

public class ConsultarActivity extends AppCompatActivity {

    Button volver,buscar;
    EditText idd,nombre, telefono;

    Conexion conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        conn =new Conexion(this, "bd_usuarios", null, 1);

        volver = (Button) findViewById(R.id.btn_consVolver);
        buscar = (Button) findViewById(R.id.btn_consBuscar);
        idd = (EditText) findViewById(R.id.etxt_consuId);
        nombre = (EditText) findViewById(R.id.etxt_consuNombre);
        telefono = (EditText) findViewById(R.id.etxt_consuTelefono);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ConsultarActivity.this,Principal.class);
                startActivity(back);
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_consBuscar:
                        consultar();
                        break;
                    case R.id.btn_consActualizar:
                        break;
                    case R.id.btn_consEliminar:
                        break;
                }

            }
        });
        }


    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {idd.getText().toString()};
        String[] campos={Utilidades.Campo_nombre,Utilidades.Campo_telefono};

        try{
            Cursor cursor = db.query(Utilidades.Tabla_usuario,campos,Utilidades.Campo_id+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            nombre.setText(cursor.getString(0));
            telefono.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    private void limpiar() {
        nombre.setText("");
        telefono.setText("");
    }
}
