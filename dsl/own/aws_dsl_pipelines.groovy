String scriptPath = 'dsl/own/scripts/aws-script.sh'
String folderPath = 'training/dsl/my-pipelines/generated'

folder (folderPath)

job ("${folderPath}/aws-pipeline") {
  steps {
    shell (readFileFromWorkspace(scriptPath))
  }
}
