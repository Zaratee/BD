package com.example.zarate.bdd.Utilidades;

public class Utilidades {

    public static final String Tabla_usuario = "usuario";
    public static final String Campo_id = "id";
    public static final String Campo_nombre = "nombre";
    public static final String Campo_telefono = "telefono";

    public static final String CrearTablaUsuario = "CREATE TABLE "+Tabla_usuario+"("+Campo_id+" INTEGER, "+Campo_nombre+" TEXT, "+Campo_telefono+" TEXT)";

}
