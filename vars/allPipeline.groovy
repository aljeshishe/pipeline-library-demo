def call(branch) {
  //def pipelineParams= [:]
  //body.resolveStrategy = Closure.DELEGATE_FIRST
  //body.delegate = pipelineParams
  //body()
  echo "${branch}"
  pipeline {
    agent any

    stages {
      stage('Checkout') {
        steps {
          echo sh(returnStdout: true, script: 'env|sort')
        }
      }
      stage('Build') {
        steps {
          script {
            sh '''
              docker version
              docker build -t ealebed/hellonode:latest .
              docker image ls
            '''
          }
        }
      }
    }
  }
}