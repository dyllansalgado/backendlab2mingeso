pipeline {
    agent any
    stages {
        stage('Inicio'){
            steps{
                echo "Iniciando"
            } 
        }
        
 
        stage('SonarQube Gradle') {
            steps{    
                withSonarQubeEnv('trabajo2-back') { // Will pick the global server connection you have configured
                sh './gradlew sonarqube'
                }
            }
        }//a
        
    }
}
