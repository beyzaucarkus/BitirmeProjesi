package com.example.bitirmeprojesi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.bitirmeprojesi.BR
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.databinding.HomefargmentDealsallrecyclerBinding
import com.example.bitirmeprojesi.model.TravelApi
import com.example.bitirmeprojesi.model.TravelModel

class HomeDealsAllAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val topDestinationArray = ArrayList<TravelApi>()
    private lateinit var topBinding: ViewDataBinding
    private var travelModel = TravelModel()

    fun topDestinationCategoryFilter(){
        for (topDestination in travelModel){
            if (topDestination.category == "mightneed"){
                topDestinationArray.add(topDestination)
            }
        }
    }

    class MyCustomHolder(private val topBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(topBinding.root) {

        fun setBind(travelApi: TravelApi) {
            topBinding as HomefargmentDealsallrecyclerBinding
            topBinding.setVariable(BR.topItem, travelApi)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        topBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.homefargment_dealsallrecycler,
            parent,
            false
        )
        return MyCustomHolder(topBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyCustomHolder).setBind(topDestinationArray[position])

    }

    override fun getItemCount(): Int {
        return topDestinationArray.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(travelModel: TravelModel) {
        this.travelModel = travelModel
        topDestinationCategoryFilter()
        notifyDataSetChanged()

    }


}