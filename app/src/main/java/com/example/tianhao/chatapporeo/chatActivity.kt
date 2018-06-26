package com.example.tianhao.chatapporeo

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import android.text.style.ForegroundColorSpan
import android.text.SpannableString



class chatActivity : AppCompatActivity() {
    lateinit var chatMessage: EditText
    var messages= arrayListOf<String>()
    var messageListView: ListView? = null
    var chatMessageString: String = ""
    val currentFirebaseUser = FirebaseAuth.getInstance().currentUser



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        var activeUser = intent.getStringExtra("username")
        setTitle("Chat with " + activeUser)



        chatMessage = findViewById(R.id.chatEditText) as EditText
        messageListView = findViewById(R.id.messageListView)
        messages.add("hello")
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messages)
        messageListView?.adapter = adapter




    }
    fun sendChat(view: View){
        

        var currentEmail = currentFirebaseUser!!.email.toString()

        messages.add(currentEmail+  " said: "+ chatMessage.text.toString())
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messages)
        messageListView?.adapter = adapter
        chatMessage.text.clear()
    }

}
