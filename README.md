##### GUI automation with Behavior Driven Development method


##### Run code for chrome browser using java 1.8 version:
Import the project build.gradle file and go to your IntelliJ/Eclipse Terminal and
use below mentioned gradle command  to run the test.


This code is tested with chrome version :
Version 86.0.4240.198 (Official Build) (x86_64) and same compatible driver can be found in driver dir.

This code is tested with Mac OS Big Sur version.


./gradlew cucumberTest -Dcucumber.options="--tags @AddAccount" -DtestEnv=TEST -DbrowserName=chrome -Dthread.count=1


-Dthread.count is used for running scenarions in parallel mode. 
If -Dthread.count is given 3 then it will start 3 scenarions in parallel.

-DtestEnv can be TEST/Staging Enviorment name.
-DbrowserName can be set the any browser but right now code is supporting only chrome. 



Here I have added one sample scenario which covers only +ve case we can add multiple scenarions for
covering -ve cases and boundary value + to hit the business rules conditions. It is just for demo purpose. 

Report can be find under 
build/reports/cucumber_reports directory
for example "cucumber-results-agg-test-results.html" report where test cases reults will be stored
-



