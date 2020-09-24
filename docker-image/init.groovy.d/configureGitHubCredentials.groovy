import com.cloudbees.plugins.credentials.SystemCredentialsProvider
import com.cloudbees.plugins.credentials.CredentialsScope
import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl

gitHubUserName = 'jorge-hoyos'
gitHubPassword = env['SLACK_PASSWORD']
gitHubId = 'GitHub'
gitHubDescription = 'Personal Github access key'

gitHubCredential = new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL , gitHubId, gitHubDescription, gitHubUserName, gitHubPassword)

SystemCredentialsProvider.instance.store.addCredentials(Domain.global(), gitHubCredential)
