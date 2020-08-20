pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }
    agent any
    tools {
        maven 'maven3'
        jdk 'jdk11'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
               echo 'Building ... '
               sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test'){
                    steps {
                      echo 'Testing ... '
                        sh 'mvn test'
                        junit 'target/surefire-reports/*.xml'
                    }
                }
    }
}
