packSettings

scalaVersion := "2.11.6"

organization := "org.xerial"

name := "lstore"

description := "L-Store: Log-oriented DBMS"

crossPaths := false

incOptions := incOptions.value.withNameHashing(true)

logBuffered in Test := false

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.0" % "test",
  "org.scalacheck" % "scalacheck_2.11" % "1.11.4" % "test",
  "org.xerial" % "xerial-core" % "3.3.6",
  "org.xerial" % "xerial-lens" % "3.3.6",
  "com.github.nscala-time" %% "nscala-time" % "1.2.0",
  "org.scala-lang" % "scalap" % scalaVersion.value,
  "org.scala-lang" % "scala-compiler" % scalaVersion.value,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

// Option available since sbt-0.13.7
updateOptions := updateOptions.value.withCachedResolution(true)

