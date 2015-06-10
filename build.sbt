import com.simplytyped.Antlr4Plugin._

sonatypeProfileName := "org.xerial"

packSettings

scalaVersion in Global := "2.11.6"

organization := "org.xerial"

name := "lstore"

description := "L-Store: Log-oriented DBMS"

crossPaths := false

incOptions := incOptions.value.withNameHashing(true)

logBuffered in Test := false

libraryDependencies ++= Seq(
  "com.github.nscala-time" %% "nscala-time" % "1.2.0",
  "org.scala-lang" % "scalap" % scalaVersion.value,
  "org.scala-lang" % "scala-compiler" % scalaVersion.value,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

val testLibraries = Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.scalacheck" % "scalacheck_2.11" % "1.12.3" % "test"
)

// Option available since sbt-0.13.7
updateOptions := updateOptions.value.withCachedResolution(true)

val withTestScope = "test->test;compile->compile"

lazy val root = Project(
     id = "lstore-root",
     base = file("."),
     aggregate = Seq(lstoreCore, lstoreSql)
)

lazy val lstoreCore = Project(
  id = "lstore-core",
  base = file("lstore-core"),
  settings = Seq(
    libraryDependencies := testLibraries ++ Seq(
      "org.msgpack" % "msgpack-core" % "0.7.0-p9",
      "org.xerial" % "xerial-core" % "3.3.6",
      "org.xerial" % "xerial-lens" % "3.3.6"
    )
  )
)


lazy val lstoreSql = Project(
     id = "lstore-sql",
     base = file("lstore-sql"),
     settings = antlr4Settings ++ Seq(
       antlr4PackageName in Antlr4 := Some("lstore.sql"),
       libraryDependencies := testLibraries ++ Seq(
         "org.antlr" % "antlr4" % "4.5"
       )
     )
) dependsOn(lstoreCore % withTestScope)



pomExtra in Global := {
          <url>http://xerial.org/</url>
          <licenses>
            <license>
              <name>Apache 2</name>
              <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
            </license>
          </licenses>
          <scm>
            <connection>scm:git:github.com/xerial/l-store.git</connection>
            <developerConnection>scm:git:git@github.com:xerial/l-store.git</developerConnection>
            <url>github.com/xerial/l-store.git</url>
          </scm>
          <properties>
            <scala.version>
              {scalaVersion.value}
            </scala.version>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
          </properties>
          <developers>
            <developer>
              <id>leo</id>
              <name>Taro L. Saito</name>
              <url>http://xerial.org/leo</url>
            </developer>
          </developers>
}

