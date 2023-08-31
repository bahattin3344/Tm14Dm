package Bilgehan;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HediyeKarti extends BilgeBaseDriver {
    @Test
    public void HediyeKartiKullanma(){
        driver.get("https://demowebshop.tricentis.com/");
        Actions driverActions = new Actions(driver);
        JavascriptExecutor js=(JavascriptExecutor)driver;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='ico-login']")));
        WebElement logIn= driver.findElement(By.cssSelector("[class='ico-login']")); // loh in butonuna tıkladık
        logIn.click();

        WebElement emailGiris=driver.findElement(By.cssSelector("#Email"));
        emailGiris.sendKeys("tecnostudy123@gmail.com"); // emailimizi girdik

        WebElement passwordGiris=driver.findElement(By.cssSelector("#Password"));
        passwordGiris.sendKeys("Denizan561"); // şifremizi girdik

        WebElement girisBtn=driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        girisBtn.click(); // login butonuna bastık

        BilgeMyFunction.Bekle(2);

        WebElement topMenuNotebooks = driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]/a"));
        Action aksiyon = driverActions.moveToElement(topMenuNotebooks).build();
        BilgeMyFunction.Bekle(2);
        aksiyon.perform();
        BilgeMyFunction.Bekle(2);

        WebElement notebooks = driver.findElement(By.xpath("//ul[@class='sublist firstLevel active']/li[2]/a"));
        notebooks.click();

        BilgeMyFunction.Bekle(2);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement addToCartBut = driver.findElement(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']"));
        addToCartBut.click();

        WebElement shoppingCartButton = driver.findElement(By.xpath("//span[text()='Shopping cart']")); // sepetim yazısını bulduk
        js.executeScript("window.scrollTo(0, 0);");
        shoppingCartButton.click();

        WebElement discountCode = driver.findElement(By.name("discountcouponcode"));
        discountCode.sendKeys("12345678");

        WebElement applyCouponButton = driver.findElement(By.name("applydiscountcouponcode"));
        applyCouponButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));

        WebElement mesajText = driver.findElement(By.className("message"));

        Assert.assertTrue("Mesaj eşleşmedi...", mesajText.getText().contains("couldn't be applied"));

        BekleVeKapat();
    }
}
