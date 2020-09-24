import jenkins.model.Jenkins

env = System.getenv()
jenkins = Jenkins.instance

println (jenkins.numExecutors)
