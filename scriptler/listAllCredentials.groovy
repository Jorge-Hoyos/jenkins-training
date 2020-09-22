import com.cloudbees.plugins.credentials.SystemCredentialsProvider
import com.cloudbees.plugins.credentials.domains.Domain

systemCredentials = SystemCredentialsProvider.instance.store
// Set to true if you want to delete all credential
deleteCredentials = true

allCredentials = systemCredentials.getCredentials (Domain.global())
for (credential in allCredentials) {
  print ("Credential id: ${credential.id}, ")
  if (credential.class.name == 'com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl') {
    print ("password: ${credential.password}\n")
  } else {
    print ("secret: ${credential.secret}\n")
  }
  if (deleteCredentials) {
    systemCredentials.removeCredentials(Domain.global(), credential)
  }
}
