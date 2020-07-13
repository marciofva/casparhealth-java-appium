pipeline {
   agent any

   stages {
      stage('Start Appium Server') {
        steps {
          echo 'Start Appium...'
          echo "Running ${env.BUILD_ID}"
          build job: 'Start-Appium-Server'
        }
   }
      stage('Start Emulador') {
        steps {
          echo 'Start Emulador...'
          build job: 'Start Android Emulador'
     }
   }
   stage('Regression Tests') {
     steps {
       echo 'Regression Tests...'
       build 'Run Tests'
     }
   }
  }
}