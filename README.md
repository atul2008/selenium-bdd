##### GUI automation with Behavior Driven Development method

-
##### Run code for chrome browser using java 1.8 version (From commandPrompt of downloaded terminal):

Tested with chrome version :
Version 86.0.4240.198 (Official Build) (x86_64) and same compatible driver can be found in driver dir.

This code is tested with Mac OS Big Sur version.


./gradlew cucumberTest -Dcucumber.options="--tags @AddAccount" -DtestEnv=TEST -DbrowserName=chrome -Dthread.count=1

Report can be find under 
build/reports/cucumber_reports directory
for example "cucumber-results-agg-test-results.html" report where test cases reults will be stored
-
