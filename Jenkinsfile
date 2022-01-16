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
        /* stage('SonarQube Gradle') {
            steps {
                dir("/var/lib/jenkins/workspace/backend/backend") {
                    withSonarQubeEnv('trabajo2-back') {
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube'
    				}
				}
			}
        }

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
		} */

        //Docker

        stage('Parar la imagen anterior'){
            steps{
                dir("/var/lib/jenkins/workspace/backend/backend"){
				    sh 'docker stop backend || true && docker rm backend || true'	
			    }
                dir("/var/lib/jenkins/workspace/backend/basededatos"){
                    sh 'docker stop postgrest2 || true && docker rm postgrest2 || true'
                }
            }             
        }

        stage('Contruir imagen docker'){
            steps{
                dir("/var/lib/jenkins/workspace/backend/basededatos"){
                    sh 'docker build . -t postgrest2'
                }
        		dir("/var/lib/jenkins/workspace/backend/backend"){
                 	sh 'docker build . -t backend'
                    sh 'docker-compose up -d'	
	         	}
            }             
        }
	stage('Correr imagen'){
                steps{
        		    dir("/var/lib/jenkins/workspace/backend/backend"){
                        sh 'docker run --rm --name postgrest2 -d -p 5432:5432 postgrest2'
				        sh 'docker run --rm --name backend -d -p 8000:8000 backend'
	         	}
            }             
        }
	stage('Login') {

            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
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
