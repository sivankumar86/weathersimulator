package com.fun.weather.simulator

import com.fun.weather.simulator.dao.WeatherData

import scala.util.Random


/**
  * Condition generator based on local
  */
class ConditionGenerator  extends MockGenerator {
  val condition=List("Rain","Snow","Sunny")
  val r=new Random()

  override def generator(wd: WeatherData): WeatherData = {

    wd.condition=condition(r.nextInt(3))
    wd
  }
  override def init(map: Map[String, String]): Unit = config ++ map
}

object ConditionGenerator{

  def apply(): MockGenerator = new ConditionGenerator()
}