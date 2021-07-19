package com.muzaaz.loginfirebasegridviewdetail

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegis.setOnClickListener {
            val nama = regisNama.text.toString()
            val email = regisEmail.text.toString()
            val password = regispassword.text.toString()

            if (nama.isEmpty()) {
                Toast.makeText(this,"Please Insert Name !!!", Toast.LENGTH_SHORT).show()
                regisNama.requestFocus()
            }
            if (nama.isEmpty()) {
                Toast.makeText(this,"Please Insert Email !!!", Toast.LENGTH_SHORT).show()
                regisEmail.requestFocus()
            }
            if (nama.isEmpty()) {
                Toast.makeText(this,"Please Insert Name !!!", Toast.LENGTH_SHORT).show()
                regispassword.requestFocus()
            }

            val progressDialog = ProgressDialog(this, R.style.Theme_MaterialComponents_Light_Dialog)
            progressDialog.isIndeterminate = true
            progressDialog.setMessage("Creating User . . . ")
            progressDialog.show()

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                progressDialog.hide()

                if (it.isSuccessful){
                    val userId = FirebaseAuth.getInstance().currentUser!!.uid
                    val currentUser = FirebaseDatabase.getInstance().reference.child("Users").child(userId)
                    currentUser.child("Name").setValue(nama)

                    verifyEmail()

                    val intent = Intent(this, MainActivity::class.java)
                    finish()
                    startActivity(intent)
                } else
                    Toast.makeText(this,"Authentication failed", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun verifyEmail() {
        val user = FirebaseAuth.getInstance().currentUser
        user!!.sendEmailVerification().addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this@RegisterActivity,"Verifycation Email sent to" + user.email, Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this@RegisterActivity,"Failed to sent Verifycation Emait" + user.email, Toast.LENGTH_SHORT).show()
        }
    }
}
