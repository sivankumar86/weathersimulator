package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData

import scala.util.Random


class PressureGenerator extends MockGenerator {

  val r=new Random()

  override def generator(wd: WeatherData): WeatherData = {wd.pressure=f"${900+r.nextInt(300)+r.nextDouble()}%3.2f";wd }

  override def init(map: Map[String, String]): Unit = config ++ map
}

object PressureGenerator{
  def apply(): MockGenerator = new PressureGenerator()
}