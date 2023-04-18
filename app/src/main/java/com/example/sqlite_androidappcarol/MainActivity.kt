package com.example.sqlite_androidappcarol

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
   lateinit var edtname:EditText
   lateinit var edtemail:EditText
   lateinit var edtid:EditText
   lateinit var btn_save:Button
   lateinit var btn_view:Button
   lateinit var btn_delete:Button

    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      edtname = findViewById(R.id.edtname)
      edtemail = findViewById(R.id.edtemail)
      edtid = findViewById(R.id.edtid)
      btn_save = findViewById(R.id.btn_save)
       btn_delete = findViewById(R.id.btn_delete)
      btn_view = findViewById(R.id.btn_view)

        //CREATING OUR DATABASE
        db=openOrCreateDatabase("Carol", Context.MODE_PRIVATE, null)
        //creating our tables
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")

        btn_save.setOnClickListener {
         var jina_edt = edtname.text.toString().trim()
         var  arafa_edt = edtemail.text.toString().trim()
         var kitambulisho_edt = edtid.text.toString().trim()

         //validate your edit texts
         if (jina_edt.isEmpty() || arafa_edt.isEmpty() || kitambulisho_edt.isEmpty()){
             Toast.makeText(this, "Cannot Submit an Empty Field", Toast.LENGTH_SHORT).show()
         }
            else{
                //insert data
                db.execSQL("INSERT INTO users VALUES('\"+jina_edt+\"', '\"+arafa_edt+\"', '\"+kitambulisho_edt+\"')")

             Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
         }
        }



    }

}