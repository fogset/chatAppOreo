package com.example.tianhao.chatapporeo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.ListAdapter

class UserListActivity : AppCompatActivity() {
    var userListView: ListView? = null
    var emails = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        userListView = findViewById(R.id.userListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,emails)
       //userListView.adapter = adapter as ListAdapter?

    }
}
