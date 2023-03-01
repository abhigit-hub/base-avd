package com.footinit.baseavd.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.footinit.baseavd.R
import com.footinit.baseavd.databinding.ActivityMainBinding
import com.footinit.baseavd.utils.ViewUtils
import com.footinit.baseavd.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity(), MainGridAdapter.Callback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainGridAdapter

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initViews()
        setUpAdapter()
        initObservers()
    }

    private fun initViews() {
        ViewUtils.setUpColors(resources.getStringArray(R.array.colors))
        setUpToolbar()
    }

    private fun setUpAdapter() {
        adapter = MainGridAdapter(this@MainActivity)
        val layoutManager = GridLayoutManager(this@MainActivity, 2)
        layoutManager.orientation = RecyclerView.VERTICAL
        binding.rvAvd.layoutManager = layoutManager
        binding.rvAvd.adapter = adapter
    }

    private fun initObservers() {
        mainViewModel.getAvdList().observe(this) {
            adapter.addItems(it)
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle(R.string.app_name)
    }

    override fun onItemSelected(id: Int, message: String) {

    }
}