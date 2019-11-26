# cocktaildb-tests
cocktaildb api testing framework

```git clone https://github.com/macroman321/cocktaildb-tests```

```mvn install```

```mvn -Denv=prod -Dmaven.test.failure.ignore -Denvironment.configuration.file=src/test/resources/EnvConfigurationFile.json -DsuiteName=api  test```
