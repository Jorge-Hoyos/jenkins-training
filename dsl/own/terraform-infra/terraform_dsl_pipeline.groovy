String pipelinePath = 'training/dsl/my-pipelines/generated/terraform_pipeline'

job ("${pipelinePath}") {
  steps {
    shell ('terraform init')
  }
}
