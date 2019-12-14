pipeline {
    agent any

    //def env = System.getenv()
    //def jenkins_home_path = env['JENKINS_HOME']
    stages {
        stage('Download SourceCode') {
            steps {
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Remove Original SourceCode and Packages    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                sh 'rm -rf /application/jenkins/deploy'
                sh 'mkdir -p /application/jenkins/deploy'
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Download SourceCode from GitHub  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                sh 'git clone git@github.com:gh-yehl/Assignment-StockService.git "${JENKINS_FOLDER}/deploy"'
                echo "Source Code Download Completed!!!"
            }
        }

        stage('Maven Build SourceCode') {
            steps {
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Maven Packaging SourceCode including Junit test   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                sh 'mvn -f "${JENKINS_FOLDER}/deploy"/pom.xml package'
                echo 'Package SourceCode Completed'
            }
        }

        stage('Deploy To Docker') {

            steps {
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Stop and Remove Exchange Container in Docker   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                sh 'docker stop exchange'
                sh 'docker rm exchange'
                sh 'docker rmi funny5/exchange-service'
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Create New Image and Exchange Container   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                sh 'cp "${JENKINS_FOLDER}/deploy"/target/exchange-service-1.0-SNAPSHOT.jar "${JENKINS_FOLDER}/deploy"/src/main/docker'
                sh 'docker build -tf "${JENKINS_FOLDER}/deploy"/src/main/docker/Dockerfile -t exchange-service .'
                sh 'docker run -idt --memory=400M --name=exchange --net=backend -p 9001:9001 exchange-service'
                sh 'docker tag  exchange-service funny5/exchange-service'
                sh 'docker login'
                sh 'docker push funny5/exchange-service'

                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Deploying to Docker Done   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'

            }
        }
    }
}