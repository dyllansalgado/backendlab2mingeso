pipeline {
    agent any
    stages {
        stage('Inicio'){
            steps{
                echo "Iniciando"
            } 
        }
        
 
        stage('SonarQube Scanner') {
             steps{
                    script {
                        scannerHome = tool 'SonarScanner 2.8';
                    }
                withSonarQubeEnv('trabajo2-back') { // If you have configured more than one global server connection, you can specify its name
                    sh "${scannerHome}/bin/sonar-scanner"
                }
             }
        }
    }
}
