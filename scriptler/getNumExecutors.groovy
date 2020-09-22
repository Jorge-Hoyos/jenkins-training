import jenkins.model.*

env = System.getenv()
jenkins = Jenkins.getInstance()

println (jenkins.getNumExecutors())
