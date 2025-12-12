pipeline {
  agent { label 'Jenkins-Agent'}
  tools {
    jdk 'Java17'
    maven 'Maven3'
  }
  environment {
    APP_NAME = "mu-new"
    RELEASE = "1.0.0"
    DOCKER_USER = "prayutyencha"
    DOCKER_PASS = 'dockerhub'
    IMAGE_NAME = "${DOCKER_USER}" + "/" + "${DOCKER_USER}"
    IMAGE_TAG = "${RELEASE}" + "-" + "${BUILD_NUMBER}"
}
  stages{
    stage("Cleanup Workspace"){
      steps {
        cleanWs()
      }
    }

    stage("Checkout SCM"){
      steps {
        git branch: 'main', credentialsId: 'github', url: 'https://github.com/prayutyencha/mu-service.git'
      }
    }

    stage("Build Application"){
      steps {
        sh "mvn clean package"
      }
    }

    stage("Test Application"){
      steps {
        sh "mvn test"
      }
    }

    // stage("SonarQube Analysis"){
    //   steps {
    //           withSonarQubeEnv(installationName: 'sonarqube-server', credentialsId : 'jenkins-sonarqube-token') {
    //             sh 'mvn clean package sonar:sonar'
    //         }
    //      }
    //   }
    
    // stage("Quality Gate") {
    //         steps {
    //             script {
    //                 def qg = waitForQualityGate abortPipeline: false
    //                 echo "Quality Gate result: ${qg.status}"
    //             }
    //         }
    //     }

    stage("Build Push Docker") {
    steps{
        script {
            docker.withRegistry('', DOCKER_PASS) {
                        dockerImage = docker.build("${IMAGE_NAME}")
                    }
            docker.withRegistry('', DOCKER_PASS) {
                        dockerImage.push("${IMAGE_TAG}")
                        dockerImage.push("latest")
                    }
        }
    }
}
    
    
    }
}
