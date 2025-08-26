pipeline {
    agent any
    options {
        timestamps()
    }
    tools {
        jdk 'jdk-21'          // Debe coincidir con el nombre que configuraste en Jenkins
        maven 'Maven 3.9.11'     // Igual que en Global Tool Configuration
    }
    environment {
        // Ajusta con los datos de tu proyecto en SonarCloud
        SONAR_PROJECT_KEY = 'jose-devops-1_tarea_jenkins_sonar_dvop'        // Clave del proyecto que creaste en SonarCloud
        SONAR_ORGANIZATION = 'tarea-jenkins-sonar-devops-key'              // Nombre de tu organización en SonarCloud
    }
    stages {
        stage('Checkout') {
            steps {
                echo 'Clonando el repositorio...'
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
                echo 'Compilando el proyecto y ejecutando tests...'
                script {
                    if (isUnix()) {
                        sh 'mvn -B clean verify'
                    } else {
                        bat 'mvn -B clean verify'
                    }
                }
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'   // Publica los resultados de test
                }
            }
        }
        stage('SonarCloud Analysis') {
            steps {
                echo 'Ejecutando análisis en SonarCloud...'
                withSonarQubeEnv('SonarCloud') {  // Nombre que diste al configurar el servidor en Jenkins
                    script {
                        def sonarCmd = "mvn sonar:sonar " +
                            "-Dsonar.projectKey=${env.SONAR_PROJECT_KEY} " +
                            "-Dsonar.organization=${env.SONAR_ORGANIZATION} " +
                            "-Dsonar.host.url=https://sonarcloud.io " +
                            "-Dsonar.login=${SONAR_AUTH_TOKEN}"
                        if (isUnix()) {
                            sh sonarCmd
                        } else {
                            bat sonarCmd
                        }
                    }
                }
            }
        }
        stage('Quality Gate') {
            steps {
                echo 'Esperando resultado del Quality Gate...'
                timeout(time: 10, unit: 'MINUTES') {
                    script {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Análisis falló. Estado del Quality Gate: ${qg.status}"
                        }
                    }
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t laboratorio-final-devops:1.0 .'
            }
        }
        stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 8081:8081 --name laboratorio-final-devops:1.0'
             }
        }
    }
}
