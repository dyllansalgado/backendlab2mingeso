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
						sh 	'./gradlew sonarqube \
  							-Dsonar.projectKey=trabajo2 \
  							-Dsonar.host.url=http://ec2-18-156-73-207.eu-central-1.compute.amazonaws.com:9000 \
  							-Dsonar.login=3431d7a46b79bce163c588a5f9917bebf1da1283'
    					}
				}
			}
        }
        
    }
}
