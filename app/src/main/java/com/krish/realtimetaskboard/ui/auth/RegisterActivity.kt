package com.krish.realtimetaskboard.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.krish.realtimetaskboard.databinding.ActivityRegisterBinding
import com.krish.realtimetaskboard.ui.MainActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnRegister.setOnClickListener {
            val name = binding.etFullName.text?.toString()?.trim() ?: ""
            if (name.isEmpty()) {
                binding.etFullName.error = "Enter name"
                return@setOnClickListener
            }

            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        binding.tvGoToLogin.setOnClickListener {
            finish()
        }
    }
}
