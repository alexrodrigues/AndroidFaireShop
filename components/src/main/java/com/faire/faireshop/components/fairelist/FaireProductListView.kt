package com.faire.faireshop.components.fairelist

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.faire.faireshop.components.fairelist.adapter.FaireProductItemAdapter
import com.faire.faireshop.components.fairelist.viewobject.FaireProductItemVO


class FaireProductListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    init {
        val customManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        layoutManager = customManager

        val dividerItemDecoration = DividerItemDecoration(
            getContext(),
            customManager.orientation
        )
        addItemDecoration(dividerItemDecoration)
    }

    fun bind(vos: List<FaireProductItemVO>) {
        adapter = FaireProductItemAdapter(vos)
    }
}