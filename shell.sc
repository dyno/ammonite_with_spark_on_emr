// ## Ammonite Shell ##
// http://ammonite.io/#Ammonite-Shell
// https://git.io/vHaKQ
interp.load.ivy(
    "com.lihaoyi" % s"ammonite-shell_${scala.util.Properties.versionNumberString}" % ammonite.Constants.version
)

@ // http://ammonite.io/#Multi-stageScripts

val shellSession = ammonite.shell.ShellSession()
import shellSession._

import ammonite.ops._
import ammonite.shell._
// ammonite.shell.Configure(interp, repl, wd)
