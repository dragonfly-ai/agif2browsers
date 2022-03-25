ThisBuild / scalaVersion := "3.1.0"

lazy val agif2browsers = crossProject(JSPlatform, JVMPlatform).settings(
  name := "agif2browsers"
).jvmSettings().jsSettings(
  libraryDependencies ++= Seq("org.scala-js" %%% "scalajs-dom" % "2.0.0")
)

lazy val browserDemo = project.enablePlugins(ScalaJSPlugin).dependsOn(agif2browsers.projects(JSPlatform)).settings(
  name := "browserDemo",
  Compile / mainClass := Some("Demo"),
  Compile / fastOptJS / artifactPath := file("./DemoServer/public_html/js/main.js"),
  Compile / fullOptJS / artifactPath := file("./DemoServer/public_html/js/main.js"),
  scalaJSUseMainModuleInitializer := true
)

lazy val akkaHttpVersion = "10.2.7"
lazy val akkaVersion    = "2.6.17"

lazy val DemoServer = project.dependsOn(agif2browsers.projects(JVMPlatform)).settings(
  name := "DemoServer",
  Compile / mainClass := Some("ImageServer"),
  libraryDependencies ++= Seq(
    "com.typesafe.akka" % "akka-http_2.13" % akkaHttpVersion,
    "com.typesafe.akka" % "akka-stream_2.13" % akkaVersion // or whatever the latest version is
  )
)
