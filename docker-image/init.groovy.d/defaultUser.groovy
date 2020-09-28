import jenkins.model.Jenkins
import hudson.security.GlobalMatrixAuthorizationStrategy
import hudson.security.HudsonPrivateSecurityRealm
import jenkins.security.s2m.AdminWhitelistRule
import jenkins.model.JenkinsLocationConfiguration

env = System.getenv()

jenkins = Jenkins.instance

if (!(jenkins.securityRealm.class.isAssignableFrom(HudsonPrivateSecurityRealm))) {
  jenkins.securityRealm = new HudsonPrivateSecurityRealm(false)
}

if (!(jenkins.authorizationStrategy.class.isAssignableFrom(GlobalMatrixAuthorizationStrategy))) {
  jenkins.authorizationStrategy = new GlobalMatrixAuthorizationStrategy()
}

// slave to master access control
Jenkins.instance.injector.getInstance(AdminWhitelistRule)
.masterKillSwitch = false

// Load Jenkins root URL
jlc = JenkinsLocationConfiguration.get()
jlc.url = "http://${env.MY_IP}:8080/"
println(jlc.url)
jlc.save()

user = jenkins.securityRealm.createAccount(env.JENKINS_USER, env.JENKINS_PASS)
user.save()
jenkins.authorizationStrategy.add(Jenkins.ADMINISTER, env.JENKINS_USER)

jenkins.save()
