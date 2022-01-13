pipeline {
    agent any
    stages {
        stage('Inicio'){
            steps{
                echo "Iniciando"
            } 
        }
        
 
     stage('SonarQube analysis') {
    def scannerHome = tool name: 'SonarScanner 4.6.0.2311';
    withSonarQubeEnv('trabajo2-back') { // If you have configured more than one global server connection, you can specify its name
      sh "${scannerHome}/bin/sonar-scanner"
    }
  }
}
}
//a
