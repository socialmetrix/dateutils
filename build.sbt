import AssemblyKeys._ // put this at the top of the file

name := "dateutils"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.4",
  "org.joda" % "joda-convert" % "1.7"
)

assemblySettings

// remove unwanted dependencies
excludedJars in assembly <<= (fullClasspath in assembly) map { cp => 
  cp filter { l => Seq("scala-reflect-2.10.4.jar", "scala-library-2.10.4.jar", "scala-compiler-2.10.4.jar", "scalap-2.10.0.jar").contains(l.data.getName)}
}

run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run)) 

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

EclipseKeys.withSource := true

mergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf")          => MergeStrategy.discard
  case m if m.toLowerCase.matches("meta-inf.*\\.sf$")      => MergeStrategy.discard
  case "log4j.properties"                                  => MergeStrategy.discard
  case m if m.toLowerCase.startsWith("meta-inf/services/") => MergeStrategy.filterDistinctLines
  case "reference.conf"                                    => MergeStrategy.concat
  case _                                                   => MergeStrategy.first
}
