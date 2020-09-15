String scriptPath = 'dsl/own/scripts/aws-script.sh'
String folderPath = 'training/dsl/my-pipelines/generated'

folder ('training/dsl/my-pipelines/generated')

job ("${folderPath}/aws-pipeline") {
  steps {
    shell (readFileFromWorkspace(scriptPath))
  }
}
