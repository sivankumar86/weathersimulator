package com.fun.weather

import com.fun.weather.simulator._
import com.fun.weather.simulator.dao.WeatherData

object WeatherDataGenerator extends App {

  val config_list=List(Map("location"->"Sydney","lat"->"-33.86","lan"->"151.21","ele"->"39"))

  val writer=Writer.getWriter("csv","output.csv")

  for(i<-0 to 100){
     for(config<-config_list) {
       val out = generateRow(config+("hours"->i.toString))
       writer.println(lineFormat(out,"|"));
     }


  }
  writer.close()
  def lineFormat(weatherData: WeatherData,separator:String): String ={
    s"""${weatherData.location}
      |${separator}
      |${weatherData.position}
      |${separator}
      |${weatherData.localTime}
      |${separator}
      |${weatherData.condition}
      |${separator}
      |${weatherData.temperature}
      |${separator}
      |${weatherData.pressure}
      |${separator}
      |${weatherData.humitity}""".stripMargin.replaceAll("\n", "")
  }

}
