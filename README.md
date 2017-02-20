# rent

To build:
```bash
./gradlew clean war
cp build/libs/rentlambda.war ROOT.war
```

Then upload the `ROOT.war` file to AWS ELB as a tomcat application
