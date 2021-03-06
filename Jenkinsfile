pipeline {
    agent 'any'

    stages {
        stage('Hello') {
            steps {
                echo "Hello I am multibranch pipeline"
                echo " value is: ${env.Var}"
                echo " Val here is: ${Var}"

                echo "Sleep for 30 seconds: timer starts here"
                sleep 30
                echo "Sleep for 30 seconds is completed"

                echo " Val here is: ${Var}"

                echo " Global is: ${env.ATUL_ENV}"
                echo " Global here is: ${ATUL_ENV}"

            }
       }
       checkpoint 'First stage is completed'
       stage('Test') {
                   steps {
                       echo "Hello I am multibranch pipeline"
                       echo " value is: ${env.Var}"
                       echo " Val here is: ${Var}"

                       echo "Sleep for 30 seconds: timer starts here"
                       echo "Sleep for 30 seconds is completed"

                       echo " Val here is: ${Var}"

                       echo " Global is: ${env.ATUL_ENV}"
                       echo " Global here is: ${ATUL_ENV}"

                   }
       }

       checkpoint 'Before deployment: It is about to start'
       stage('Deploy') {
                          steps {
                              echo "Hello I am multibranch pipeline"
                              echo " value is: ${env.Var}"
                              echo " Val here is: ${Var}"

                              echo "Sleep for 30 seconds: timer starts here"
                              sleep 1
                              echo "Sleep for 30 seconds is completed"

                              echo " Val here is: ${Var}"

                              echo " Global is: ${env.ATUL_ENV}"
                              echo " Global here is: ${ATUL_ENV}"

                          }
       }
    }
}