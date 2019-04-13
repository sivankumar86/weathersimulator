package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData
import org.scalatest.{FlatSpec, FunSuite}

/**
  *
  */
class TemperatureGeneratorTest extends FunSuite{


  test("Sunny temperature should be in positive") {
     val wd=TemperatureGenerator().generator(WeatherData(condition = "Sunny"))
    assert(wd.temperature.contains("+"))
  }

  test("Snow temperature should be in negative") {
    val wd=TemperatureGenerator().generator(WeatherData(condition = "Snow"))
    assert(wd.temperature.contains("-"))
  }

}

