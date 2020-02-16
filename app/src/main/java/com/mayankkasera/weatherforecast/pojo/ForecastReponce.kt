package com.mayankkasera.weatherforecast.pojo


import com.google.gson.annotations.SerializedName
import com.mayankkasera.weatherforecast.utils.Helper

data class ForecastReponce(
    @SerializedName("city")
    var city: City = City(),
    @SerializedName("cnt")
    var cnt: Int = 0,
    @SerializedName("cod")
    var cod: String = "",
    @SerializedName("list")
    var list: List<X> = listOf(),
    @SerializedName("message")
    var message: Int = 0
) {
    data class City(
        @SerializedName("coord")
        var coord: Coord = Coord(),
        @SerializedName("country")
        var country: String = "",
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("name")
        var name: String = "",
        @SerializedName("population")
        var population: Int = 0,
        @SerializedName("sunrise")
        var sunrise: Int = 0,
        @SerializedName("sunset")
        var sunset: Int = 0,
        @SerializedName("timezone")
        var timezone: Int = 0
    ) {
        data class Coord(
            @SerializedName("lat")
            var lat: Double = 0.0,
            @SerializedName("lon")
            var lon: Double = 0.0
        )
    }

    data class X(
        @SerializedName("clouds")
        var clouds: Clouds = Clouds(),
        @SerializedName("dt")
        var dt: Int = 0,
        @SerializedName("dt_txt")
        var dtTxt: String = "",
        @SerializedName("main")
        var main: Main = Main(),
        @SerializedName("rain")
        var rain: Rain = Rain(),
        @SerializedName("sys")
        var sys: Sys = Sys(),
        @SerializedName("weather")
        var weather: List<Weather> = listOf(),
        @SerializedName("wind")
        var wind: Wind = Wind()
    ) {
        data class Clouds(
            @SerializedName("all")
            var all: Int = 0
        )

        data class Main(
            @SerializedName("feels_like")
            var feelsLike: Double = 0.0,
            @SerializedName("grnd_level")
            var grndLevel: Int = 0,
            @SerializedName("humidity")
            var humidity: Int = 0,
            @SerializedName("pressure")
            var pressure: Int = 0,
            @SerializedName("sea_level")
            var seaLevel: Int = 0,
            @SerializedName("temp")
            var temp: Double = 0.0,
            @SerializedName("temp_kf")
            var tempKf: Double = 0.0,
            @SerializedName("temp_max")
            var tempMax: Double = 0.0,
            @SerializedName("temp_min")
            var tempMin: Double = 0.0
        )

        data class Rain(
            @SerializedName("3h")
            var h: Double = 0.0
        )

        data class Sys(
            @SerializedName("pod")
            var pod: String = ""
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
        )

        data class Wind(
            @SerializedName("deg")
            var deg: Int = 0,
            @SerializedName("speed")
            var speed: Double = 0.0
        )



    }

    fun getMinMaxTemperature(day : Int):String{
        if(list.size>day)
          return Helper.getTemperature(list.get(day).main.tempMin)+"/"+Helper.getTemperature(list.get(day).main.tempMax) +"\n" +0x00B0.toChar() +"C"
        else
            return Helper.getTemperature(0.0)+"/"+Helper.getTemperature(0.0) +"\n" +0x00B0.toChar() +"C"

    }

    fun getIconUrl(day : Int) : String{
        if(list.size>day)
            return String.format("http://openweathermap.org/img/wn/%s@2x.png",list.get(day).weather.get(0).icon )
        else
            return ""
    }

    fun getDay(day : Int)  : String{
        if(list.size>day)
          return Helper.getDayFromDate(list.get(day).dtTxt)
        else
            return ""
    }



}