name := "csvlib"

organization := "timdrichards"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  // We add the scala-csv library to our dependencies:
  "com.github.tototoshi" %% "scala-csv" % "1.2.1"
)
