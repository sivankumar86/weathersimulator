package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData

import scala.util.Random

/**
  * lat and lon setting based on location
  */
class PostitionGenerator extends MockGenerator {

  val r=new Random()

  override def generator(wd: WeatherData): WeatherData = {

    wd.position=s"""${config.getOrElse("lat","00")},${config.getOrElse("lon","00")},${config.getOrElse("ele",20+r.nextInt(50))}""";
    wd
  }

  override def init(map: Map[String, String]): Unit = config++=map
}

object PostitionGenerator{
  def apply(): MockGenerator = new PostitionGenerator()


}
