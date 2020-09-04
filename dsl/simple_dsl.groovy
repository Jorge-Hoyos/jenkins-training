job('training/dsl/first_created_dsl_job_from_scm'){
  // triggers{
  //   upstream ('dsl_pipeline_git_code', 'SUCCESS')
  // }
  steps {
    shell('echo hello world!')
    shell('echo hello world! number 2')
  }
}
