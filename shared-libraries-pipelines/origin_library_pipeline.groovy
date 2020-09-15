String simpleFolderPath = 'training/shared-library/simple-pipelines'
String complexFolderPath = 'training/shared-library/complex-pipelines'
String repo = 'https://github.com/Jorge-Hoyos/jenkins-training.git'
String gitHubKey = 'persona-github-hey'

folder (simpleFolderPath)

folder (complexFolderPath)

job ("${simpleFolderPath}/name_name") {
  definition {
    cpScm {
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
      scriptPath('simple-pipes/pipe-as-code/Jenkinsfile')
    }
  }
}
