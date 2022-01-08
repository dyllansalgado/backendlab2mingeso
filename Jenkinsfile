pipeline {
    agent any
    stages {
        stage('Inicio'){
            steps{
                echo "Iniciando"
            } 
        }



    stage('Parar imagen anterior'){

                steps{

            dir("/var/lib/jenkins/workspace/BackendMingeso/Private-Services"){
                sh 'docker stop backend  true && docker rm backend  true'
            }


                }
        }
        stage('Contruir imagen docker'){

                steps{
                dir("/var/lib/jenkins/workspace/BackendMingeso/Private-Services"){
                         sh 'docker build -t backend .'
                 }
                }
        }
    stage('Correr imagen'){
                steps{
                dir("/var/lib/jenkins/workspace/BackendMingeso/Private-Services"){
                sh 'docker run --rm --name backend -d -p 8000:8000  --network host backend:latest'
                 }
                }
        }
    stage('Subir imagen docker a hub'){
                steps{
            sh 'docker tag backend dyllansalgado/backendmingeso:latest'
            sh 'docker push dyllansalgado/backendmingeso:latest'
                }
        }

        stage('Fin'){
                steps{
                    echo "Terminado"
                } 
            }

        }
}
