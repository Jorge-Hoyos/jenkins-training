import com.cloudbees.plugins.credentials.SystemCredentialsProvider
import com.cloudbees.plugins.credentials.CredentialsScope
import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl
import com.cloudbees.plugins.credentials.domains.Domain
import org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl
import hudson.util.Secret

// Crea una implementacion de SystemCredentialsProvider.instance.store
systemCredentials = SystemCredentialsProvider.instance.store
// Crea una implementacion de la clase UsernamePasswordCredentialsImpl
userPsswdCredential = new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL, UUID.randomUUID().toString(), 'my usr pwd description', 'user', 'password')
// Agrega la implementacion de la clase systemCredentials
systemCredentials.addCredentials(Domain.global(), userPsswdCredential)

mySecret = Secret.fromString ('secreto')

secretText = new StringCredentialsImpl(CredentialsScope.GLOBAL, 'my secret text', 'my description', mySecret)
systemCredentials.addCredentials(Domain.global(), secretText)
