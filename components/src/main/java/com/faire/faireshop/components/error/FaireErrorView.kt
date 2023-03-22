package com.faire.faireshop.components.error

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.faire.faireshop.R
import com.faire.faireshop.databinding.ViewFaireErrorBinding

class FaireErrorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var retryClickListener: (() -> Unit)? = null

    init {
        val view = ViewFaireErrorBinding.inflate(LayoutInflater.from(context), this, true)
        view.btErrorRetry.setOnClickListener {
            retryClickListener?.invoke()
        }
    }
}