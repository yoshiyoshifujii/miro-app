val akkaVersion = "2.6.6"

lazy val root = (project in file("."))
  .settings(
    name := "miro-app",
    scalaVersion := "2.13.2",
    libraryDependencies ++= Seq(
        "com.typesafe.akka" %% "akka-actor-typed"         % akkaVersion,
        "com.typesafe.akka" %% "akka-slf4j"               % akkaVersion,
        "ch.qos.logback"     % "logback-classic"          % "1.2.3",
        "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test,
        "org.scalatest"     %% "scalatest"                % "3.2.0"     % Test
      )
  )
