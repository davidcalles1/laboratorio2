package com.example.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var id_nombre: EditText
    private lateinit var id_edad: EditText
    private lateinit var id_depar: EditText
    private lateinit var tv_resultado: TextView
    private lateinit var lv_listado: ListView
    val nombre = arrayListOf<String>()
    val edad = arrayListOf<String>()
    val departamento = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        id_nombre = findViewById(R.id.id_nombre)
        id_edad = findViewById(R.id.id_edad)
        id_depar = findViewById(R.id.id_depar)
        tv_resultado = findViewById(R.id.tv_resultado)
        lv_listado = findViewById(R.id.lv_lista)

    }


    fun save(V: View){
        nombre.add(id_nombre.text.toString())
        edad.add(id_edad.text.toString())
        departamento.add(id_depar.text.toString())

        var adaptador: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.lista, nombre)


        lv_listado?.adapter = adaptador

        lv_listado?.onItemClickListener=object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tv_resultado.setText("Los datos de ${nombre.get(p2)} la edad s ${edad.get(p2)} Y vive el el departamento de ${departamento.get(p2)}")

            }

        }


    }


}