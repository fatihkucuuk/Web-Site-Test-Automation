package com.project.StepDefinitions;

import com.project.methods.Methods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UserOperations {

    private final WebDriver driver = new ChromeDriver();
    private final Logger logger = LogManager.getLogger(UserOperations.class);
    Methods methods;

    public UserOperations() {
        this.methods = new Methods();
    }

    @Given("kullanıcı anasayfaya yönlendirildi")
    public void userOnHomePageForUserOperations() {
        driver.get("http://localhost:5173");
        logger.info("Kullanıcı anasayfaya yönlendirildi.");
    }

    @And("mouse userLogosunun üzerine getirildi")
    public void mouseHoverOnUserLogo() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("userLogo"))).perform();
        logger.info("Mouse user logosunun üzerine getirildi.");
    }

    @And("giriş yap sekmesine tıklandı")
    public void clickOnLoginPage() {
        driver.findElement(By.id("loginButtons")).click();
        logger.info("Giriş yap sekmesine tıklandı.");
    }

    @And("kullanıcı login işlemi yaptı")
    public void userLoginBusiness() {
        driver.findElement(By.id("loginUsername")).sendKeys("fatihkck");
        driver.findElement(By.id("loginPassword")).sendKeys("1234");
        logger.info("Kullanıcı adı ve şifre girildi.");
        driver.findElement(By.id("loginButton")).click();
        logger.info("Giriş yap butonuna tıklandı.");
        methods.waitBySeconds(2);
    }

    @And("kullanıcı ürünler sayfasına girer")
    public void userEntersProductPage() {
        driver.findElement(By.id("productPage")).click();
        logger.info("Ürünler sekmesine tıklandı.");
    }

    @And("kullanıcı ürün sıralar")
    public void userSortProducts() {
        methods.waitBySeconds(1);
        driver.findElement(By.id("selectOne")).click();
        logger.info("Ürün sıralama seçiniz butonuna tıklandı.");
        methods.waitBySeconds(1);
        driver.findElement(By.id("artanFiyat")).click();
        logger.info("Artan Fiyata Göre butonuna tıklandı.");
        methods.waitBySeconds(1);
    }

    @And("kullanıcı isme göre ürün arar")
    public void searchProductForName() {
        driver.findElement(By.id("searchProduct")).sendKeys("STWD");
        logger.info("Arama kısmına ürün ismi girildi.");
        methods.waitBySeconds(1);
        driver.findElement(By.id("searchButton")).click();
        logger.info("Ara butonuna tıklandı.");
        methods.waitBySeconds(2);
    }

    @And("kullanıcı aradığı ürüne tıklar")
    public void clickSearchProduct() {
        driver.findElement(By.id("product-1")).click();
        logger.info("Aranan ürüne tıklandı.");
    }

    @And("kullanıcı aradığı ürüne yorum ekler")
    public void addCommentAnd(){
        driver.findElement(By.id("star4")).click();
        logger.info("4 yıldız seçildi.");
        driver.findElement(By.id("commentText")).sendKeys("Bu ürün çok iyi! Tavsiye ederim.");
        logger.info("Yorum metni girildi.");
        driver.findElement(By.id("commentButton")).click();
        logger.info("Yorum ekle butonuna tıklandı.");
        methods.waitBySeconds(2);
    }

    @And("kullanıcı aradığı ürün hakkında soru sorar")
    public void addQuestion() {
        driver.findElement(By.id("questionText")).sendKeys("Bu ürünün garanti süresi nedir?");
        logger.info("Soru metni girildi.");
        driver.findElement(By.id("questionButton")).click();
        logger.info("Soru ekle butonuna tıklandı.");
        methods.waitBySeconds(2);
    }

    @Then("uygulama kapatıldı")
    public void closeTheUserTestApplication() {
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
