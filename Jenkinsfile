pipeline {
    agent any

    environment {
        dockerImage = ''
    }

    stages {

        stage('Build image') {
            steps {
                script {
                    dockerImage = docker.build("champyevil/demo-spring-boot")
                }
            }
        }
        stage('Push image') {
            steps {
                script {
                    withDockerRegistry(
                        credentialsId: 'docker-credential',
                        url: 'https://index.docker.io/v1/') {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deployment') {
            steps {
                sh 'kubectl apply -f deployment.yml';
            }
        }
    }
}