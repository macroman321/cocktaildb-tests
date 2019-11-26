# cocktaildb-tests
cocktaildb api testing framework

```git clone https://github.com/macroman321/cocktaildb-tests```

```mvn install```

Ignore red error log I copied and edited pom.xml I use atm and didn't have time to clean it up


```mvn -Denv=prod -Dmaven.test.failure.ignore -Denvironment.configuration.file=src/test/resources/EnvConfigurationFile.json -DsuiteName=api  test```
