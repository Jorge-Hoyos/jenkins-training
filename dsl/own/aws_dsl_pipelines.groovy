String scriptPath = 'dsl/own/scripts/aws-script.sh'
String folderPath = 'training/dsl/my-pipelines/generated'

folder (folderPath) {
  description ('folder for dsl generated pipelines')
}

job ("${folderPath}/aws-pipeline") {
  steps {
    shell (readFileFromWorkspace(scriptPath))
  }
}
