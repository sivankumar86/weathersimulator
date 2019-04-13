package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData

class PostitionGenerator extends MockGenerator {


  override def generator(wd: WeatherData): WeatherData = {
    wd.position=s"""${config.getOrElse("lat","00")},${config.getOrElse("lan","00")},${config.getOrElse("ele","00")}""";
    wd
  }

  override def init(map: Map[String, String]): Unit = config++=map
}

object PostitionGenerator{
  def apply(): MockGenerator = new PostitionGenerator()


}
