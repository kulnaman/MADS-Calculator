package com.example.mads_calculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.mads_calculator.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance();
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onStart() {
        super.onStart()
        // Choose authentication provider
        val currentUser = auth.currentUser
        binding.login.isEnabled = true

        binding.login.setOnClickListener {
            if (!TextUtils.isEmpty(binding.username.text) && !TextUtils.isEmpty(binding.password.text)) {
                binding.loading.visibility = View.VISIBLE
                auth.signInWithEmailAndPassword(
                    binding.username.text.toString(),
                    binding.password.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        binding.loading.visibility = View.GONE
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            Toast.makeText(
                                baseContext, "Authentication Successful.",
                                Toast.LENGTH_SHORT
                            ).show()
                            val i = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(i)
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                            // ...
                        }

                    }
            } else {
                Toast.makeText(
                    baseContext, "Enter Valid Credential",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

