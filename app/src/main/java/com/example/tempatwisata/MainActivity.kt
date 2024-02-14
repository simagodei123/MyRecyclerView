package com.example.tempatwisata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tempatwisata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var rvWisata: RecyclerView
    private val list = ArrayList<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvWisata = binding.rvWisata
        rvWisata.setHasFixedSize(true)

        list.addAll(getListWisata())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvWisata.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvWisata.layoutManager = GridLayoutManager(this,2)
            }
            R.id.about_page -> {
                val aboutPage = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutPage)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListWisata(): ArrayList<Wisata> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataJenis = resources.getStringArray(R.array.data_jenis)
        val listWisatas = ArrayList<Wisata>()
        for (i in dataName.indices) {
            val wisata = Wisata(dataName[i], dataDescription[i], dataPhoto[i], dataJenis[i])
            listWisatas.add(wisata)
        }
        return listWisatas
    }

    private fun showRecyclerList() {
        rvWisata.layoutManager = LinearLayoutManager(this)
        val listWisataAdapter = ListWisataAdapter(list)
        rvWisata.adapter = listWisataAdapter

        listWisataAdapter.setOnItemClickCallback(object : ListWisataAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Wisata) {
                showSelectedWisata(data)
            }
        })
    }

    private fun showSelectedWisata(wisata: Wisata) {
        val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
        intentDetail.putExtra("DATA", wisata)
        startActivity(intentDetail)
    }
}