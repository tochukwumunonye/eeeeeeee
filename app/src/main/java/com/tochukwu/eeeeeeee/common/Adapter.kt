package com.tochukwu.eeeeeeee.common

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ListView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tochukwu.eeeeeeee.data.remote.CoinDto
import com.tochukwu.eeeeeeee.databinding.ItemArticleNewsBinding
import com.tochukwu.eeeeeeee.databinding.ItemCoinBinding
import com.tochukwu.eeeeeeee.domain.Coin

class Adapter : androidx.recyclerview.widget.ListAdapter<CoinDto, Adapter.CoinViewHolder>(Article_COMPARATOR){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
       // val  cc = ItemArticleNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val binding = ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }


    inner class CoinViewHolder(private val binding: ItemCoinBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(app: CoinDto){
            binding.apply{

                tvSource.text = app.name
            }
        }
    }
    companion object {
        private val Article_COMPARATOR = object : DiffUtil.ItemCallback<CoinDto>() {
            override fun areItemsTheSame(oldItem: CoinDto, newItem: CoinDto) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: CoinDto, newItem: CoinDto) =
                oldItem == newItem
        }

    }

}



/**


}

override fun onBindViewHolder(holder: ApplicableViewHolder, position: Int) {
val currentItem = getItem(position)

if (currentItem != null) {
holder.bind(currentItem)
}
}



inner class ApplicableViewHolder(private val binding: ItemArticleNewsBinding) :RecyclerView.ViewHolder(binding.root) {

fun bind(app: Applicable) {
binding.apply {
//  Glide.with(itemView).load(app.links.logo).into(logo)
paymentName.text = app.label

}

}

}
companion object {
private val Article_COMPARATOR = object : DiffUtil.ItemCallback<Applicable>() {
override fun areItemsTheSame(oldItem: Applicable, newItem: Applicable) =
oldItem == newItem

override fun areContentsTheSame(oldItem: Applicable, newItem: Applicable) =
oldItem == newItem
}

}

}

**/
