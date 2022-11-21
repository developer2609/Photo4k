package com.example.a4kpictures.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.a4kpictures.R
import com.example.a4kpictures.databinding.RvItemBinding
import com.example.a4kpictures.models.ItemRv

class RvAdapter (val list:ArrayList<ItemRv>, val rvClick: RvClick): RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(val rvItem:RvItemBinding): RecyclerView.ViewHolder(rvItem.root){
        fun onBind(itemRv: ItemRv){

//            val animation = AnimationUtils.loadAnimation(rvItem.root.context, R.anim.my_rv_anim)
//            rvItem.root.startAnimation(animation)

            rvItem.image.setImageResource(itemRv.img)
            rvItem.image.setOnClickListener {
                rvClick.onClick(itemRv)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface RvClick{
        fun onClick(itemRv: ItemRv)
    }
}