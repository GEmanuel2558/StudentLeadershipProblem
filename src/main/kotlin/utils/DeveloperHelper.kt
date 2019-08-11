package utils

object DeveloperHelper {

    val isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().inputArguments.toString().indexOf("-agentlib:jdwp") > 0

}