def call(workDir='') {	
	def p = load("ci-helper/infra/${workDir}/application.properties.groovy")
	writeSecretFileInJenkins(p.mavenSettingsXml, "mavenSettingsXml")
    withCredentials([file(credentialsId: 'mavenSettingsXml', variable: 'mavenSettingsXmlPath')]) { 
    	withMaven(maven: 'Maven') { 
            sh "mvn clean package -s ${mavenSettingsXmlPath}"
    	}  
    }    
}

return this
 
