pipeline {
    agent any

    environment {
        DOCKERHUB_REPO = 'johannesliikanen/tempconverter'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/emotytto00/TempConverter.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-johannes',
                        usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {

                        // Try Docker login
                        bat 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'

                        // Push image to Docker Hub
                        docker.withRegistry('https://index.docker.io/v1/', '') {
                            docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                        }

                        // Logout after push
                        bat 'docker logout'
                    }
                }
            }
        }
    }
}
