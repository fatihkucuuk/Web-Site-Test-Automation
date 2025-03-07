package com.project.StepDefinitions;

import com.project.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import io.cucumber.java.en.*;
import org.openqa.selenium.interactions.Actions;

public class RegisterAndLoginSteps {

    private final WebDriver driver = new ChromeDriver();
    private final Logger logger = LogManager.getLogger(RegisterAndLoginSteps.class);
    Methods methods;

    public RegisterAndLoginSteps() {
        this.methods = new Methods();
    }

    @Given("kullanıcı anasayfaya yönlendirilir")
    public void userOnHomePage() {
        driver.get("http://localhost:5173");
        logger.info("Kullanıcı anasayfaya yönlendirildi.");
    }

    @And("mouse userLogosunun üzerine getirilir")
    public void mouseHoverOnUserLogo() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("userLogo"))).perform();
        logger.info("Mouse user logosunun üzerine getirildi.");
    }

    @And("kayıt ol sekmesine tıklanır")
    public void clickOnRegister() {
        driver.findElement(By.id("registerButtons")).click();
        logger.info("Kayıt ol sekmesine tıklandı.");
    }

    @When("kullanıcı kayıt olma işlemi yapar")
    public void userRegister() {
        driver.findElement(By.id("registerUsername")).sendKeys("testUser");
        driver.findElement(By.id("registerEmail")).sendKeys("test@example.com");
        driver.findElement(By.id("registerPassword")).sendKeys("password123");
        logger.info("Kullanıcı adı, e-posta ve şifre girildi.");
        driver.findElement(By.id("registerButton")).click();
        logger.info("Kayıt ol butonuna tıklandı.");
    }

    @And("giriş yap sekmesine tıklanır")
    public void clickOnLogin() {
        driver.findElement(By.id("loginButtons")).click();
        logger.info("Giriş yap sekmesine tıklandı.");
    }

    @And("kullanıcı login işlemi yapar")
    public void userLogin() {
        driver.findElement(By.id("loginUsername")).sendKeys("testUser");
        driver.findElement(By.id("loginPassword")).sendKeys("password123");
        logger.info("Kullanıcı adı ve şifre girildi.");
        driver.findElement(By.id("loginButton")).click();
        logger.info("Giriş yap butonuna tıklandı.");
        methods.waitBySeconds(2);
    }

    @And("hesabım sekmesine tıklanır")
    public void clickOnMyAccount() {
        driver.findElement(By.id("myAccountButton")).click();
        logger.info("Hesabım sekmesine tıklandı");
    }

    @When("kullanıcı şifre güncelleme işlemi yapar")
    public void updateTheAccount() {
        driver.findElement(By.id("newPassword")).sendKeys("newPass123");
        driver.findElement(By.id("confirmPassword")).sendKeys("newPass123");
        logger.info("Yeni şifre ve Şifre Tekrarı girildi.");
        driver.findElement(By.id("updateButton")).click();
        logger.info("Güncelle butonuna tıklandı.");
        methods.waitBySeconds(2);
    }

    @And("kullanıcı iletişim sekmesine tıklar")
    public void clickOnContact() {
        driver.findElement(By.id("contactPage")).click();
        logger.info("İletişim sekmesine tıklandı.");
    }

    @And("kullanıcı mail gönderme işlemi yapar")
    public void sendMailFromContact() {
        driver.findElement(By.id("formName")).sendKeys("TEST");
        driver.findElement(By.id("formEmail")).sendKeys("test@example.com");
        driver.findElement(By.id("formSubject")).sendKeys("TEST OTOMASYONU DENEME");
        driver.findElement(By.id("formMessage")).sendKeys("Test otomasyonundan test maili gönderiliyor.");
        logger.info("Form bilgileri girildi, Ad, Mail, Konu, Mesaj.");
        driver.findElement(By.id("sendMailButton")).click();
        logger.info("Mesaj gönder butonuna tıklandı.");
        methods.waitBySeconds(2);
    }


    @Then("uygulama kapatılır")
    public void closeTheApplication() {
        try {
            logger.info("İşlem tamamlandı çıkış öncesi bekleme sürüyor.");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Kesintiyi işlemek için iyi bir uygulama
            System.out.println("Thread interrupted");
        } finally {
            driver.quit();
            logger.info("Test tamamlandı uygulamadan çıkış yapıldı.");
        }
    }
}
