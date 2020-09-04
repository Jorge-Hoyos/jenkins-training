job('JobAsCode/first_created_dsl_job_from_scm'){
  steps {
    shell('echo hello world!')
  }
}