node {
    stage("Clone repo"){
        git "@github.com:Nurjan87/flask-examples.git"
    }
    stage("Install Requirements"){
        sh "scp -r * ec2-user@${ENV}:/tmp"
        sh "ssh ec2-user@${ENV} virtualenv /tmp/venv"
        sh "ssh ec2-user@${ENV} virtualenv ./tmp/venv/activate"
        sh "ssh ec2-user@${ENV} sudo pip install -r /tmp/requirements.txt"
        
    }
    stage("Start python app"){
        sh "ssh ec2-user@${ENV} python /tmp/01-hello-world/hello.py"
        }
}