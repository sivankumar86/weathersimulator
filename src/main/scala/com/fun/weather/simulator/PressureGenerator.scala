package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData

import scala.util.Random

/**
  * Random number >900 @todo. It can have logic based on condition
  */
class PressureGenerator extends MockGenerator {

  val r=new Random()

  override def generator(wd: WeatherData): WeatherData = wd.copy(pressure=f"${900+r.nextInt(300)+r.nextDouble()}%3.2f")

  override def init(map: Map[String, String]): Unit = config ++ map
}

object PressureGenerator{
  def apply(): MockGenerator = new PressureGenerator()
}