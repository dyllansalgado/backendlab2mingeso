pipeline {
    agent any
    stages {
        stage('Inicio'){
            steps{
                echo "Iniciando"
            } 
        }
        
 
        stage('SonarQube analysis') {
             steps{
                    
                withSonarQubeEnv('trabajo2-back') { // If you have configured more than one global server connection, you can specify its name
                    sh './gradlew sonarqube'
                }
             }

        }
    }
}
