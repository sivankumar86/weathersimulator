package com.fun.weather.simulator.dao

import java.time.LocalDateTime

/**
  * It hold the mock weather data
  * @param location
  * @param lon
  * @param lat
  * @param elevation
  * @param localTime
  * @param condition
  * @param temperature
  * @param pressure
  * @param humitity
  */
case class WeatherData (var location:String="", var position:String="",
                        var localTime:LocalDateTime=LocalDateTime.now(),
                        var condition:String="",var temperature:String="",
                        var pressure:String="0.0",var humitity:String="0")

