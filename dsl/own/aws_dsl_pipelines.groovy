String scriptPath = 'dsl/own/scripts/aws-script.sh'
String pipelinePath = 'training/dsl/my-pipelines/generated/aws-pipeline'

job ("${pipelinePath}") {
  steps {
    shell (readFileFromWorkspace(scriptPath))
  }
}
