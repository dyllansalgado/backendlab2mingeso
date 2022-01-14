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

        //Docker

        stage('Parar la imagen anterior'){
            steps{
                dir("/var/lib/jenkins/Dir"){
				    sh 'docker stop backend || true && docker rm backend || true'	
			    }
            }             
        }

        stage('Contruir imagen docker'){
            steps{
        		dir("/var/lib/jenkins/Dir"){
                 	sh 'docker build -t backend .'	
	         	}
            }             
        }
	    stage('Correr imagen'){
            steps{
        		dir("/var/lib/jenkins/Dir"){
				    sh 'docker run --rm --name backend -d -p 8000:8000 backend'
	         	}
            }             
        }
	    stage('Subir imagen docker a hub'){
                steps{
			        sh 'docker tag backend miige/backend:latest'	
			        sh 'docker push miige/backend:latest'
                }             
        }
    }

}
