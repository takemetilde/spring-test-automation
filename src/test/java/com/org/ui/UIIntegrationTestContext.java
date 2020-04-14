package com.org.ui;

import com.org.config.ScreenRecorderConfig;
import com.org.config.WebDriverConfig;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

@ComponentScan(basePackages = "com.org.ui", basePackageClasses = {WebDriverConfig.class, ScreenRecorderConfig.class})
public class UIIntegrationTestContext {

    @Autowired
    WebDriver webDriver;

    @Autowired
    ScreenRecorder screenRecorder;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @BeforeTestClass
    public void beforeUI() throws IOException {
        logger.info("Starting webdriver...");
        webDriver.manage().window().maximize();
        screenRecorder.start();
    }

    @AfterTestClass
    public void afterUI() throws IOException {
        logger.info("Quitting current webdriver...");
        webDriver.quit();
        screenRecorder.stop();
        List<File> createdMovieFiles = screenRecorder.getCreatedMovieFiles();
        for (File movie : createdMovieFiles) {
            System.out.println("New movie created: " + movie.getAbsolutePath());
        }
    }

}
