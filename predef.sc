/**
  * ## Local Repositories ##
  *
  * https://github.com/lihaoyi/Ammonite/pull/612, Resolution of local Maven artefacts does not work
  */
import coursier.MavenRepository

val mavenRepoLocal = MavenRepository("file://" + System.getProperties.get("user.home") + "/.m2/repository")
interp.repositories() ++= Seq(mavenRepoLocal)

@  // http://ammonite.io/#Multi-stageScripts

import $exec.emr
import $exec.shell
