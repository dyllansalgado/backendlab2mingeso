pipeline {
    agent any
    stages {
        stage('Inicio'){
            steps{
                echo "Iniciando"
            } 
        }
        
 
        stage('SonarQube Gradle') {
            steps {
				dir("/var/lib/jenkins/workspace/T2-BackEnd/backend") {
					withSonarQubeEnv('trabajo2-back') { // Will pick the global server connection you have configured
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube'
    					}
				}
			}
        }//a
        
    }
}
