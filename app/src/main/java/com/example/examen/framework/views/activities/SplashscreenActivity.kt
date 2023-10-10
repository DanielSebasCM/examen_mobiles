package com.example.examen.framework.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class SplashscreenActivity : AppCompatActivity() {

    private fun passViewGoToMain() {
        var intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        finish()
    }
}