import com.cloudbees.plugins.credentials.SystemCredentialsProvider
import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.CredentialsScope
import org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl
import jenkins.plugins.slack.SlackNotifier
import hudson.util.Secret

env = System.getenv()
slackSecretValue = env['SLACK_SECRET']
slackSecretDescription = env['SLACK_DESCRIPTION']

mySecret = Secret.fromString (slackSecretValue)
secretId = 'slackSecret'
slackDomain = 'globant'

secretText = new StringCredentialsImpl(CredentialsScope.GLOBAL, secretId, slackSecretDescription, mySecret)
SystemCredentialsProvider.instance.store.addCredentials(Domain.global(), secretText)

slackBuilder = SlackNotifier.builder()
slackNotifier = slackBuilder.build()

slackDescriptor = slackNotifier.descriptor
slackDescriptor.teamDomain = slackDomain
slackDescriptor.tokenCredentialId = secretId
println (slackDescriptor.teamDomain)

slackDescriptor.save()
