import com.cloudbees.plugins.credentials.SystemCredentialsProvider
import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.CredentialsScope
import org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl
import jenkins.plugins.slack.SlackNotifier
import hudson.util.Secret

mySecret = Secret.fromString ('0nIpuQNhF3LP6J5BJIJ6GeMX')
secretId = 'slackSecret'
slackDomain = 'globant'

secretText = new StringCredentialsImpl(CredentialsScope.GLOBAL, secretId, 'secret to slack', mySecret)
SystemCredentialsProvider.instance.store.addCredentials(Domain.global(), secretText)

slackBuilder = SlackNotifier.builder()
slackNotifier = slackBuilder.build()

slackDescriptor = slackNotifier.descriptor
slackDescriptor.teamDomain = slackDomain
slackDescriptor.tokenCredentialId = secretId
println (slackDescriptor.teamDomain)

slackDescriptor.save()
