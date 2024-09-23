pipeline {
    agent any

    environment {
        // DockerHub repository and image tag
        DOCKERHUB_REPO = 'johannesliikanen/tempconverter'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub repository
                git 'https://github.com/emotytto00/TempConverter.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build the Docker image
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    // Use Jenkins credentials to log in to Docker Hub
                    withCredentials([usernamePassword(credentialsId: 'dockerhub_johannes',
                        usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {

                        // Log in to Docker Hub using Jenkins credentials
                        sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'

                        // Push the Docker image to Docker Hub
                        docker.withRegistry('https://index.docker.io/v1/', '') {
                            docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                        }

                        // Log out from Docker Hub
                        sh 'docker logout'
                    }
                }
            }
        }
    }
}

