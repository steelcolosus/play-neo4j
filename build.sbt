name := """play-neo4j"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  // Select Play modules
  //jdbc,      // The JDBC connection pool and the play.api.db API
  //anorm,     // Scala RDBMS Library
  //javaJdbc,  // Java database API
  //javaEbean, // Java Ebean plugin
  //javaJpa,   // Java JPA plugin
  //filters,   // A set of built-in filters
  javaCore,  // The core Java API
  // WebJars pull in client-side web libraries
  "org.webjars" %% "webjars-play" % "2.2.0",
  "org.webjars" % "bootstrap" % "2.3.1",
  "com.github.tuxBurner" %% "play-neo4jplugin" % "1.3.3"
)

resolvers += "tuxburner.github.io" at "http://tuxburner.github.io/repo"

resolvers += "Neo4j" at "http://m2.neo4j.org/content/repositories/releases/"

play.Project.playScalaSettings


javaOptions ++= Seq("-Xmx512M", "-Xmx4048M", "-XX:MaxPermSize=4048M")