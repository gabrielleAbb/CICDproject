pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME ="192474/group-service"
    }
    stages {
       
        stage('Build Docker Image') {
            when {
                branch 'main'
            }
            steps {
                echo 'build'
            }
        }
        stage('Push Docker Image') {
            when {
                branch 'main'
            }
            steps {
                 echo 'build'
        }
        stage('CanaryDeploy') {
            when {
                branch 'main'
            }
            environment { 
                CANARY_REPLICAS = 1
            }
            steps {
                echo 'build'
        }
        stage('DeployToProduction') {
            when {
                branch 'main'
            }
            environment { 
                CANARY_REPLICAS = 0
            }
            steps {
                 echo 'build'
            }
        }
    }
}
