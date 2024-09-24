pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Build your Docker image
                    bat 'docker build -t johannesliikanen/tempconverter_johannes:latest .'
                }
            }
        }

        stage('Push') {
            steps {
                script {
                    // Push the Docker image to Docker Hub
                    bat 'docker push johannesliikanen/tempconverter_johannes:latest'
                }
            }
        }
    }
}
