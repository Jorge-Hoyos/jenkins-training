String simpleFolderPath = 'training/shared-library/simple-pipelines'
String complexFolderPath = 'training/shared-library/complex-pipelines'
String repo = 'https://github.com/Jorge-Hoyos/jenkins-training.git'
String gitHubKey = 'persona-github-hey'

folder (simpleFolderPath)

folder (complexFolderPath)

pipelineJob ("${simpleFolderPath}/my_name_pipeline") {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url ("${repo}")
            credentials ("${gitHubKey}")
          }
          branches ('master')
        }
      }
      lightweight()
      scriptPath('shared-libraries-pipelines/simple-name-pipeline/Jenkinsfile')
    }
  }
}
