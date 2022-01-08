pipeline {
    agent any
    stages {
        stage('Inicio'){
            steps{
                echo "Iniciando"
            } 
        }


        stage('Contruir imagen docker'){

                steps{
                dir("/var/lib/jenkins/workspace/BackendMingeso/backend/"){
                         sh 'gradle bootrun'
                           
                 }
                }
        }

        stage('Fin'){
                steps{
                    echo "Terminado"
                } 
            }

        }
}
