docker pull jenkins/jenkins:lts
docker build -t jorge:latest .
docker run -p 8080:8080 -d --name jorge -u root -e JENKINS_VERSION:-2.249.1 --mount source=jenkins_data,target=/var/jenkins_home jorge:latest
docker run -p 8080:8080 -d --name jenkins -u root --mount source=jenkins_data,target=/var/jenkins_home jenkins/jenkins:lts
docker volume list
docker exec jenkins_server cat /var/jenkins_home/secrets/initialAdminPassword


#sync data from bucket to docker volume
aws s3 sync s3://jenkins-s3-data /var/lib/docker/volumes/jenkins_data/_data

#sync data from docker volume to bucket
aws s3 sync /var/lib/docker/volumes/jenkins_data/_data s3://jenkins-s3-data
