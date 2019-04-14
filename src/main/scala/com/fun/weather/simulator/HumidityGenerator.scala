package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData

import scala.util.Random

/**
  * it generates humdity based on
  */
class HumidityGenerator extends MockGenerator {

  val r= new Random()

  override def generator(wd: WeatherData): WeatherData =
    wd.copy(
      humidity = wd.condition match {

        case "Rain" => f"${90 + r.nextInt(10)}"
        case "Sunny" => f"${10 + r.nextInt(20)}"
        case "Snow" => f"${50 + r.nextInt(10)}"

      }
    )



  override def init(map: Map[String, String]): Unit = config ++ map

}

object HumidityGenerator{

  def apply(): MockGenerator = new HumidityGenerator()
}