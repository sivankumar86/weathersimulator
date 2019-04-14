package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData

import scala.collection.immutable.HashMap

/**
  * Look up and data generation logic according to the feature
  */
trait MockGenerator {
  var config:HashMap[String,String]=new HashMap()
  def init(map: Map[String,String])
  def generator(wd:WeatherData):WeatherData

}
