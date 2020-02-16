package com.mayankkasera.weatherforecast

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.mayankkasera.weatherforecast.ui.weather.WeatherActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class WeatherActivityTest {

    @Test
    fun rightCityTest(){
        val activityScenario = ActivityScenario.launch(WeatherActivity::class.java)
        Thread.sleep(2000)
        onView(withId(R.id.tv_city_name)).check(matches(isDisplayed()))
        onView(withId(R.id.enter_city_name)).perform(clearText(), typeText("bhopal"), closeSoftKeyboard())
        onView(withId(R.id.openWeatherForecast)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.tv_city_name)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_large_weather_icon)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_large_weather_icon)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_main_temp)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_min_temp)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_weahter_discription)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_day1)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_day2)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_day3)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_day4)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_day5)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_min_max_temp1)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_min_max_temp2)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_min_max_temp3)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_min_max_temp4)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_min_max_temp5)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_small_weather_icon1)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_small_weather_icon2)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_small_weather_icon3)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_small_weather_icon4)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_small_weather_icon5)).check(matches(isDisplayed()))
        onView(withId(R.id.tvErrorMessage)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.retry)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
    }


    @Test
    fun wrongCityTest(){
        val activityScenario = ActivityScenario.launch(WeatherActivity::class.java)
        Thread.sleep(2000)
        onView(withId(R.id.tv_city_name)).check(matches(isDisplayed()))
        onView(withId(R.id.enter_city_name)).perform(clearText(), typeText("hjdbcsbc"), closeSoftKeyboard())
        onView(withId(R.id.openWeatherForecast)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.tv_city_name)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.iv_large_weather_icon)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.iv_large_weather_icon)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_main_temp)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_min_temp)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_weahter_discription)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_day1)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_day2)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_day3)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_day4)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_day5)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_min_max_temp1)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_min_max_temp2)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_min_max_temp3)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_min_max_temp4)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tv_min_max_temp5)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.iv_small_weather_icon1)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.iv_small_weather_icon2)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.iv_small_weather_icon3)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.iv_small_weather_icon4)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.iv_small_weather_icon5)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tvErrorMessage)).check(matches(isDisplayed()))
        onView(withId(R.id.retry)).check(matches(isDisplayed()))
        onView(withId(R.id.retry)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.tv_city_name)).check(matches(isDisplayed()))
        onView(withId(R.id.enter_city_name)).check(matches(withText("hjdbcsbc")));

    }

}