pipeline {
    agent any
     environment {
		DOCKERHUB_CREDENTIALS=credentials('dockerhub')
	}
    stages {
        
        stage('Inicio'){
            steps{
                echo "Iniciando"
            } 
        }
 
        /// SonarQube Listo.
        /*stage('SonarQube Gradle') {
            steps {
                dir("/var/lib/jenkins/workspace/backend/backend") {
                    withSonarQubeEnv('trabajo2-back') {
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube'
    				}
				}
			}
        }*/

        // JUnit Listo.
        stage('JUnit'){
			steps {
				dir("/var/lib/jenkins/workspace/backend/backend/build/test-results/test") {
					sh 'touch prueba.xml'
					sh 'rm *.xml'
				}
				catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    dir("/var/lib/jenkins/workspace/backend/backend") {
                        sh 'chmod +x ./gradlew'
                        sh './gradlew test'
					}
                }
				dir("/var/lib/jenkins/workspace/backend/backend/build/test-results/test") {
					junit '*.xml'
				}
			}
		}

        //Docker

        stage('Parar la imagen anterior'){
            steps{
                dir("/var/lib/jenkins/workspace/backend/backend"){
				    sh 'docker stop postgrestprueba || true && docker rm postgrestprueba || true'	
			    }
                dir("/var/lib/jenkins/workspace/backend/basededatos"){
                    sh 'docker stop backendprueba || true && docker rm backendprueba || true'
                }
            }             
        }

        stage('Contruir imagen docker'){
            steps{
        		dir("/var/lib/jenkins/workspace/backend/backend"){
                 	sh 'docker build . -t backend'
                    	
	         	}
                dir("/var/lib/jenkins/workspace/backend/basededatos"){
                    sh 'docker build . -t postgrest2'
                    
                    // Correr los contenedores en segundo plano.
                    sh 'docker-compose up -d'
                }
            }             
        }
        stage('Login') {

                steps {
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                }
            }

        // Subida de las images a Docker Hub.    
        stage('Subir imagen docker a hub'){
                    steps{
                        sh 'docker tag backend miige/backend:latest'
                        sh 'docker tag postgrest2 miige/postgrest2:latest'

                        sh 'docker push miige/backend:latest'
                        sh 'docker push miige/postgrest2:latest'
                    }             
            }
    }

}
