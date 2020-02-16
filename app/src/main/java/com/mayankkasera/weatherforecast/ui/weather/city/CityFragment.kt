package com.mayankkasera.weatherforecast.ui.weather.city


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction

import com.mayankkasera.weatherforecast.R
import com.mayankkasera.weatherforecast.databinding.CityBinding
import com.mayankkasera.weatherforecast.ui.weather.weatherinfo.WeatherInfoFragment

/**
 * A simple [Fragment] subclass.
 */
class CityFragment : Fragment() {

    private lateinit var mView: View
    lateinit var binding: CityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_city, container, false)
        mView = binding.root
        binding.openWeatherForecast.setOnClickListener{
            if(binding.enterCityName.text!!.length>0){
                replace(WeatherInfoFragment.newInstance(binding.enterCityName.text.toString()),"city")
            }
        }
        return mView

    }

    fun replace(fragment: Fragment?,backstack : String) {
        val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
        ft.addToBackStack(backstack)
        ft.replace(R.id.frame, fragment!!)
        ft.commit()
    }


}
