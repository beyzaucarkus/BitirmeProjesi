package com.example.bitirmeprojesi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.bitirmeprojesi.BR
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.databinding.GuidefragmentToprecrylerBinding
import com.example.bitirmeprojesi.model.TravelApi
import com.example.bitirmeprojesi.model.TravelModel

class GuideTopPickAdapter () : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var topBinding: ViewDataBinding
    private var travelModel = TravelModel()

    class MyCustomHolder(private val topBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(topBinding.root) {

        fun setBind(travelApi: TravelApi) {
            topBinding as GuidefragmentToprecrylerBinding
            topBinding.setVariable(BR.topItem, travelApi)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        topBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.guidefragment_toprecryler,
            parent,
            false
        )
        return MyCustomHolder(topBinding)
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