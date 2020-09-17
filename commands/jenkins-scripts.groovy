Jenkins.instance.getAllItems(AbstractItem.class).each{
 println(it.fullName)
}

Jenkins.instance.pluginManager.plugins.each{
  plugin ->
    println ("${plugin.getDisplayName()} (${plugin.getShortName()}): ${plugin.getVersion()}")
}
