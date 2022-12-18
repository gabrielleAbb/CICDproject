pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME ="192474/group-service"
    }
    stages {
       
        stage('Build') {
            when {
                branch 'main'
            }
            steps {
                script {
                    app = docker.build(DOCKER_IMAGE_NAME)
                }
            }
        }
        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_hub_login') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
        stage('CanaryDeploy') {
            when {
                branch 'main'
            }
            environment { 
                CANARY_REPLICAS = 1
            }
            steps {
                kubernetesDeploy(
                   // kubeconfigId: 'kubeconfig',
                   // configs: 'CICD.yml',
                   // enableConfigSubstitution: true
                )
            }
        }
        stage('DeployToProduction') {
            when {
                branch 'main'
            }
            environment { 
                CANARY_REPLICAS = 0
            }
            steps {
                input 'Deploy to Production?'
                milestone(1)
                kubernetesDeploy(
                  //  kubeconfigId: 'kubeconfig',
                   // configs: 'CICD.yml',
                   // enableConfigSubstitution: true
                )
                kubernetesDeploy(
                   // kubeconfigId: 'kubeconfig',
                    // configs: 'CICD.yml',
                    enableConfigSubstitution: true
                )
            }
        }
    }
}
