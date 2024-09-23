pipeline {
    agent any // Use any available agent

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git repository
                git 'https://github.com/emotytto00/TempConverter.git'
            }
        }
        stage('Build Docker Image') {
            steps {
                // Build Docker image without pushing to Docker Hub
                script {
                    // Change 'your-image-name' to a name for your Docker image
                    def image = docker.build("https://github.com/emotytto00/TempConverter.git")
                }
            }
        }
    }
}

