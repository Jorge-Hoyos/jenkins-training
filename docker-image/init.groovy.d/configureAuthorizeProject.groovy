import jenkins.model.Jenkins
import org.jenkinsci.plugins.authorizeproject.strategy.AnonymousAuthorizationStrategy
import org.jenkinsci.plugins.authorizeproject.strategy.TriggeringUsersAuthorizationStrategy
import org.jenkinsci.plugins.authorizeproject.strategy.SpecificUsersAuthorizationStrategy
import org.jenkinsci.plugins.authorizeproject.strategy.SystemAuthorizationStrategy
import org.jenkinsci.plugins.authorizeproject.ProjectQueueItemAuthenticator
import jenkins.security.QueueItemAuthenticatorConfiguration

instance = Jenkins.instance

// Define which strategies you want to allow to be set per project
strategyMap = [
  (instance.getDescriptor(AnonymousAuthorizationStrategy).id): true,
  (instance.getDescriptor(TriggeringUsersAuthorizationStrategy).id): true,
  (instance.getDescriptor(SpecificUsersAuthorizationStrategy).id): true,
  (instance.getDescriptor(SystemAuthorizationStrategy).id): false,
]

authenticators = QueueItemAuthenticatorConfiguration.get().authenticators
configureProjectAuthenticator = true
for (authenticator in authenticators) {
  if (authenticator.class.isAssignableFrom(ProjectQueueItemAuthenticator)) {
    // only add if it does not already exist
    configureProjectAuthenticator = false
  }
}

if (configureProjectAuthenticator) {
  authenticators.add(new ProjectQueueItemAuthenticator(strategyMap))
}

instance.save()
