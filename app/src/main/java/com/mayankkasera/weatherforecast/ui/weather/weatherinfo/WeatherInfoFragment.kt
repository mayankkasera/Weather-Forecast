package com.mayankkasera.weatherforecast.ui.weather.weatherinfo


import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mayankkasera.weatherforecast.R
import com.mayankkasera.weatherforecast.api.RepositoryHelper
import com.mayankkasera.weatherforecast.databinding.WeatherInfoDataBinding
import com.mayankkasera.weatherforecast.utils.createFactory
import com.podcopic.animationlib.library.AnimationType
import com.podcopic.animationlib.library.StartSmartAnimation


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

        binding.retry.setOnClickListener{
            getFragmentManager()!!.popBackStack()
        }

    }

    private fun setObserver() {
        weatherInfoViewModel.mutableLiveData.observe(this, Observer {
            binding.state = it

           if(it.success&&!it.failure){
              if(!it.loading){
                  animateView()
              }
           }
        })
    }

    private fun animateView() {

        StartSmartAnimation.startAnimation( binding.tvDay1 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.tvDay2 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.tvDay3 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.tvDay4 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.tvDay5 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.tvMinMaxTemp1 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.tvMinMaxTemp2 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.tvMinMaxTemp3 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.tvMinMaxTemp4 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.tvMinMaxTemp5 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.ivSmallWeatherIcon1 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.ivSmallWeatherIcon2 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.ivSmallWeatherIcon3, AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.ivSmallWeatherIcon4 , AnimationType.SlideInUp , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( binding.ivSmallWeatherIcon5 , AnimationType.SlideInUp , 2000 , 0 , true );

    }


}
