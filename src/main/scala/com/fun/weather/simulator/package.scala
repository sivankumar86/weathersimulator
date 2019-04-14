package com.fun.weather

import com.fun.weather.simulator.dao.WeatherData

import scala.io.Source

/**
  * Implemented generator chain to construct the weather data
  */
package object simulator {

  val weatherChain= List(PostitionGenerator(),LocalTimeGenerator(),ConditionGenerator(), HumidityGenerator(),TemperatureGenerator(),PressureGenerator())


  /**
    *
    * @param number
    * @return
    */
   def getLocation(number:Int):Map[String,String]={
    val file=Source.fromFile("city").getLines.toStream
    file.take(number).map(line=>(line.split(",")(0),line.split(",")(1))).toMap

  }

  /**
    *
    * @param map
    * @return
    */
  def generateRow(map: Map[String,String]): WeatherData ={
      var wd=new WeatherData(location = map.getOrElse("location","Unknown"))
     for(weather <- weatherChain) { weather.init(map);wd=weather.generator(wd)}
     wd

  }



}
