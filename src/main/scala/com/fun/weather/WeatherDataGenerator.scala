package com.fun.weather

import com.fun.weather.simulator._
import com.fun.weather.simulator.dao.WeatherData

import scala.io.Source

import org.slf4j.LoggerFactory


object WeatherDataGenerator extends App {

  private val log = LoggerFactory.getLogger(getClass)

  val arglist = args.toList

  type OptionMap = Map[Symbol, String]

  /**
    * 1. Number of city needs to be used in the output
    * 2. How many hours of sample data is required
    * @param map
    * @param list
    * @return
    */
  def nextOption(map : OptionMap, list: List[String]) : OptionMap = {
    def isSwitch(s : String) = (s(0) == '-')
    list match {
      case Nil => map
      case "--numberofcity" :: value :: tail =>
        nextOption(map ++ Map('numberofcity -> value), tail)
      case "--hours" :: value :: tail =>
        nextOption(map ++ Map('hours -> value), tail)


    }
  }
  val options = nextOption(Map(),arglist)

  log.info(s" arguments ${options}")

  /**
    * default number of cities are 30 and it can be configured
    */
  val config_list=configLoader(options.getOrElse('numberofcity,"30").toInt)

  /**
    * @TODO output file cannot be changed which can be passed as argument and file format like parquet,json etc..
    */
  val writer=Writer.getWriter("csv","output.csv")

  /**
    * Default number of hours are 10 and it can be changed using parameter
    */
  val hours=options.getOrElse('hours,"10").toInt

  for(i<-0 to hours){
     for(config<-config_list) {
       val out = generateRow(config+("hours"->i.toString))
       writer.println(lineFormat(out,"|"));
     }


  }
  writer.close()

  /**
    * create a line based on custom delimiter
    *
    * @param weatherData
    * @param separator
    * @return
    */
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
      |${weatherData.humidity}""".stripMargin.replaceAll("\n", "")
  }


  /**
    *
    * @param numberofCity
    * @return
    */
  def configLoader(numberofCity:Int) ={

    val fileContents = Source.fromResource("country").getLines
    fileContents.take(numberofCity).map(x=>{
      val b=x.split(",")
      Map("location"->b(1),"lon"->b(2),"lat"->b(3))
    }).toList


  }

}
