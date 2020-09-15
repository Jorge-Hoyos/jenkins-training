String pipelinePath = 'training/dsl/my-pipelines/generated/slack-notificaction-pipeline'

job ("${pipelinePath}") {
  steps {
    shell ('echo algo')
  }
  publishers {
    jenkins.plugins.slack.SlackNotifier (plugin = 'slack@2.42') {
      startNotification(true)
      notifySuccess(true)
      notifyAborted(true)
      notifyNotBuilt(true)
      notifyUnstable(true)
      notifyRegression(true)
      notifyFailure(false)
      notifyEveryFailure(true)
      notifyBackToNormal(true)
      notifyRepeatedFailure(false)
      includeTestSummary(false)
      includeFailedTests(false)
      uploadFiles(false)
      commitInfoChoice('NONE')
      includeCustomMessage(false)
    }
  }
}
