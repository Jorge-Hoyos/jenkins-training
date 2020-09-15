String scriptPath = 'dsl/own/scripts/aws-script.sh'
pipelinePath = 'training/dsl/my-pipelines/generated'

job ("${pipelinePath}") {
  steps {
    shell (readFileFromWorkspace(scriptPath))
  }
}
