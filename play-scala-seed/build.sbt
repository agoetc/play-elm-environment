name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
    guice,
    "org.scalatestplus.play" %% "scalatestplus-play"     % "3.1.2" % Test,
    "org.postgresql"         %  "postgresql"             % "42.2.4",
    "com.typesafe.slick"     %% "slick-codegen"          % "3.2.3",
    "com.typesafe.play"      %% "play-slick"             % "3.0.3",
    "com.typesafe.play"      %% "play-slick-evolutions"  % "3.0.3"
)