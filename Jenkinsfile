pipeline {
    agent any
	tools {
        maven "maven-3.6.3"
    }
    environment{
        jenkins_project_name="${params.jenkins_project_name}"
        docker_images_version="${params.project_version}"
        port="${params.port}"
        branch="${params.env}"
    }

    stages {

        stage('Git Source')
        {
			steps
			{
		          checkout([$class: 'GitSCM',
                  branches: [[name: "$branch"]],
                  doGenerateSubmoduleConfigurations: false,
                  extensions: [],
                  gitTool: 'Default',
                  submoduleCfg: [],
                  userRemoteConfigs: [[url: 'https://github.com/TrackAir/quick-start.git',credentialsId: 'cb93e1c2-f253-4b8d-92ce-20e575b5b114']]
                ])
			}
        }


        stage('maven Build') {
            steps {
                script {
                    sh  '''source /etc/profile
                        mvn clean package -DskipTests'''
                }
            }
        }


        stage('Bulid docker') {
            steps{
                script {
                    sh  '''
                        docker build -t $jenkins_project_name:$docker_images_version .
                        '''
                }
            }
        }

        stage('deploy project') {
            steps {
                script {
                    sh  '''
                         docker rm -f $jenkins_project_name
                                  docker rmi $jenkins_project_name:$docker_images_version
                                  docker run --name $jenkins_project_name --restart=always -p $port:$port $jenkins_project_name:$docker_images_version

                        '''
                }
            }
        }
    }
}
