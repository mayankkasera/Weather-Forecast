package com.mayankkasera.weatherforecast.ui.weather.weatherinfo


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.mayankkasera.weatherforecast.R
import com.mayankkasera.weatherforecast.api.RepositoryHelper
import com.mayankkasera.weatherforecast.databinding.WeatherInfoDataBinding
import com.mayankkasera.weatherforecast.utils.createFactory

/**
 * A simple [Fragment] subclass.
 */

class WeatherInfoFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var city : String
    private lateinit var binding: WeatherInfoDataBinding
    private lateinit var weatherInfoViewModel: WeatherInfoViewModel

    companion object {
        private const val CITY = "City"
        fun newInstance(city : String): WeatherInfoFragment {
            val bundle = Bundle()
            bundle.putSerializable(CITY, city)
            val fragment = WeatherInfoFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather_info, container, false)
        init()
        loadData()
        setObserver()
        return mView
    }

    private fun loadData() {
        weatherInfoViewModel.loadData(city)
    }

    private fun init() {
        city = arguments?.getSerializable(WeatherInfoFragment.CITY) as String
        mView = binding.root
        val factory = WeatherInfoViewModel(RepositoryHelper().weatherRepositoryI,RepositoryHelper().forcastRepositoryI).createFactory()
        weatherInfoViewModel = ViewModelProvider(this, factory).get(WeatherInfoViewModel::class.java)
    }

    private fun setObserver() {
        weatherInfoViewModel.mutableLiveData.observe(this, Observer {
            binding.state = it
            Log.i("dsfsfsdfsd"," forecastReponce : ${it.forecastReponce} \n weatherResponse : ${it.weatherResponse}")
        })
    }


}
