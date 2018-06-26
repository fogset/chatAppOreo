package com.example.tianhao.chatapporeo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class chatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        var activeUser = intent.getStringExtra("username")
        setTitle("Chat with " + activeUser)
        Log.i("active user", activeUser)
    }
}
