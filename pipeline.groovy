pipeline {
	  agent any
	  stages {
	      stage('git checkout') {
	          steps {
	              git url: 'https://github.com/smitty231/jenkins-ansible-pipeline', branch: 'main'
	          } 
	      }
	    stage('excute yml') {
	      steps {
	       ansiblePlaybook credentialsId: 'jenkins-ansible', disableHostKeyChecking: true, installation: 'ansible', inventory: 'hosts', playbook: 'nginx.yml', vaultTmpPath: ''
	      }
	    }
	  }
	}
