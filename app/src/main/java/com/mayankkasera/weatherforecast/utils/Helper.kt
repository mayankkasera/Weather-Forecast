package com.mayankkasera.weatherforecast.utils

import android.annotation.SuppressLint
import java.text.DecimalFormat
import java.text.SimpleDateFormat

object Helper {

    fun getTemperatureInCelsius(d : Double ) : String{
        if(d!=0.0){
            val tempCelsius = d - 273.15
            return DecimalFormat("##").format(tempCelsius).toString()+ 0x00B0.toChar() +"C"
        }
        else{
            return DecimalFormat("##").format(0).toString()+ 0x00B0.toChar() +"C"
        }
    }

    fun getTemperature(d : Double ) : String{
        if(d!=0.0){
            val tempCelsius = d - 273.15
            return DecimalFormat("##").format(tempCelsius).toString()
        }
        else{
            return DecimalFormat("##").format(0).toString()
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun getDayFromDate(date: String):String{
        val format1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = format1.parse(date)
        val format2 = SimpleDateFormat("EEEE")
        var result = format2.format(date)
        when (result) {
            "Sunday"    -> result = "Sun"
            "Monday"    -> result = "Mon"
            "Tuesday"   -> result = "Tue"
            "Wednesday" -> result = "Wed"
            "Thursday"  -> result = "Thu"
            "Friday"    -> result = "Fri"
            "Saturday"  -> result = "Sat"
        }
        return result
    }

}