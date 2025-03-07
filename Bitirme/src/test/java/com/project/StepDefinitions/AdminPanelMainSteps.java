package com.project.StepDefinitions;

import com.project.methods.Methods;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminPanelMainSteps {
    private final WebDriver driver = new ChromeDriver();
    private final Logger logger = LogManager.getLogger(RegisterAndLoginSteps.class);
    Methods methods;

    @Given("admin, admin giriş paneline yönlendirildi")
    public void userOnHomePageForUserOperations() {
        driver.get("http://localhost:5173/admin-login");
        logger.info("Admin, admin giriş sayfasına yönlendirildi.");
        methods.waitBySeconds(10);
    }


}
