package com.example.proyectoandroides2.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.proyectoandroides2.databinding.ActivityMain2Binding
import com.example.proyectoandroides2.utils.FragmentCommunicator

class AuthActivity : AppCompatActivity(), FragmentCommunicator {

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