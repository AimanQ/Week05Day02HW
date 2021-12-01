package com.example.week05day02hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var constraintLayout:ConstraintLayout?= null
    private var buttonNull:Button?= null
    private var buttonOut:Button?= null
    private var buttonToast:Button?= null
    private var buttonSnackbar:Button?= null

    private var num:Int?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
        checkNull()
        checkOutOfBounds()
        showToast()
        showSnackbar()
    }
    private fun connectViews(){
        constraintLayout = findViewById(R.id.root)
        buttonNull = findViewById(R.id.btnNull)
        buttonOut = findViewById(R.id.btnOut)
        buttonToast = findViewById(R.id.btnToast)
        buttonSnackbar = findViewById(R.id.btnSnack)
    }
    private fun checkNull(){
        buttonNull?.setOnClickListener {
            try {
                val sum = num!! + 10
            }catch (e:NullPointerException){
                Toast.makeText(this,"num can not be null",Toast.LENGTH_SHORT).show()
            }

        }
    }
    private fun checkOutOfBounds(){
        buttonOut?.setOnClickListener {
            val arr:ArrayList<String> = ArrayList()
            arr.add("Ahmad") //index = 0
            arr.add("Khalid")// index = 1
            arr.add("Sarah") // index = 2

            try {
                val name = arr[3]
            }catch (e:IndexOutOfBoundsException){
                Toast.makeText(this,"this element does not exist",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun showToast(){
        buttonToast?.setOnClickListener {
            Toast.makeText(this,"This is sample toast",Toast.LENGTH_SHORT).show()
        }
    }
    private fun showSnackbar(){
        buttonSnackbar?.setOnClickListener {
            Snackbar.make(constraintLayout!!,"This is sample snackbar",Snackbar.LENGTH_SHORT).show()
        }
    }
}