String pipelinePath = 'training/dsl/my-pipelines/generated/slack-notificaction-pipeline'

job ("${pipelinePath}") {
  steps {
    shell ('echo algo')
  }
}