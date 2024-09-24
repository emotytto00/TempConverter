pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Build your Docker image
                    bat 'docker build -t johannesliikanen/tempconverter:latest .'
                }
            }
        }

        stage('Push') {
            steps {
                script {
                    // Tag the image (if necessary)
                    bat 'docker tag johannesliikanen/tempconverter:latest johannesliikanen/tempconverter:v1.0'

                    // Push the Docker image to Docker Hub
                    bat 'docker push johannesliikanen/tempconverter:v1.0'
                }
            }
        }
    }
}
