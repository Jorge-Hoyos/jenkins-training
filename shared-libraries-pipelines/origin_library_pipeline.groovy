String simpleFolderPath = 'training/shared-library/simple-pipelines'
String complexFolderPath = 'training/shared-library/complex-pipelines'
String repo = 'https://github.com/Jorge-Hoyos/jenkins-training.git'
String gitHubKey = 'persona-github-hey'
String branch = 'master'

folder (simpleFolderPath)

folder (complexFolderPath)

pipelineJob ("${simpleFolderPath}/my_name_pipeline_step") {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url ("${repo}")
            credentials ("${gitHubKey}")
          }
          branches ("${branch}")
        }
      }
      lightweight()
      scriptPath('shared-libraries-pipelines/simple-name-pipeline/Jenkinsfile')
    }
  }
}

pipelineJob ("${complexFolderPath}/my_name_pipeline") {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url ("${repo}")
            credentials ("${gitHubKey}")
          }
          branches ("${branch}")
        }
      }
      lightweight()
      scriptPath('shared-libraries-pipelines/complex-pipelines/Jenkinsfile')
    }
  }
}
