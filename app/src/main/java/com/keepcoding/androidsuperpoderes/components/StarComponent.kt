package com.keepcoding.androidsuperpoderes.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import com.keepcoding.androidsuperpoderes.R

class StarComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr){
    private val imageView: ImageView
    var checked = false
        set(value){
            field = value
            selectImage()
        }

    init{
        imageView = inflate(context, R.layout.component_star, this).findViewById(R.id.ivImage)

    }

    private fun selectImage() = imageView.setImageResource(
        if(checked)
            R.drawable.baseline_star_24
        else
            R.drawable.baseline_star_border_24
    )
}