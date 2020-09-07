String myFolder = 'projects'
String folderA = 'project-a'

folder (myFolder) {
  displayName (myFolder)
  description ('folder for all projects')
}

folder ('projects/project-a') {
  displayName (folderA)
  description ('folder for project a')
}

