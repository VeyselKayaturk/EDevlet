package StepDefinitions;
import CommonMethods.commonMethods;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver=null;
    commonMethods cmtd;

    @Given("browser açıldı")
    public void browser_açıldı() throws InterruptedException {
        //cmtd.browserSetUp();
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/drivers/chromedriver");

        //System.setProperty("webdriver.gecko.driver", projectPath+"/src/main/resources/drivers/geckodriver");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @When("^kullanıcı edevlet adresine gider ve (.*) ile (.*) girer$")
    public void kullanıcı_edevlet_adresine_gider_ve_ile_girer(String tckn, String sifre) throws InterruptedException {


        driver.navigate().to("https://www.build.turkiye.gov.tr/");
        driver.findElement(By.id("l")).click();

        cmtd = new commonMethods(driver);
        cmtd.loginToApp(tckn,sifre);
        //driver.findElement(By.name("tridField")).sendKeys(tckn);
        Thread.sleep(3000);
        //driver.findElement(By.name("egpField")).sendKeys(sifre);
        Thread.sleep(3000);
    }

    @And("giriş yap düğmesine tıklar")
    public void giriş_yap_düğmesine_tıklar() throws InterruptedException {
        driver.findElement(By.name("submitButton")).click();
        Thread.sleep(5000);
    }

    @Then("kullanıcı giriş yapar ve tekrar çıkış yapar")
    public void kullanıcı_giriş_yapar_ve_tekrar_çıkış_yapar() throws InterruptedException {
        cmtd = new commonMethods(driver);
        cmtd.logOutFromApp();
        //cmtd.tearDown();
        driver.close();
        driver.quit();
    }

}