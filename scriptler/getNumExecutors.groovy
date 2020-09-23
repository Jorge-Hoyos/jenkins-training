import jenkins.model.*

env = System.getenv()
jenkins = Jenkins.instance

println (jenkins.getNumExecutors())
