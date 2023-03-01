package com.footinit.baseavd.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.footinit.baseavd.databinding.ActivityMainBinding
import com.footinit.baseavd.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: MainListAdapter = MainListAdapter()

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initViews()

        initObservers()
    }

    private fun initViews() {
        val layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvAvd.layoutManager = layoutManager
        binding.rvAvd.itemAnimator = DefaultItemAnimator()
        binding.rvAvd.adapter = adapter
    }

    private fun initObservers() {
        mainViewModel.getAvdList().observe(this) {
            adapter.addItems(it)
        }
    }
}