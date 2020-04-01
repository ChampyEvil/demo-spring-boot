pipeline {
    agent any

    environment {
        dockerImage = ''
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
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
                script {
                    //withCredentials([sshUserPrivateKey(credentialsId: 'champypokemon123', keyFileVariable: 'id_rsa', passphraseVariable: '', usernameVariable: 'champypokemon123')]) {
                        sh 'ls -a'
                        sh 'ssh -i /~/.ssh/id_rsa champypokemon123@35.184.174.229';
                        sh 'docker pull champyevil/demo-spring-boot';
                        sh 'docker-compose down';
                        sh 'docker-compose up -d';
                        sh 'exit';
                    //}
                }
            }
        }
    }
}