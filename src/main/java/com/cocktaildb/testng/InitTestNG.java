package com.cocktaildb.testng;

import com.cocktaildb.entities.configuration.ConfigurationLoader;
import com.cocktaildb.entities.configuration.EnvConfigurationSection;
import com.cocktaildb.testng.listeners.ApiTestListenerAdapter;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import java.io.IOException;
import java.util.Properties;

@Log4j2
public class InitTestNG {

    public static void main(String[] args) throws IOException {
        TestNG testng = new TestNG();

        if (System.getProperty("env") == null) {
            System.setProperty("env", "prod");
        }

        EnvConfigurationSection currentEnvironment = ConfigurationLoader.loadEnvironment(System.getProperty("env"));

        log.info("Env variable: " + System.getProperty("env"));
        testng.addListener((ITestNGListener) new ApiTestListenerAdapter());
        testng.run();
    }
}