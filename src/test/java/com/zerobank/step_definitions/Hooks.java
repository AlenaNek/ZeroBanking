package com.zerobank.step_definitions;


import com.zerobank.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUpScenario() {
        System.out.println("set up browser");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        Driver.getDriver().manage().window().fullscreen();
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        System.out.println("scenario.getName() = " + scenario.getName());
        scenario.write("Complete scenario: " + scenario.getName());

        if (scenario.isFailed()) {
            // take screenshot using selenium
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // attach to report
            scenario.embed(screenshot, "image/png", scenario.getName());
        }


        System.out.println("close driver");
        Driver.closeDriver();
    }
}

