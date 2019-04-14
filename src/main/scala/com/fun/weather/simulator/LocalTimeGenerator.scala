package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData
import java.time.{LocalDateTime, LocalTime}

/**
  * Calculate the time based on hours and @todo need to add locality feature
  */
class LocalTimeGenerator extends MockGenerator {

  override def generator(wd: WeatherData): WeatherData = wd.copy(localTime=LocalDateTime.now().
    plusHours(config.getOrElse("hours","0").toInt))

  override def init(map: Map[String, String]): Unit = config ++= map
}

object LocalTimeGenerator{
  def apply(): MockGenerator = new LocalTimeGenerator()

}
