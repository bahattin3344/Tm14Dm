import com.sun.org.omg.CORBA.ExceptionDescription;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Driver;
import java.util.function.Function;

public class MasterClass extends BaseDriver{
    @Test
    public void mainTest(){
        driver.get("https://demowebshop.tricentis.com");
        WebElement registerBtn=driver.findElement(By.cssSelector("[class='ico-register']"));
        registerBtn.click();  // register butonu bulup tıkladık
        // gerekli bilgiler dolduruldu
        WebElement cinsiyet=driver.findElement(By.cssSelector("#gender-male"));
        cinsiyet.click();
        WebElement name=driver.findElement(By.cssSelector("#FirstName"));
        name.sendKeys("Deniz");
        WebElement secondName=driver.findElement(By.cssSelector("#LastName"));
        secondName.sendKeys("Aydın");
        WebElement email=driver.findElement(By.cssSelector("#Email"));
        email.sendKeys("tecnostudy5455@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("Denizan561");
        WebElement confirmps=driver.findElement(By.cssSelector("#ConfirmPassword"));
        confirmps.sendKeys("Denizan561");
        WebElement registerBtn2=driver.findElement(By.cssSelector("#register-button"));
        registerBtn2.click();

        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='result']")));  // Your registration completed yazısının elementi görülünceye kadar bekle
        WebElement logOut=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        logOut.click();

        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='ico-login']")));
        WebElement logIn= driver.findElement(By.cssSelector("[class='ico-login']"));
        logIn.click();
        WebElement emailGiris=driver.findElement(By.cssSelector("#Email"));
        emailGiris.sendKeys("tecnostudy123@gmail.com");
        WebElement passwordGiris=driver.findElement(By.cssSelector("#Password"));
        passwordGiris.sendKeys("Denizan561");
        WebElement girisBtn=driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        girisBtn.click();
        MyFunction.wait(2);


        // Anket Bulundu
        WebElement anket=driver.findElement(By.cssSelector("[id='pollanswers-1']"));
        anket.click();
        MyFunction.wait(2);
        WebElement anketBtn=driver.findElement(By.cssSelector("[id='vote-poll-1']"));
        anketBtn.click();
        MyFunction.wait(2);

        // Profile Giriş

        WebElement profil=driver.findElement(By.cssSelector("[class='header-links']>ul>li>[class='account']"));
        profil.click();
        // orders Giriş
        bekle.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='active']")));
        WebElement orders=driver.findElement(By.cssSelector("[class='active']"));
        orders.click();
        // Sipariş Özetine Giriş
        bekle.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Details']")));
        WebElement details=driver.findElement(By.cssSelector("[value='Details']"));
        details.click();
        // Özeti İndirme
        bekle.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='button-2 pdf-order-button']")));
        WebElement pdfBtn=driver.findElement(By.cssSelector("[class='button-2 pdf-order-button']"));
        pdfBtn.click();








        driver.quit();


    }
}
