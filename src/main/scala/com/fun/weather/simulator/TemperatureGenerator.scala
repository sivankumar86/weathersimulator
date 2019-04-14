package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData

import scala.util.Random

/**
  * set temperature according to condition
  */
class TemperatureGenerator extends MockGenerator {
  val r = new Random()

  override def generator(wd: WeatherData): WeatherData = { wd.condition match {

    case "Rain" =>wd.temperature=f"+${10+r.nextInt(10)+r.nextDouble()}%2.2f"
    case "Sunny" =>wd.temperature=f"+${20+r.nextInt(20)+r.nextDouble()}%2.2f"
    case "Snow" =>wd.temperature=f"-${r.nextInt(10)+r.nextDouble()}%2.2f"

  }
  wd
  }

  override def init(map: Map[String, String]): Unit = config ++ map
}

object TemperatureGenerator{
  def apply(): MockGenerator = new TemperatureGenerator()
}