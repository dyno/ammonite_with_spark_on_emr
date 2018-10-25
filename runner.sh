#!/bin/bash

# We need this runner wrapper because if we run amm in script mode
# repl is not available which is needed by AmmoniteSparkSession.

script=$1

module_name=${script%.*}
amm --predef predef.sc <<EOF
import \$exec.${module_name}
EOF
