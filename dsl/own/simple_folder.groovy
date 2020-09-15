String myFolder = 'training/projects'
String folderA = 'project-a'
String folderB = 'project-b'
String generatedFolderPath = 'training/dsl/my-pipelines/generated'

folder (generatedFolderPath) {
  description ('folder for dsl generated pipelines')
}

folder (myFolder) {
  description ('folder for all projects')
}

folder ("${myFolder}/${folderA}") {
  displayName (folderA)
  description ('folder for project a')
}
folder ("${myFolder}/${folderB}") {
  displayName (folderB)
  description ('folder for project b')
}

// folder ('other')
