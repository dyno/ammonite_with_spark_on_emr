import ammonite.ops._

// =============================================================================
// add emr jars and config dir to interp class path
//
def loadEmrJars() = {
  // /etc/zeppelin/conf/zeppelin-env.sh
  val libDirs = List( //
                     "/usr/lib/hadoop-lzo/lib",
                     "/usr/lib/spark/jars",
                     "/usr/share/aws/aws-java-sdk",
                     "/usr/share/aws/emr/emrfs/auxlib",
                     "/usr/share/aws/emr/emrfs/lib")
  val awsLibs = List( //
      "/usr/lib/hadoop/hadoop-aws.jar",
      "/usr/share/aws/hmclient/lib/aws-glue-datacatalog-spark-client.jar",
      "/usr/share/java/Hive-JSON-Serde/hive-openx-serde.jar"
      // /usr/share/aws/sagemaker-spark-sdk/lib/sagemaker-spark-sdk.jar
  )
  val confDirs = List( //
                      "/etc/hadoop/conf",
                      "/etc/spark/conf",
                      "/usr/share/aws/emr/emrfs/conf")

  libDirs.foreach { dir =>
    ls.rec ! Path(dir) |? { _.segments.last.endsWith(".jar") } |! { interp.load.cp(_) }
  }
  (awsLibs ++ confDirs).foreach { cp =>
    interp.load.cp(Path(cp))
  }
}

loadEmrJars

@  // http://ammonite.io/#Multi-stageScripts

// =============================================================================
// for hive query


// =============================================================================
import $ivy.`sh.almond::ammonite-spark:0.1.1+`
