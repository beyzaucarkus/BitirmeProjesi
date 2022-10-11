package com.example.bitirmeprojesi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.bitirmeprojesi.BR
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.model.TravelApi
import com.example.bitirmeprojesi.model.TravelModel
import com.example.bitirmeprojesi.databinding.SearchfragmentNearbyrecyclerBinding

class SearchNearbyAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var nearbyBinding: ViewDataBinding
    private var travelModel = TravelModel()

    class MyCustomHolder(private val nearbyBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(nearbyBinding.root) {

        fun setBind(travelApi: TravelApi) {
            nearbyBinding as SearchfragmentNearbyrecyclerBinding
            nearbyBinding.setVariable(BR.nearbyItem, travelApi)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        nearbyBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.searchfragment_nearbyrecycler,
            parent,
            false
        )
        return MyCustomHolder(nearbyBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyCustomHolder).setBind(travelModel[position])

    }

    override fun getItemCount(): Int {
        return travelModel.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(travelModel: TravelModel) {
        this.travelModel = travelModel
        notifyDataSetChanged()
    }


}