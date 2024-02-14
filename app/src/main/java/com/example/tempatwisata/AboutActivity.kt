package com.example.tempatwisata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tempatwisata.databinding.ActivityMainBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_about)
        supportActionBar?.title = "About Me"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    @Suppress("DEPRECATION")
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}