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
                        def scannerHome = tool 'SonarQube Scanner';
                    }
                withSonarQubeEnv('trabajo2-back') { // If you have configured more than one global server connection, you can specify its name
                    sh "${scannerHome}/bin/sonar-scanner"
                }
             }//a
        }
    }
}
