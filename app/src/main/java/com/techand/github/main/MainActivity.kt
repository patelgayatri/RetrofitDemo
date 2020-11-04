package com.techand.github.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.techand.github.R
import com.techand.github.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btnSearch.setOnClickListener {
            if (binding.etProfileName.text.isNotBlank()) {
                binding.imageCard.visibility = View.VISIBLE
                binding.infoCard.visibility = View.VISIBLE
                viewModel.getUserData(binding.etProfileName.text.toString())
                Log.d("TAG_TAG", "click")
            }
        }
    }
}
