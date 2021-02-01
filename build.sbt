name := "spark-bootcamp" // Project name.

version := "0.1" // Project version.

organization := "nl.rug.sc" // Organization name, used when packaging.

scalaVersion := "2.12.13" // Spark 3.0 is based on Scala 2.12.

val sparkVersion = "3.0.1" // Latest version.

libraryDependencies ++= List(
  "org.apache.spark" %% "spark-core"      % sparkVersion % "provided", // Basic Spark library
  "org.apache.spark" %% "spark-mllib"     % sparkVersion % "provided", // Machine learning library
  "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided", // Streaming library
  "org.apache.spark" %% "spark-sql"       % sparkVersion % "provided", // SQL library
  "org.apache.spark" %% "spark-graphx"    % sparkVersion % "provided"  // Graph library
)