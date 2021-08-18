pipeline{
    agent any
    
    stages{
        
        stage("Build"){
            
            steps{
                echo("Building")
            }
        }
        stage("Deploy DEV"){
            
            steps{
                echo("Dev deployment")
            }
        }
        stage("Deploy QA"){
            
            steps{
                echo("QA Deployment")
            }
        }
        stage("Regression Test"){
            
            steps{
                echo("Run Test Automation")
            }
        }
        stage("Deploy on Stage"){
            
            steps{
                echo("Stage Deployment ")
            }
        }
        stage("Sanity Test"){
            
            steps{
                echo("Sanity test on stage environment")
            }
        }
        stage("Prod deployment"){
            
            steps{
                echo("Deployment in prod")
            }
        }
    }

}