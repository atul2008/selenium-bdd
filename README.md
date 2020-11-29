##### GUI automation with Behavior Driven Development method

-
##### Run code for chrome browser using java 1.8 version:

./gradlew cucumberTest -Dcucumber.options="--tags @AddAccount" -DtestEnv=TEST -DbrowserName=chrome -Dthread.count=1

Report can be find under 
build/reports/cucumber_reports directory
for example "cucumber-results-agg-test-results.html" report where test cases reults will be stored
-