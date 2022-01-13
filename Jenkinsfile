pipeline {
    agent any
    stages {
        
        stage('Inicio'){
            steps{
                echo "Iniciando"
            } 
        }

        // SonarQube Listo.
        /* stage('SonarQube Gradle') {
            steps {
                dir("/var/lib/jenkins/workspace/T2-BackEnd/backend") {
                    withSonarQubeEnv('trabajo2-back') {
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube'
    				}
				}
			}
        } */

        // JUnit Listo.
        /* stage('JUnit'){
			steps {
				dir("/var/lib/jenkins/workspace/T2-BackEnd/backend/build/test-results/test") {
					sh 'touch prueba.xml'
					sh 'rm *.xml'
				}
				catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    dir("/var/lib/jenkins/workspace/T2-BackEnd/backend") {
                        sh 'chmod +x ./gradlew'
                        sh './gradlew test'
					}
                }
				dir("/var/lib/jenkins/workspace/T2-BackEnd/backend/build/test-results/test") {
					junit '*.xml'
				}
			}
		} */

        //
    }
}
