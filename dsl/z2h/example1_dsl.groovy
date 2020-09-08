String basePath = 'training/dsl/zero-2-hero-examples/example1'
String repo = 'https://github.com/Jorge-Hoyos/jenkins-training.git'
String gitHubKey = 'persona-github-hey'

folder (basePath) {
  description 'This example creates a simple folder and job as code'
}

job ("${basePath}/example1-build") {
  scm {
    git {
      remote {
        url ("${repo}")
        credentials ("${gitHubKey}")
      }
      branches ('master')
    }
  }
  triggers {
    scm 'H/5 * * * *'
  }
  steps {
    shell 'echo "assemble..."'
  }
}

job("${basePath}/example1-deploy") {
  parameters {
    stringParam 'host'
  }
  steps {
    shell 'echo "deplying..."'
  }
}
