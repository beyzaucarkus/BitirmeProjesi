package com.example.bitirmeprojesi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.bitirmeprojesi.BR
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.databinding.GuidefragmentMightrecylerBinding
import com.example.bitirmeprojesi.model.TravelApi
import com.example.bitirmeprojesi.model.TravelModel

class GuideMightAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mightDestinationArray = ArrayList<TravelApi>()
    private lateinit var mightBinding: ViewDataBinding
    private var travelModel = TravelModel()

    fun topDestinationCategoryFilter(){
        for (topDestination in travelModel){
            if (topDestination.category == "toppick"){
                mightDestinationArray.add(topDestination)
            }
        }
    }

    class MyCustomHolder(private val topBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(topBinding.root) {

        fun setBind(travelApi: TravelApi) {
            topBinding as GuidefragmentMightrecylerBinding
            topBinding.setVariable(BR.topItem, travelApi)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mightBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.guidefragment_mightrecyler,
            parent,
            false
        )
        return MyCustomHolder(mightBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyCustomHolder).setBind(mightDestinationArray[position])

    }

    override fun getItemCount(): Int {
        return mightDestinationArray.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(travelModel: TravelModel) {
        this.travelModel = travelModel
        topDestinationCategoryFilter()
        notifyDataSetChanged()

    }


}