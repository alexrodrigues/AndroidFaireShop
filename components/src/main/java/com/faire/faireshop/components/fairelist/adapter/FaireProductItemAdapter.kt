package com.faire.faireshop.components.fairelist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faire.faireshop.components.fairelist.viewobject.FaireProductItemVO
import com.faire.faireshop.databinding.CellFaireProductItemBinding
import com.squareup.picasso.Picasso

class FaireProductItemAdapter(
    private val vos: List<FaireProductItemVO>
): RecyclerView.Adapter<FaireProductItemAdapter.FaireHomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaireHomeViewHolder =
        FaireHomeViewHolder(
            CellFaireProductItemBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun getItemCount(): Int = vos.size

    override fun onBindViewHolder(holder: FaireHomeViewHolder, position: Int) {
        holder.bind(vos[position])
    }

    inner class FaireHomeViewHolder(
        private val view: CellFaireProductItemBinding
    ) : RecyclerView.ViewHolder(view.root) {

        fun bind(vo: FaireProductItemVO) {
            view.tvProductName.text = vo.productName
            vo.productImage?.let {
                Picasso.get().load(it).into(view.ivFaireHome)
            }
        }
    }
}