import org.apache.spark.sql.AmmoniteSparkSession

// some are already set in spark-defaults.conf, just make them explicit here.
val spark = AmmoniteSparkSession.builder()
  .config("spark.home", sys.env.get("SPARK_HOME").getOrElse("/usr/lib/spark"))
  .config("spark.master", "yarn")
  .config("spark.submit.deployMode", "client")
  //
  .config("spark.logConf", "true")
  .config("spark.executor.instances", "2")
  .config("spark.executor.memory", "4g")
  //
  //.enableHiveSupport()
  .getOrCreate()

val sc = spark.sparkContext

sc.getConf.get("spark.jars").split(",").foreach(println)

// hive/hudi support
// https://uber.github.io/hudi/sql_queries.html
// https://issues.apache.org/jira/browse/SPARK-19351
//sc.hadoopConfiguration
//  .setClass("mapreduce.input.pathFilter.class",
//            classOf[com.uber.hoodie.hadoop.HoodieROTablePathFilter],
//            classOf[org.apache.hadoop.fs.PathFilter])

val r2 = sc.parallelize(1 to 5).map(_ * 10).collect
println(s"Spark r2: ${r2.toList}")
assert(r2.toList == List(10, 20, 30, 40, 50))

spark.stop()
