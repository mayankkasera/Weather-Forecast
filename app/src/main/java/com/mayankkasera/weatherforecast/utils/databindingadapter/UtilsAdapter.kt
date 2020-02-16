package com.mayankkasera.weatherforecast.utils.databindingadapter

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object UtilsAdapter{

    @JvmStatic
    @BindingAdapter("setImageResource")
    fun setImageResource (imageView : AppCompatImageView, url : String?){
        if(url!=null&&!url.equals(""))
            Picasso.get().load(url).into(imageView)
    }

    @JvmStatic
    @BindingAdapter("setImageIcon")
    fun setImageIcon (imageView : AppCompatImageView, icon : String?){
        Log.i("dshcvhds","asdads : $icon")
        if(icon!=null&&!icon.equals(""))
            Picasso.get().load(String.format("http://openweathermap.org/img/wn/%s@2x.png", icon)).into(imageView)
    }

}