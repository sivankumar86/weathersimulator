package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData

import scala.util.Random

/**
  * it generates humdity based on
  */
class HumudityGenerator extends MockGenerator {

  val r= new Random()

  override def generator(wd: WeatherData): WeatherData = {
    wd.condition match {

      case "Rain" => wd.humitity = f"${90 + r.nextInt(10)}"
      case "Sunny" => wd.humitity = f"${10 + r.nextInt(20)}"
      case "Snow" => wd.humitity = f"${50 + r.nextInt(10)}"

    }
    wd
  }

  override def init(map: Map[String, String]): Unit = config ++ map

}

object HumudityGenerator{

  def apply(): MockGenerator = new HumudityGenerator()
}