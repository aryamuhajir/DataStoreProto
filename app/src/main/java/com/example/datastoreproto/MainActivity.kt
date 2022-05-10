package com.example.datastoreproto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mainViewModel.data.observe(this){
            hasil.text = it.name
        }

        btnProto.setOnClickListener {
            mainViewModel.update(editText1.text.toString())
        }
    }
}