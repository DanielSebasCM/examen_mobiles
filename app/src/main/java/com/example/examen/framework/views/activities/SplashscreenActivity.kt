package com.example.examen.framework.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examen.databinding.ActivitySplashScreenBinding
import com.example.examen.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstances: Bundle?) {
        super.onCreate(savedInstances)
        setContentView(ActivitySplashScreenBinding.inflate(layoutInflater).root)
        CoroutineScope(Dispatchers.Main).launch {
            delay(Constants.SPLASHSCREEN_DURATION)
            passViewGoToMain()
        }
    }
    private fun passViewGoToMain() {
        var intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        finish()
    }
}