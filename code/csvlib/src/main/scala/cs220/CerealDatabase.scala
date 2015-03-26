package cs220

import java.io.File
import com.github.tototoshi.csv._

object CerealDatabase {

  def printcsv(data: List[Map[String,String]]) {
    println("############################################")
    for ((row, index) <- data.zipWithIndex) {
      println("** RECORD " + index + " **")
      row foreach {
        case (key, value) => println(key + ": " + value)
      }
    }
    println("############################################")
  }

  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("expected a file name")
      System.exit(1)
    }

    val file = args(0)

    val reader = CSVReader.open(new File(file))
    val data   = reader.allWithHeaders()

    printcsv(data)
  }

}