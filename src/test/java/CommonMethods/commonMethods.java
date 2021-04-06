package CommonMethods;

import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class commonMethods {

    WebDriver driver = null;

    public commonMethods(WebDriver driver){
        this.driver=driver;
    }
   /* @Before
    public void browserSetUp() throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }*/

    public void loginToApp(String tckn, String sifre) throws InterruptedException {
        driver.findElement(By.name("tridField")).sendKeys(tckn);
        driver.findElement(By.name("egpField")).sendKeys(sifre);
        Thread.sleep(3000);
        driver.findElement(By.name("submitButton")).click();
        Thread.sleep(3000);
    }
    public void logOutFromApp() throws InterruptedException {
        driver.findElement(By.id("userMenu")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("logout")).click();

    }
}
