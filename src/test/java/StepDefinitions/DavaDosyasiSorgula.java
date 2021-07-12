package StepDefinitions;
import CommonMethods.commonMethods;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DavaDosyasiSorgula {
    WebDriver driver=null;
    commonMethods cmtd;


    @When("kullanıcı anasayfada yer alan kurumlar menüsüne tıklar")
    public void kullanıcı_anasayfada_yer_alan_kurumlar_menüsüne_tıklar()  {


        //driver.findElement(By.cssSelector("a[href=\"/kurumlar\"]")).click();


    }
    @And("kullanıcı Kurum alfabesinde yer D harfine tıklar")
    public void kullanıcı_kurum_alfabesinde_yer_d_harfine_tıklar() throws InterruptedException {
        System.out.println("Sümeyye");
        //driver.findElement(By.xpath("/html/body/main/div/section/div[2]/a[5]")).click();
        driver.findElement(By.cssSelector("a[href=\"/kurumlar?kurumHarf=D\"]")).click();
    }
    @And("kullanıcı listeden Danıştay Başkanlığına tıklar")
    public void kullanıcı_listeden_danıştay_başkanlığına_tıklar() {
        driver.findElement(By.cssSelector("href=\"/danistay-baskanligi\"")).click();
    }
    @And("kullanıcı açılan hizmet listesinde yer alan Dava Dosyası Sorgulama hizmetine fare imleci ile odaklanır")
    public void kullanıcı_açılan_hizmet_listesinde_yer_alan_dava_dosyası_sorgulama_hizmetine_fare_imleci_ile_odaklanır() {
        driver.findElement(By.cssSelector("href=\"danistay-dava-dosyasi-sorgulama\""));
    }
    @Then("açılan ipucu ifadesini doğrulanır")
    public void açılan_ipucu_ifadesini_doğrulanır() {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.className("integratedService "));
        builder.moveToElement(element).build().perform();
        String ipucu = "Bu hizmet ile, Danıştay Başkanlığında davacı, davalı, müdahil veya diğer sıfatlarla " +
                "adınızın yer aldığı dava dosyaları ile ilgili bilgilere ulaşabilirsiniz.";
        driver.getPageSource().contains(ipucu);

    }
    @And("kullanıcı açılan hizmet listesinde yer alan Dava Dosyası Sorgulama hizmetine tıklanır")
    public void kullanıcı_açılan_hizmet_listesinde_yer_alan_dava_dosyası_sorgulama_hizmetine_tıklanır() {
        driver.findElement(By.cssSelector("href=\"danistay-dava-dosyasi-sorgulama\"")).click();
    }
    @Then("açılan ekranda yer alan içerikleri doğrulanır")
    public void açılan_ekranda_yer_alan_içerikleri_doğrulanır() {
        String beklenen_hizmet_acıklamasi = "Bu hizmet ile, Danıştay Başkanlığında davacı, davalı, müdahil veya diğer sıfatlarla " +
                "adınızın yer aldığı dava dosyaları ile ilgili bilgilere ulaşabilirsiniz. Dosyalarda taraf olmadığınızı" +
                " / dosyaların size ait olmadığını düşünüyorsanız Danıştay Başkanlığına başvurabilirsiniz.";
        String gercek_hizmet_acıklamasi = driver.findElement(By.className("richText")).getText();
        Assert.assertEquals(beklenen_hizmet_acıklamasi, gercek_hizmet_acıklamasi);

        String[] dava_dosyası_tablosu = {"Dava Dosyalarınız", "Açılış Tarihi", "Birim Adı", "Dosya Esas No", "Dosya Türü", "Konu", "Dosya Durumu", "Detay"};

        for (int i=0; i<dava_dosyası_tablosu.length; i++){
            driver.getPageSource().contains(dava_dosyası_tablosu[i]);
        }
    }
    @When("kullanıcı ekranda yer alan Görüntüle düğmesine tıklar")
    public void kullanıcı_ekranda_yer_alan_görüntüle_düğmesine_tıklar() {
       List<WebElement> element = driver.findElements(By.className("info"));
       element.get(1).click();
    }
    @Then("hizmete ait detay ekranı açılır ve ekrandaki içerik doğrulanır")
    public void hizmete_ait_detay_ekranı_açılır_ve_ekrandaki_içerik_doğrulanır() {
        String[] dava_dosya_bilgileri = {"Dava Dosya Bilgileri", "Birim Adı", "Açılış Tarihi", "Dosya Esas No", "Dosyanın Son Aşaması", "Dosya Türü", "Konu", "Dosya Durumu"};

        for (int i=0; i<dava_dosya_bilgileri.length; i++){
            driver.getPageSource().contains(dava_dosya_bilgileri[i]);
        }

        String[] karar_listesi = {"Karar Listesi", "Karar Sıra No", "Karar Yılı", "Karar Sonucu", "Karar Tarihi"};

        for (int i=0; i<karar_listesi.length; i++){
            driver.getPageSource().contains(karar_listesi[i]);
        }

        String[] taraf_listesi = {"Taraf Listesi", "Taraf Adı", "Taraf Rolü", "Vekiller"};

        for (int i=0; i<taraf_listesi.length; i++){
            driver.getPageSource().contains(taraf_listesi[i]);
        }
    }
    @When("kullanıcı Geri düğmesine tıklar")
    public void kullanıcı_geri_düğmesine_tıklar() {
        driver.findElement(By.className("back")).click();
    }
    @Then("kullanıcı Dava Dosyası Sorgulama hizmeti ana ekranına döner")
    public void kullanıcı_dava_dosyası_sorgulama_hizmeti_ana_ekranına_döner() {
        String beklenen_hizmet_acıklamasi = "Bu hizmet ile, Danıştay Başkanlığında davacı, davalı, müdahil veya diğer sıfatlarla " +
                "adınızın yer aldığı dava dosyaları ile ilgili bilgilere ulaşabilirsiniz. Dosyalarda taraf olmadığınızı" +
                " / dosyaların size ait olmadığını düşünüyorsanız Danıştay Başkanlığına başvurabilirsiniz.";
        String gercek_hizmet_acıklamasi = driver.findElement(By.className("richText")).getText();
        Assert.assertEquals(beklenen_hizmet_acıklamasi, gercek_hizmet_acıklamasi);
    }
    // warning gelmesi senaryosu methodu
    @Then("açılan ekranda dosya olmadığına dair uyaru mesajı ve hizmet açıklamasının yer aldığı içerikleri doğrulanır")
    public void açılan_ekranda_dosya_olmadığına_dair_uyaru_mesajı_ve_hizmet_açıklamasının_yer_aldığı_içerikleri_doğrulanır() {
        String beklenen_hizmet_acıklamasi = "Bu hizmet ile, Danıştay Başkanlığında davacı, davalı, müdahil veya diğer sıfatlarla " +
                "adınızın yer aldığı dava dosyaları ile ilgili bilgilere ulaşabilirsiniz. Dosyalarda taraf olmadığınızı" +
                " / dosyaların size ait olmadığını düşünüyorsanız Danıştay Başkanlığına başvurabilirsiniz.";
        String gercek_hizmet_acıklamasi = driver.findElement(By.className("richText")).getText();
        Assert.assertEquals(beklenen_hizmet_acıklamasi, gercek_hizmet_acıklamasi);

        String beklenen_uyarı = "Adınıza açılmış ya da tarafı olduğunuz bir dava dosyası bulunmamaktadır.";
        String gerçek_uyarı = driver.findElement(By.className("warningContainer")).getText();
        Assert.assertEquals(beklenen_uyarı, gerçek_uyarı);
    }
}
