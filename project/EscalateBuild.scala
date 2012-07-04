import sbt._
import Keys._

object EscalateBuild extends Build {
  val springVersion = "3.0.7.RELEASE"
  val springIntegraionVersion = "2.1.3.RELEASE"

  lazy val escalate = Project("escalate", file("."), settings = mainSettings)

  lazy val mainSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ Seq(
    organization := "com.nemish",
    name := "escalate",
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := (_ => false)
  )

}