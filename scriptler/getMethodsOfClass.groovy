import com.cloudbees.plugins.credentials.SystemCredentialsProvider

println (SystemCredentialsProvider)
methods = SystemCredentialsProvider.methods

for (method in methods) {
  println (method.name)
  println (method)
}
