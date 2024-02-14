package com.example.tempatwisata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.tempatwisata.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        @Suppress("DEPRECATION")
        val dataWisata = intent.getParcelableExtra<Wisata>("DATA")

        binding.tvDetailName.text = dataWisata?.name
        binding.tvDetailDescription.text = dataWisata?.description
        binding.tvItemJenis.text = dataWisata?.jenis
        Glide.with(this)
            .load(dataWisata?.photo)
            .into(binding.ivDetailPhoto)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //optional fitur share
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val actionShare = Intent(Intent.ACTION_SEND)
                actionShare.type = "text/plain"
                actionShare.putExtra("Share", "ListTempatWisata.xtc/")
                val share = Intent.createChooser(actionShare, "File sharing via : ")
                startActivity(share)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @Suppress("DEPRECATION")
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}