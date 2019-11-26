package com.cocktaildb.testng.listeners;

import com.cocktaildb.entities.configuration.ConfigurationLoader;
import com.cocktaildb.entities.configuration.EnvConfigurationSection;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

@Log4j2
public class ApiTestListenerAdapter extends TestListenerAdapter implements ITestNGListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        if (iTestContext.getAttribute("env") == null) {
            try {
                EnvConfigurationSection currentEnvironment = ConfigurationLoader.loadEnvironment(System.getProperty("env"));
                iTestContext.setAttribute("env", currentEnvironment);
            } catch (IOException e) {
                log.info(e.getMessage());
            }
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

}
