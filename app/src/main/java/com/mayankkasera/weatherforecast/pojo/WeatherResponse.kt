package com.mayankkasera.weatherforecast.pojo


import com.google.gson.annotations.SerializedName
import com.mayankkasera.weatherforecast.utils.Helper
import java.text.DecimalFormat

data class WeatherResponse(
    @SerializedName("base")
    var base: String = "",
    @SerializedName("clouds")
    var clouds: Clouds = Clouds(),
    @SerializedName("cod")
    var cod: Int = 0,
    @SerializedName("coord")
    var coord: Coord = Coord(),
    @SerializedName("dt")
    var dt: Int = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("main")
    var main: Main = Main(),
    @SerializedName("name")
    var name: String = "",
    @SerializedName("sys")
    var sys: Sys = Sys(),
    @SerializedName("timezone")
    var timezone: Int = 0,
    @SerializedName("visibility")
    var visibility: Int = 0,
    @SerializedName("weather")
    var weather: List<Weather> = listOf(),
    @SerializedName("wind")
    var wind: Wind = Wind()
) {
    data class Clouds(
        @SerializedName("all")
        var all: Int = 0
    )

    data class Coord(
        @SerializedName("lat")
        var lat: Double = 0.0,
        @SerializedName("lon")
        var lon: Double = 0.0
    )

    data class Main(
        @SerializedName("feels_like")
        var feelsLike: Double = 0.0,
        @SerializedName("humidity")
        var humidity: Int = 0,
        @SerializedName("pressure")
        var pressure: Int = 0,
        @SerializedName("temp")
        var temp: Double = 0.0,
        @SerializedName("temp_max")
        var tempMax: Double = 0.0,
        @SerializedName("temp_min")
        var tempMin: Double = 0.0
    )

    data class Sys(
        @SerializedName("country")
        var country: String = "",
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("sunrise")
        var sunrise: Int = 0,
        @SerializedName("sunset")
        var sunset: Int = 0,
        @SerializedName("type")
        var type: Int = 0
    )

    data class Weather(
        @SerializedName("description")
        var description: String = "",
        @SerializedName("icon")
        var icon: String = "",
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("main")
        var main: String = ""
    ){

    }

    data class Wind(
        @SerializedName("deg")
        var deg: Int = 0,
        @SerializedName("speed")
        var speed: Double = 0.0
    )

    fun getIconUrl() : String{
        if(weather.size>0)
           return String.format("http://openweathermap.org/img/wn/%s@2x.png",weather.get(0).icon )
        else
            return ""
    }

    fun getDescription():String{
        if(weather.size>0)
            return weather.get(0).description
        else
            return ""
    }

    fun getTemperature():String{
        return Helper.getTemperatureInCelsius(main.temp)
    }

    fun getMinMaxTemperature():String{
        return Helper.getTemperature(main.tempMin)+" / "+Helper.getTemperature(main.tempMax)+" "  +0x00B0.toChar() +"C"
    }



}