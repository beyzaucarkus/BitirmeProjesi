package com.example.bitirmeprojesi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.adapter.HomeDealsAllAdapter
import com.example.bitirmeprojesi.databinding.FragmentHomeBinding
import com.example.bitirmeprojesi.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeDealsAllAdapter: HomeDealsAllAdapter
    private val homePageViewModel: HomePageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViews()
        observeData()
    }

    fun initRecyclerViews() {
        homeDealsAllAdapter=HomeDealsAllAdapter()

        binding.dealsrecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.dealsrecycler.adapter = homeDealsAllAdapter
    }

    private fun observeData(){

        homePageViewModel.blogData.observe(viewLifecycleOwner){ topPick ->
            homeDealsAllAdapter.setData(topPick)
        }
    }
}