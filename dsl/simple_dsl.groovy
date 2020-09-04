job('training/dsl/first_created_dsl_job_from_scm'){
  stages{
    stage('first'){
      steps {
        shell('echo hello world!')
      }
    }
  }
}
