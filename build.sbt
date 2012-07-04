name := "escalate"

version := "0.1"

scalaVersion := "2.9.2"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Spring Framework Maven Release Repository" at "http://maven.springframework.org/release/"
)

libraryDependencies ++= Seq(
  "org.springframework" % "spring-core" % springVersion,
  "org.springframework.integration" % "spring-integration-core" % springIntegraionVersion,
  "org.scalatest" %% "scalatest" % "1.8" % "test"
)