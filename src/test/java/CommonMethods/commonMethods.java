package CommonMethods;

import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.junit.Before;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


import javax.swing.JOptionPane;
public class commonMethods {

    WebDriver driver = null;

    public commonMethods(WebDriver driver){
        this.driver=driver;
    }
    public void userAuthantication (String tckn, String kurum_alfabe){
        driver.navigate().to("http://oturum.app1.turkiye.gov.tr:7070/GirisDeneme/GirisServlet?opCode=1&kimlikNo=59338004068&level=1");
        driver.navigate().to("https://www.build.turkiye.gov.tr/");
    }
//   @Before
//    public void browserSetUp(){
//
//        JOptionPane.showMessageDialog(null, "Before Hooks :)", "I was here", JOptionPane.INFORMATION_MESSAGE);
////        String projectPath = System.getProperty("user.dir");
////        System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/drivers/chromedriver");
////
////        driver = new ChromeDriver();
////        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
////        driver.manage().window().maximize();
////        Thread.sleep(5000);
//    }
    /*@After
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
