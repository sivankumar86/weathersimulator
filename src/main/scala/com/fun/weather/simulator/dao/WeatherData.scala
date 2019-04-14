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
  * @param humidity
  */
case class WeatherData ( location:String="",  position:String="",
                         localTime:LocalDateTime=LocalDateTime.now(),
                         condition:String="", temperature:String="",
                         pressure:String="0.0", humidity:String="0")

