package Bilgehan;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FailedLogInTest extends BaseDriver {
    @Test
    public void Test1(){
        /*
        Bu testimizde eksik bilgilerle kullanıcı giriş testi yapacağız.
        Birinci testimizde Email text box u ve password text box u boş kalacak şekilde ayarlıyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        MyFunction.Bekle(2);

        WebElement loginIcon = driver.findElement(By.xpath("(//ul/li[2]/a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginIcon));
        loginIcon.click();
        MyFunction.Bekle(2);

        WebElement emailTextBx = driver.findElement(By.cssSelector("#Email")); // Email locator ını buluyoruz.
        emailTextBx.sendKeys(""); // Email text box unu boş bırakıyoruz
        MyFunction.Bekle(2);

        WebElement passTextBx = driver.findElement(By.cssSelector("#Password")); // password locator ını buluyoruz.
        passTextBx.sendKeys(""); // passwordu boş bırakıyoruz.
        MyFunction.Bekle(2);

        WebElement loginButton = driver.findElement(By.cssSelector("[value='Log in']")); // Log in butonu locator ı
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        MyFunction.Bekle(2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='validation-summary-errors']/span")));
        // "Login was unsuccessful. Please correct the errors and try again." yazısını görene kadar bekle

        WebElement loginUns = driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));
        MyFunction.Bekle(2);

        Assert.assertTrue("Login was successful.",
                loginUns.getText().equals("Login was unsuccessful. Please correct the errors and try again."));
        // assert true ile login was unssuccesful. yazısı kontrolü yaptım.

        BekleVeKapat();
    }

    @Test
    public void Test2(){
        /*
        Bu testimizde eksik bilgilerle kullanıcı giriş testi yapacağız.
        İkinci testimizde Email text box u boş kalacak şekilde ayarlıyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        MyFunction.Bekle(2);

        WebElement loginIcon = driver.findElement(By.xpath("(//ul/li[2]/a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginIcon));
        loginIcon.click();
        MyFunction.Bekle(2);

        WebElement emailTextBx = driver.findElement(By.cssSelector("#Email")); // Email locator ını buluyoruz.
        emailTextBx.sendKeys(""); // Email text box unu boş bırakıyoruz
        MyFunction.Bekle(2);

        WebElement passTextBx = driver.findElement(By.cssSelector("#Password")); // password locator ını buluyoruz.
        passTextBx.sendKeys("123456"); // passwordu doğru şekilde bırakıyoruz.
        MyFunction.Bekle(2);

        WebElement loginButton = driver.findElement(By.cssSelector("[value='Log in']")); // Log in butonu locator ı
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        MyFunction.Bekle(2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='validation-summary-errors']/span")));
        // "Login was unsuccessful. Please correct the errors and try again." yazısını görene kadar bekle

        WebElement loginUns = driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));
        MyFunction.Bekle(2);

        Assert.assertTrue("Login was successful.",
                loginUns.getText().equals("Login was unsuccessful. Please correct the errors and try again."));
        // assert true ile login was unssuccesful. yazısı kontrolü yaptım.

        BekleVeKapat();
    }

    @Test
    public void Test3(){
        /*
        Bu testimizde eksik bilgilerle kullanıcı giriş testi yapacağız.
        Üçüncü testimizde password text box u boş kalacak şekilde ayarlıyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        MyFunction.Bekle(2);

        WebElement loginIcon = driver.findElement(By.xpath("(//ul/li[2]/a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginIcon));
        loginIcon.click();
        MyFunction.Bekle(2);

        WebElement emailTextBx = driver.findElement(By.cssSelector("#Email")); // Email locator ını buluyoruz.
        emailTextBx.sendKeys("metinkkedi@gmail.com"); // Email text box unu doğru şekilde giriyoruz.
        MyFunction.Bekle(2);

        WebElement passTextBx = driver.findElement(By.cssSelector("#Password")); // password locator ını buluyoruz.
        passTextBx.sendKeys(""); // passwordu text box unu boş bırakıyoruz
        MyFunction.Bekle(2);

        WebElement loginButton = driver.findElement(By.cssSelector("[value='Log in']")); // Log in butonu locator ı
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        MyFunction.Bekle(2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='validation-summary-errors']/span")));
        // "Login was unsuccessful. Please correct the errors and try again." yazısını görene kadar bekle

        WebElement loginUns = driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));
        MyFunction.Bekle(2);

        Assert.assertTrue("Login was successful.",
                loginUns.getText().equals("Login was unsuccessful. Please correct the errors and try again."));
        // assert true ile login was unssuccesful. yazısı kontrolü yaptım.

        BekleVeKapat();
    }

    @Test
    public void Test4(){
        /*
        Bu testimizde eksik bilgilerle kullanıcı giriş testi yapacağız.
        Dördüncü testimizde yanlış email ve yanlış şifre ile test ediyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        MyFunction.Bekle(2);

        WebElement loginIcon = driver.findElement(By.xpath("(//ul/li[2]/a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginIcon));
        loginIcon.click();
        MyFunction.Bekle(2);

        WebElement emailTextBx = driver.findElement(By.cssSelector("#Email")); // Email locator ını buluyoruz.
        emailTextBx.sendKeys("metinkedi@gmail.com"); // Email text box unu yanlış şekilde giriyoruz.
        MyFunction.Bekle(2);

        WebElement passTextBx = driver.findElement(By.cssSelector("#Password")); // password locator ını buluyoruz.
        passTextBx.sendKeys("12345678"); // passwordu text box unu yanlış şekilde giriyoruz.
        MyFunction.Bekle(2);

        WebElement loginButton = driver.findElement(By.cssSelector("[value='Log in']")); // Log in butonu locator ı
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        MyFunction.Bekle(2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='validation-summary-errors']/span")));
        // "Login was unsuccessful. Please correct the errors and try again." yazısını görene kadar bekle

        WebElement loginUns = driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));
        MyFunction.Bekle(2);

        Assert.assertTrue("Login was successful.",
                loginUns.getText().equals("Login was unsuccessful. Please correct the errors and try again."));
        // assert true ile login was unssuccesful. yazısı kontrolü yaptım.

        BekleVeKapat();
    }
}
