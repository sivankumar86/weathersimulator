package com.fun.weather.simulator


import java.io.{File, PrintWriter}

import scala.io.Source
import scala.util.parsing.json._

object Test extends App {

  class CC[T] { def unapply(a:Any):Option[T] = Some(a.asInstanceOf[T]) }

  object M extends CC[Map[String, Any]]
  object L extends CC[List[Any]]
  object D extends CC[String]



  val jsonString =
    """
      [
 |  {
 |    "id": 707860,
 |    "name": "Hurzuf",
 |    "country": "UA",
 |    "coord": {
 |      "lon": 34.283333,
 |      "lat": 44.549999
 |    }
 |  }
 |  ]
    """.stripMargin

  val fileContents = Source.fromFile("/Users/srramas/Downloads/city.list.json").getLines.mkString


  //val result = JSON.parseFull(fileContents)
  val a=new PrintWriter(new File("country" ))
  val result = for {
    L(i) <- JSON.parseFull(fileContents)
    M(j) <- i
    D(country)=j("country")
    M(coord)=j("coord")
    D(lon)=coord("lon").toString
    D(lat)=coord("lat").toString
    D(name)=j("name")
    if(country=="US")
  }{
   a.write(s"${country},${name},${lon},${lat}\n")
  }

  a.close()

 /* def configLoader(numberofCity:Int) ={

    val fileContents = Source.fromResource("country").getLines
    fileContents.take(numberofCity).map(x=>{
      val b=x.split(",")
      Map("location"->b(1),"lon"->b(2),"lat"->b(3))
    }).toList

    fileContents.foreach(println)
  }

configLoader(3)*/



}
