pipeline {
    agent any
    stages {
        
        stage('Inicio'){
            steps{
                echo "Iniciando"
            } 
        }

        // SonarQube Listo.
        stage('SonarQube Gradle') {
            steps {
                dir("/var/lib/jenkins/workspace/T2-BackEnd/backend") {
                    withSonarQubeEnv('trabajo2-back') {
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube \
  							-Dsonar.projectKey=t2-backend \
                            -Dsonar.host.url=http://ec2-3-70-187-29.eu-central-1.compute.amazonaws.com:9000 \
                            -Dsonar.login=c975fd6a194140334018e0606be4546a0bff9926'
    				}
				}
			}
        }

        // JUnit Listo.
        stage('JUnit'){
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
		}

        //
    }
}
