pipeline {
    agent {
        label "jenkinsRn02"
    }
	tools {
        maven "maven-3.6.3"
    }
    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "nexus.wisefly.cn"
        NEXUS_REPOSITORY = "jar-products"
        NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
    }
    stages {
        stage("Clone code from VCS") {
            steps {
                script {
                    checkout([$class: 'GitSCM', branches: [[name: '$gitlab_code_branch']],
                    browser: [$class: 'GitLab', repoUrl: 'http://gitlab.wisefly.cn/RnDII/wisefly-workflow.git'],
                    extensions: [],
                    userRemoteConfigs: [[credentialsId: '8f97adba-6f59-4c13-b778-60117a99b05d', url: 'http://gitlab.wisefly.cn/RnDII/wisefly-workflow.git']]])
                }
            }
        }
        stage("Maven Build") {
            steps {
                script {
                    sh  '''source /etc/profile
                        mvn clean package -DskipTests'''
                }
            }
        }

        stage("Copy files to the production environment") {
            steps {
                ansiblePlaybook (
                    playbook: "${env.WORKSPACE}/push.yaml",
                )
            }
        }


        stage('Bulid docker') {
            steps{
                script {
                    sh  '''
                        docker build -t $jenkins_project_name:$docker_images_version .
                        docker tag $jenkins_project_name:$docker_images_version 10.0.1.28:5003/$jenkins_project_name:$docker_images_version
                        docker push 10.0.1.28:5003/$jenkins_project_name:$docker_images_version
                        '''
                }
            }
        }

        stage('deploy project') {
            steps {
                ansiblePlaybook (
                    playbook: "${env.WORKSPACE}/deploy.yaml",
                    extras: "--extra-vars 'docker_images_version=$docker_images_version jenkins_project_name=$jenkins_project_name'"
                )
            }
        }

    }
}
