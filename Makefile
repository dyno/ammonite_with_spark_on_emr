SPARK_HOME := /usr/lib/spark
SPARK_CONF_DIR := /etc/spark/conf
SPARK_CONF_DEFAULTS=$(SPARK_CONF_DIR)/spark-defaults.conf

export SPARK_CONF_DEFAULTS
# SPARK_CONF_DEFAULTS is used by AmmoniteSparkSession
export SPARK_HOME SPARK_CONF_DIR

PATH := $(shell pwd)/bin:${PATH}
export PATH

## test drive with a simple spark sql query
test:
	source $(SPARK_CONF_DIR)/spark-env.sh && ./runner.sh ammSparkSql.sc

## spin up a ammonite shell
shell:
	source $(SPARK_CONF_DIR)/spark-env.sh && amm --predef predef.sc

## bootstrap steps
init:
	@ mkdir -p bin
	# https://github.com/coursier/coursier#command-line
	@ [ -f bin/coursier ] || curl -L -o bin/coursier https://git.io/vgvpD && chmod +x bin/coursier
