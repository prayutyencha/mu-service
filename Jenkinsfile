pipeline {
  agent { label 'Jenkins-Agent'}
  tools {
    jdk 'Java17'
    maven 'Maven3'
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

    stage("SonarQube Analysis"){
      steps {
              withSonarQubeEnv(installationName: 'sonarqube-server', credentialsId : 'jenkins-sonarqube-token') {
                sh 'mvn clean package sonar:sonar'
            }
         }
      }
    
    stage("Quality Gate") {
            steps {
                script {
                    def qg = waitForQualityGate abortPipeline: false
                    echo "Quality Gate result: ${qg.status}"
                }
            }
        }
    
    }
}
