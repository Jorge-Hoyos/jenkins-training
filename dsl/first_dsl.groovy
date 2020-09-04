pipelineJob('training/dsl/generated_job_from_dsl'){
  definition {
    cpsScm{
      scm{
        git{
          remote{
            url ('https://github.com/Jorge-Hoyos/jenkins-training.git')
            credentials ('persona-github-hey')
          }
          branch('*/master')
        }
        lightweight()
        scriptPath('simple-pipes/pipe-as-code/Jenkinsfile')
      }
    }
  }
}
