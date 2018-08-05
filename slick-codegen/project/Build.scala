import sbt._
import Keys._
import Tests._

/**
 * This is a simple sbt setup generating Slick code from the given
 * database before compiling the projects code.
 */
object myBuild extends Build {
  lazy val mainProject = Project(
    id="slick-codegen",
    base=file("."),
    settings = Project.defaultSettings ++ Seq(
      scalaVersion := "2.11.6",
      libraryDependencies ++= List(
        "com.typesafe.slick" %% "slick" % "3.0.0",
        "com.typesafe.slick" %% "slick-codegen" % "3.0.0",
        "org.slf4j" % "slf4j-nop" % "1.6.4",
        "org.postgresql" % "postgresql" % "42.2.4"
      ),
      slick <<= slickCodeGenTask, // register manual sbt command
      sourceGenerators in Compile <+= slickCodeGenTask // register automatic code generation on every compile, remove for only manual use
    )
  )

  // code generation task
  lazy val slick = TaskKey[Seq[File]]("gen-tables")
  lazy val slickCodeGenTask = (sourceManaged, dependencyClasspath in Compile, runner in Compile, streams) map { (dir, cp, r, s) =>
    val outputDir = "../play-scala-seed/app"
    val url = "jdbc:postgresql://localhost/todo"
    val username = "testuser"
    val password = "testpass"
    val jdbcDriver = "org.postgresql.Driver"
    val slickDriver = "slick.driver.PostgresDriver"
    val pkg = "models"
    toError(r.run("slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg, username, password), s.log))
    val fname = outputDir + "/models/Tables.scala"
    Seq(file(fname))
  }
}
