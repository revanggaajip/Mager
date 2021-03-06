package com.mager.gamer.ui.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mager.gamer.MainActivity
import com.mager.gamer.data.local.MagerSharedPref
import com.mager.gamer.databinding.ActivityMainBinding
import com.mager.gamer.databinding.ActivitySplashScreenBinding
import com.mager.gamer.ui.onBoard.OnBoardctivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler()
        handler.postDelayed({
            if (MagerSharedPref.isLoggedIn) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, OnBoardctivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 2000)

    }
}