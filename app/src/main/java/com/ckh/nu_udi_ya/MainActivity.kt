package com.ckh.nu_udi_ya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.LinearLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val  auth:FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logOutBtn = findViewById<LinearLayout>(R.id.logOut)
        val locationAdd = findViewById<LinearLayout>(R.id.addLocate)

        logOutBtn.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        locationAdd.setOnClickListener {
            startActivity(Intent(this,LocationEditActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        if(auth.currentUser == null) {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}