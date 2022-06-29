package com.idea3d.global_logic_challenge.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.idea3d.global_logic_challenge.R
import com.idea3d.global_logic_challenge.core.BaseViewHolder
import com.idea3d.global_logic_challenge.databinding.LaptopRowBinding
import com.idea3d.global_logic_challenge.model.Laptop

class MainAdapter(private val context: Context, private val laptopList:List<Laptop>,
                  private val itemClickListener:OnLaptopClickListener):
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnLaptopClickListener{
        fun onLaptopClick(laptop:Laptop)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            LaptopRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MainViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MainViewHolder->holder.bind(laptopList[position])
        }
    }

    override fun getItemCount(): Int {
        return laptopList.size
    }

    inner class MainViewHolder(private val itemBinding:LaptopRowBinding):
        BaseViewHolder<Laptop>(itemBinding.root) {
        override fun bind(item: Laptop) {
            val image = item.image
            Glide.with(context)
                .load(image)
                .centerCrop()
                .placeholder(R.drawable.lap_icon)
                .dontAnimate()
                .into(itemBinding.ivPortada)
            itemBinding.tvTitulo.text=item.title
            itemBinding.tvDesc.text=item.description
            itemView.setOnClickListener {itemClickListener.onLaptopClick(item)}
        }
    }
}