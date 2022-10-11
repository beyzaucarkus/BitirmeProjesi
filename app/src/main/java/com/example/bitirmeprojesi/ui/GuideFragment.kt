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
import com.example.bitirmeprojesi.adapter.GuideMightAdapter
import com.example.bitirmeprojesi.adapter.GuideTopPickAdapter
import com.example.bitirmeprojesi.databinding.FragmentGuideBinding
import com.example.bitirmeprojesi.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuideFragment : Fragment() {

    private lateinit var binding: FragmentGuideBinding
    private lateinit var GuideMightAdapter:GuideMightAdapter
   private lateinit var GuideTopPickAdapter: GuideTopPickAdapter
    private val homePageViewModel: HomePageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_guide, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViews()
        observeData()
    }

    fun initRecyclerViews() {
        GuideMightAdapter = GuideMightAdapter()
       GuideTopPickAdapter = GuideTopPickAdapter()
      binding.guidetoprecyler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.guidetoprecyler.adapter = GuideTopPickAdapter

        binding.guidemigthhrecyler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.guidemigthhrecyler.adapter = GuideMightAdapter
    }

    private fun observeData(){
        homePageViewModel.blogData.observe(viewLifecycleOwner){ nearby ->
            GuideTopPickAdapter.setData(nearby)

        }

        homePageViewModel.blogData.observe(viewLifecycleOwner){ topPick ->
            GuideMightAdapter.setData(topPick)
        }
    }

}