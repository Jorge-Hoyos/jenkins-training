String scriptPath = 'dsl/own/scripts/aws-script.sh'
pipelinePath = 'training/dsl/my-pipelines/generated'

job ('aws-pipeline') {
  steps {
    shell (readFileFromWorkspace(scriptPath))
  }
}
