String scriptPath = 'dsl/own/scripts/aws-script.sh'

job ('aws-pipeline') {
  steps {
    shell (readFileFromWorkspace(scriptPath))
  }
}
