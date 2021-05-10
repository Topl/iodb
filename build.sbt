import _root_.sbt.Keys._

organization := "org.scorexfoundation"

name := "iodb"

version := "0.4.0"

val scala212 = "2.12.13"
val scala213 = "2.13.5"

scalaVersion := scala213
crossScalaVersions := Seq(scala213, scala212)

libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "19.0",
  "net.jpountz.lz4" % "lz4" % "1.3.0",
  "org.slf4j" % "slf4j-api" % "1.7.30",
  "org.scalatest" %% "scalatest" % "3.0.9" % "test",
  "org.scalactic" %% "scalactic" % "3.0.9" % "test",
  "org.scalacheck" %% "scalacheck" % "1.14.0" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.rocksdb" % "rocksdbjni" % "4.5.1" % "test",
  "org.iq80.leveldb" % "leveldb" % "0.9" % "test",
  "ch.qos.logback" % "logback-classic" % "1.+" % "test"
)

licenses := Seq("CC0" -> url("https://creativecommons.org/publicdomain/zero/1.0/legalcode"))

homepage := Some(url("https://github.com/ScorexProject/iodb"))

resolvers ++= Seq("Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "SonaType" at "https://oss.sonatype.org/content/groups/public",
  "Typesafe maven releases" at "https://repo.typesafe.com/typesafe/maven-releases/")

run / fork := true

Test / run / javaOptions ++= Seq(
  "-Xmx1G"
)

publishMavenStyle := true

Test / fork := true

Test / publishArtifact := false

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

pomExtra :=
  <scm>
    <url>git@github.com:ScorexProject/iodb.git</url>
    <connection>scm:git:git@github.com:ScorexProject/iodb.git</connection>
  </scm>
    <developers>
      <developer>
        <id>kushti</id>
        <name>Alexander Chepurnoy</name>
        <url>http://chepurnoy.org/</url>
      </developer>
      <developer>
        <id>jan</id>
        <name>Jan Kotek</name>
      </developer>
    </developers>
