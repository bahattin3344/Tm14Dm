package Bilgehan;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SiparisVerme extends BaseDriver {
    @Test
    public void SiparisVerme(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement emailGiris=driver.findElement(By.cssSelector("#Email"));
        emailGiris.sendKeys("tecnostudy123@gmail.com"); // emailimizi girdik

        WebElement passwordGiris=driver.findElement(By.cssSelector("#Password"));
        passwordGiris.sendKeys("Denizan561"); // şifremizi girdik

        WebElement girisBtn=driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        girisBtn.click(); // login butonuna bastık

        MyFunction.Bekle(2);

        BekleVeKapat();
    }
}
