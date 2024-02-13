package com.example.consumo.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

data class ManagerBd(val context: Context) {
    lateinit var bd: SQLiteDatabase

    val bdHelper = BdHelper(context)// llamando a mi conexion

    // metodo para abrir la base de datos en modo escritura
    fun openBdWr() {
        bd = bdHelper.writableDatabase
    }

    // metodo para abrir la base de datos en modo lectura
    fun openBdRd() {
        bd = bdHelper.readableDatabase
    }

    fun insertData(cod: Int, nombre: String, codedep: Int): Long {
        openBdWr()// abrir bd en modo escritura
        //Creo contenedor de valores para insertar data
        val contenedor = ContentValues()
        contenedor.put("cod", cod)
        contenedor.put("nombre", nombre)
        contenedor.put("codedep", codedep)
        //llamo metodo insert

        val resul = bd.insert("ciudad", null, contenedor)

        return resul

    }

    fun insertData2(
        codData: Int,
        codNombre: String,
        codTelefono: Int,
        codDireccion: String,
        codCiudad: String
    ): Long {
        openBdWr()// abrir bd en modo escritura
        //Creo contenedor de valores para insertar data
        val contenedor = ContentValues()
        contenedor.put("cod", codData)
        contenedor.put("nombre", codNombre)
        contenedor.put("telefono", codTelefono)
        contenedor.put("direccion", codDireccion)
        contenedor.put("ciudad", codCiudad)
        //llamo metodo insert

        val resul = bd.insert("Data", null, contenedor)

        return resul

    }

    fun insertData3(nombre: String, latitude: Double, longitude: Double): Long {
        openBdWr()// abrir bd en modo escritura
        //Creo contenedor de valores para insertar data
        val contenedor = ContentValues()
        contenedor.put("nombre", nombre)
        contenedor.put("latitude", latitude)
        contenedor.put("longitude", longitude)
        //llamo metodo insert

        val resul = bd.insert("places", null, contenedor)

        return resul

    }


    fun getData(): ArrayList<Ciudad> {
        openBdRd()
        val ciudadList = ArrayList<Ciudad>()
        val cursor: Cursor? = bd.rawQuery(Constantes.obtener, null)

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val idCiudadIndex = cursor.getColumnIndex("cod")
                val nombreCiudadIndex = cursor.getColumnIndex("nombre")
                val codedepCiudadIndex = cursor.getColumnIndex("codedep")

                val idCiudad: Int = cursor.getInt(idCiudadIndex)
                val nombreCiudad: String = cursor.getString(nombreCiudadIndex)
                val codedepCiudad: Int = cursor.getInt(codedepCiudadIndex)

                val ciudad = Ciudad(idCiudad, nombreCiudad, codedepCiudad)
                ciudadList.add(ciudad)

            } while (cursor.moveToNext())
        }

        cursor?.close() // Cerrar el cursor después de su uso

        return ciudadList
    }
}


