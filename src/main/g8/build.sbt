import spray.revolver.RevolverPlugin._
import AssemblyKeys._

Revolver.settings

organization := "$organization$"

name := "$name$"

version := "$version$"

scalaVersion := "$scala_version$"

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-netty-server" % "$unfiltered_version$",
  "com.netflix.rxjava" % "rxjava-scala" % "$rx_version$",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0" % "test",
  "net.databinder" %% "unfiltered-specs2" % "$unfiltered_version$" % "test"
)

assemblySettings

jarName in assembly := "root.jar"
