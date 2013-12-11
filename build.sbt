name := "chronod"

version := "1.0"

libraryDependencies ++= Seq(
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "org.specs2" %% "specs2" % "2.3.6" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)