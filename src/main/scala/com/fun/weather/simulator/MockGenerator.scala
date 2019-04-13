package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData

import scala.collection.immutable.HashMap


trait MockGenerator {
  var config:HashMap[String,String]=new HashMap()
  def init(map: Map[String,String])
  def generator(wd:WeatherData):WeatherData

}
