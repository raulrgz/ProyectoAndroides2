package com.example.proyectoandroides2

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.proyectoandroides2.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(), FragmentCommunicator {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun manageLoader(isVisible: Boolean) {
        if(isVisible) {
            binding.loaderView.visibility = View.VISIBLE
        }else{
            binding.loaderView.visibility = View.GONE
        }
    }

}