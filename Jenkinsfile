pipeline {
    agent 'any'

    stages {
        stage('Hello') {
            steps {
                echo "Hello I am multibranch pipeline"
                echo " value is: ${env.Var}"
                echo " Val here is: ${Var}"
                bat sleep 30

                echo " Global is: ${env.ATUL_ENV}"
                echo " Global here is: ${ATUL_ENV}"





            }
       }
    }
}