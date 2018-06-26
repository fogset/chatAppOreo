package com.example.tianhao.chatapporeo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class UserListActivity : AppCompatActivity() {
    val mAuth = FirebaseAuth.getInstance()
    var userListView: ListView? = null
    var usersEmail = arrayListOf<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        setTitle("User List")

        val currentFirebaseUser = FirebaseAuth.getInstance().currentUser
        var currentEmail = currentFirebaseUser!!.email
        //Log.i("email is ", currentEmail)
        userListView = findViewById(R.id.userListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, usersEmail)
        userListView?.adapter = adapter


        FirebaseDatabase.getInstance().getReference().child("users").addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val email = p0.child("email").value as String
                if (email != currentEmail){
                    usersEmail.add(email)
                }
                //keys.add(p0.key!!)
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(p0: DatabaseError) {}
            override fun onChildMoved(p0: DataSnapshot, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot, p1: String?) {}
            override fun onChildRemoved(p0: DataSnapshot) {}

        })

        userListView?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                
            }

        }

    }
}
