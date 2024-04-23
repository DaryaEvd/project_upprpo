pipeline {
    agent any
  
tools {
    maven 'maven'
    jdk 'my_java19'
}
    stages {
    stage("build") {
        steps {
             sh 'mvn -f pseudo_scene/pom.xml clean'
        }
    }   
    
    stage("test") {
        steps {
             sh 'mvn -f pseudo_scene/pom.xml install'
        }
    }

        stage('Build Docker Image') {
            steps {
                script {
                    // Define the Dockerfile location
                    def dockerfilePath = 'Dockerfile'
            
                    // Build the Docker image using the Dockerfile
                    def dockerImage = docker.build('maven:3.9.6-eclipse-temurin-17-alpine', '-f ' + dockerfilePath + ' .')
                  
                    def imageName = 'maven:3.9.6-eclipse-temurin-17-alpine' 
                    def validImageName = imageName.replaceAll(/[^a-zA-Z0-9_-]/, '-') // Replace invalid characters with hyphens
                    dockerImage.tag(validImageName)
                    dockerImage.push('daryaevd/' + validImageName)
                }
            }
        }
    }

    post {
        success {
            echo 'Docker image built successfully'
        }
        failure {
            echo 'Failed to build Docker image'
        }
    }
}
