import sbt._
import Keys._

object EscalateBuild extends Build {
  val springVersion = "3.0.7.RELEASE"
  val springIntegraionVersion = "2.1.3.RELEASE"

  lazy val escalate = Project("escalate", file("."), settings = mainSettings)

  lazy val mainSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ Seq(
    organization := "com.nemish",
    name := "escalate",
    version := "0.1",
    scalaVersion := "2.9.2",
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := (_ => false),
    resolvers ++= Seq(
      Classpaths.typesafeResolver,
      "Spring Framework Maven Release Repository" at "http://maven.springframework.org/release/"),
    libraryDependencies ++= Seq(
      "org.springframework" % "spring-core" % springVersion,
      "org.springframework.integration" % "spring-integration-core" % springIntegraionVersion,
      "org.scalatest" %% "scalatest" % "1.8" % "test"
      )
  )
}