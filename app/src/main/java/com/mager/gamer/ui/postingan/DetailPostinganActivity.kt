package com.mager.gamer.ui.postingan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mager.gamer.MainActivity
import com.mager.gamer.databinding.ActivityDetailPostinganBinding

class DetailPostinganActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPostinganBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPostinganBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgLeft.setOnClickListener {
            startActivity(
                Intent(this@DetailPostinganActivity, MainActivity::class.java)
            )
        }
    }
}