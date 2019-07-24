name := """TechBlog"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.0"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
libraryDependencies += "com.h2database" % "h2" % "1.4.197"
libraryDependencies += evolutions
libraryDependencies += jdbc
libraryDependencies += "org.scalikejdbc" %% "scalikejdbc" % "3.3.5"
libraryDependencies += "org.scalikejdbc" %% "scalikejdbc-test" % "3.3.5" % "test"
libraryDependencies += "org.scalikejdbc" %% "scalikejdbc-config" % "3.3.5" % "test"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies += "org.hsqldb" % "hsqldb" % "2.+"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
