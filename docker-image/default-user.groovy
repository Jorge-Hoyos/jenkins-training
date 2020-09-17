import jenkins.model.*
import hudson.security.*
import jenkins.security.s2m.AdminWhitelistRule

def env = System.getenv()

def jenkins = Jenkins.getInstance()
if(!(jenkins.getSecurityRealm() instanceof HudsonPrivateSecurityRealm))
  jenkins.setSecurityRealm(new HudsonPrivateSecurityRealm(false))

if(!(jenkins.getAuthorizationStrategy() instanceof GlobalMatrixAuthorizationStrategy))
  jenkins.setAuthorizationStrategy(new GlobalMatrixAuthorizationStrategy())

// slave to master access control
Jenkins.instance.getInjector().getInstance(AdminWhitelistRule.class)
.setMasterKillSwitch(false)

// Load Jenkins root URL
jlc = JenkinsLocationConfiguration.get()
jlc.setUrl("http://${env.MY_IP}:8080/")
println(jlc.getUrl())
jlc.save()

def user = jenkins.getSecurityRealm().createAccount(env.JENKINS_USER, env.JENKINS_PASS)
user.save()
jenkins.getAuthorizationStrategy().add(Jenkins.ADMINISTER, env.JENKINS_USER)

jenkins.save()
