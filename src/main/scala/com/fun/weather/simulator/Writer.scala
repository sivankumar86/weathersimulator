package com.fun.weather.simulator

import java.io.{File, PrintWriter}


/**
  * Writer factory based on name
  */
object Writer{
  def getWriter(name:String,filename:String) = name match {
    case "csv" => new PrintWriter(new File(filename ))


  }
}
