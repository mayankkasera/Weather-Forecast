package com.mayankkasera.weatherforecast.ui.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mayankkasera.weatherforecast.R
import com.mayankkasera.weatherforecast.ui.weather.city.CityFragment
import com.mayankkasera.weatherforecast.ui.weather.weatherinfo.WeatherInfoFragment

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_weather)
        replace(CityFragment())
        //replace(WeatherInfoFragment.newInstance("bhopal"))
    }

    fun replace(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }

    fun replace(fragment: Fragment?,backstack : String) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.addToBackStack(backstack)
        ft.replace(R.id.frame, fragment!!)
        ft.commit()
    }

}
