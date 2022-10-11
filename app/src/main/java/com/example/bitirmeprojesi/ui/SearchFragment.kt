package com.example.bitirmeprojesi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bitirmeprojesi.adapter.SearchNearbyAdapter
import com.example.bitirmeprojesi.adapter.SearchTopAdapter
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.databinding.FragmentSearchBinding
import com.example.bitirmeprojesi.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchTopAdapter: SearchTopAdapter
    private lateinit var searchNearbyAdapter: SearchNearbyAdapter
    private val homePageViewModel: HomePageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViews()
        observeData()
    }

    fun initRecyclerViews() {
        searchTopAdapter = SearchTopAdapter()
        searchNearbyAdapter = SearchNearbyAdapter()
        binding.searchnearbyrecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.searchnearbyrecycler.adapter = searchNearbyAdapter

        binding.searchtopsrecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.searchtopsrecycler.adapter = searchTopAdapter
    }

    private fun observeData(){
        homePageViewModel.blogData.observe(viewLifecycleOwner){ nearby ->
            searchNearbyAdapter.setData(nearby)

        }

        homePageViewModel.blogData.observe(viewLifecycleOwner){ topPick ->
            searchTopAdapter.setData(topPick)
        }
    }

}