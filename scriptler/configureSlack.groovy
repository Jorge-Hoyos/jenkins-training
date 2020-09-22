import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.plugins.credentials.domains.*
import org.jenkinsci.plugins.plaincredentials.impl.*
import hudson.util.Secret

mySecret = Secret.fromString ('secreto')

secretText = new StringCredentialsImpl(CredentialsScope.GLOBAL, 'my secret', 'description', mySecret)
SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), secretText)
