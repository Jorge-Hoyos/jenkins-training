String myFolder = 'projects'
String folderA = 'project-a'
String folderB = 'project-b'

folder (myFolder) {
  displayName (myFolder)
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
