import jenkins.model.JenkinsLocationConfiguration

jlc = JenkinsLocationConfiguration.get()
println(jlc.url)
jlc.save()
