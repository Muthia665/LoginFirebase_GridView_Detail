package com.muzaaz.loginfirebasegridviewdetail

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefManager = SharedPrefManager()
        SharedPrefManager.sp = getSharedPreferences(SharedPrefManager.SP_APP, Context.MODE_PRIVATE)
        SharedPrefManager.spEditor = SharedPrefManager.sp.edit()

        if (sharedPrefManager.getSPSudahLogin()!!) {
            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            startActivity(intent)
            finish()
        }

        textregis.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {
            val email = loginEmail.text.toString()
            val password = loginpassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this,"Please Insert Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email == "muthia09876@gmail.com" && password == "muthia") {
                Toast.makeText(this,"Login Succes", Toast.LENGTH_SHORT).show()
            }
            val progressDialog = ProgressDialog(this, R.style.Theme_MaterialComponents_Light_Dialog)
            progressDialog.isIndeterminate = true
            progressDialog.setMessage("Login . . .")
            progressDialog.show()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
                progressDialog.hide()
                loginEmail.setText("")
                loginEmail.requestFocus()
                loginpassword.setText("")

                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true)

                if (!it.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else
                    Toast.makeText(this,"Successfully Login", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
                finish()
            }
                .addOnCompleteListener {
                    Toast.makeText(this,"Email or Password Incorect", Toast.LENGTH_SHORT).show()
                }

        }

    }
}
