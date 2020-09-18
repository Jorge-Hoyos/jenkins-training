import jenkins.model.*

jlc = JenkinsLocationConfiguration.get()
println(jlc.getUrl())
jlc.save()
