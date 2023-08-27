package Bilgehan;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FailedRegisterTest extends BilgeBaseDriver{

    @Test
    public void Test1(){
        /*
        Bu testimizde eksik bilgilerle kullanıcı oluşturma senaryosunu test edeceğiz. İlk testimizde gender (cinsiyet)
        radio button seçimimiz boş kalacak.
         */
        driver.get("https://demowebshop.tricentis.com/");
        BilgeFunc.Bekle(2);

        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']")); // register locator
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)); // tıklanabilir olana kadar bekle
        registerButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']")); // first name locator
        firstNameTxtBox.sendKeys("Metin"); // first name i doldurduk.
        BilgeFunc.Bekle(2);

        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']")); // last name locator
        lastNameTxtBox.sendKeys("Karakedi"); // last name i doldurduk.
        BilgeFunc.Bekle(2);

        WebElement emailTxtBox = driver.findElement(By.cssSelector("#Email"));
        emailTxtBox.sendKeys("mustafakkedi@gmail.com");
        BilgeFunc.Bekle(2);

        WebElement passwordTxtBox = driver.findElement(By.cssSelector("#Password"));
        passwordTxtBox.sendKeys("Beyazkedi1.");
        BilgeFunc.Bekle(2);

        WebElement confirmPassTxtBox = driver.findElement(By.cssSelector("#ConfirmPassword"));
        confirmPassTxtBox.sendKeys("Beyazkedi1.");
        BilgeFunc.Bekle(2);

        WebElement registerButton2 = driver.findElement(By.cssSelector("#register-button"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton2));
        registerButton2.click();
        BilgeFunc.Bekle(2);

        // Test failed cinsiyet seçimi zorunlu değil cinsiyet seçimi yapmadan da üyeliği tamamlıyor

        BekleVeKapat();
    }

    @Test
    public void Test2(){
        /*
        Bu testimizde eksik bilgilerle kullanıcı oluşturma senaryosunu test edeceğiz. İkinci testimizde first name
        text box unu boş kalacak şekilde ayarlayıp kullanıcı oluşturmayı deniyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        BilgeFunc.Bekle(2);

        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']")); // register locator
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)); // tıklanabilir olana kadar bekle
        registerButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement genderMaleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']")); // gender Male locator
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadioButton)); // tıklanabilir olana kadar bekle
        genderMaleRadioButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']")); // first name locator
        firstNameTxtBox.sendKeys(""); // first name i boş bırakıyoruz.
        BilgeFunc.Bekle(2);

        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']")); // last name locator
        lastNameTxtBox.sendKeys("Karakedi"); // last name i doldurduk.
        BilgeFunc.Bekle(2);

        WebElement emailTxtBox = driver.findElement(By.cssSelector("#Email")); // e-Mail locator ı
        emailTxtBox.sendKeys("metinkkedi@gmail.com"); // e-Mail dolduruyoruz
        BilgeFunc.Bekle(2);

        WebElement passwordTxtBox = driver.findElement(By.cssSelector("#Password")); // password locator ı
        passwordTxtBox.sendKeys("Beyazkedi1."); // passwordu kurallara uygun girdik
        BilgeFunc.Bekle(2);

        WebElement confirmPassTxtBox = driver.findElement(By.cssSelector("#ConfirmPassword")); // confirm password text box u
        confirmPassTxtBox.sendKeys("Beyazkedi1."); // aynı password u tekrarladık
        BilgeFunc.Bekle(2);

        WebElement registerButton2 = driver.findElement(By.cssSelector("#register-button"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton2));
        registerButton2.click();
        BilgeFunc.Bekle(2);

        WebElement firstNameError = driver.findElement(By.xpath("//span[text()='First name is required.']"));
        wait.until(ExpectedConditions.visibilityOf(firstNameError));

        Assert.assertTrue("First name is required. Hatası alınamadı...", firstNameError.getText().equals("First name is required."));
        // Assert true ile hata mesajını eşleştirdim.

        BekleVeKapat();
    }

    @Test
    public void Test3(){
        /*
        Bu testimizde eksik bilgilerle kullanıcı oluşturma senaryosunu test edeceğiz. Üçüncü testimizde last name
        text box unu boş kalacak şekilde ayarlayıp kullanıcı oluşturmayı deniyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        BilgeFunc.Bekle(2);

        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']")); // register locator
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)); // tıklanabilir olana kadar bekle
        registerButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement genderMaleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']")); // gender Male locator
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadioButton)); // tıklanabilir olana kadar bekle
        genderMaleRadioButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']")); // first name locator
        firstNameTxtBox.sendKeys("Metin"); // first name i dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']")); // last name locator
        lastNameTxtBox.sendKeys(""); // last name i boş bırakıyorum.
        BilgeFunc.Bekle(2);

        WebElement emailTxtBox = driver.findElement(By.cssSelector("#Email")); // e-Mail locator ı
        emailTxtBox.sendKeys("metinkkedi@gmail.com"); // e-Mail dolduruyoruz
        BilgeFunc.Bekle(2);

        WebElement passwordTxtBox = driver.findElement(By.cssSelector("#Password")); // password locator ı
        passwordTxtBox.sendKeys("Beyazkedi1."); // passwordu kurallara uygun girdik
        BilgeFunc.Bekle(2);

        WebElement confirmPassTxtBox = driver.findElement(By.cssSelector("#ConfirmPassword")); // confirm password text box u
        confirmPassTxtBox.sendKeys("Beyazkedi1."); // aynı password u tekrarladık
        BilgeFunc.Bekle(2);

        WebElement registerButton2 = driver.findElement(By.cssSelector("#register-button"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton2));
        registerButton2.click();
        BilgeFunc.Bekle(2);

        WebElement lastNameError = driver.findElement(By.xpath("//span[text()='Last name is required.']"));
        wait.until(ExpectedConditions.visibilityOf(lastNameError));

        Assert.assertTrue("First name is required. Hatası alınamadı...", lastNameError.getText().equals("Last name is required."));
        // Assert true ile hata mesajını eşleştirdim.

        BekleVeKapat();
    }
    @Test
    public void Test4() {
        /*
        Bu testimizde eksik bilgilerle kullanıcı oluşturma senaryosunu test edeceğiz. Dördüncü testimizde email
        text box unu boş kalacak şekilde ayarlayıp kullanıcı oluşturmayı deniyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        BilgeFunc.Bekle(2);

        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']")); // register locator
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)); // tıklanabilir olana kadar bekle
        registerButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement genderMaleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']")); // gender Male locator
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadioButton)); // tıklanabilir olana kadar bekle
        genderMaleRadioButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']")); // first name locator
        firstNameTxtBox.sendKeys("Metin"); // first name i dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']")); // last name locator
        lastNameTxtBox.sendKeys("Karakedi"); // last name i dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement emailTxtBox = driver.findElement(By.cssSelector("#Email")); // e-Mail locator ı
        emailTxtBox.sendKeys(""); // e-Mail boş bırakıyoruz.
        BilgeFunc.Bekle(2);

        WebElement passwordTxtBox = driver.findElement(By.cssSelector("#Password")); // password locator ı
        passwordTxtBox.sendKeys("Beyazkedi1."); // passwordu kurallara uygun girdik
        BilgeFunc.Bekle(2);

        WebElement confirmPassTxtBox = driver.findElement(By.cssSelector("#ConfirmPassword")); // confirm password text box u
        confirmPassTxtBox.sendKeys("Beyazkedi1."); // aynı password u tekrarladık
        BilgeFunc.Bekle(2);

        WebElement registerButton2 = driver.findElement(By.cssSelector("#register-button"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton2));
        registerButton2.click();
        BilgeFunc.Bekle(2);

        WebElement emailError = driver.findElement(By.xpath("//span[text()='Email is required.']"));
        wait.until(ExpectedConditions.visibilityOf(emailError));

        Assert.assertTrue("First name is required. Hatası alınamadı...", emailError.getText().equals("Email is required."));
        // Assert true ile hata mesajını eşleştirdim.

        BekleVeKapat();
    }
    @Test
    public void Test5() {
        /*
        Bu testimizde eksik bilgilerle kullanıcı oluşturma senaryosunu test edeceğiz. Beşinci testimizde password ve confirm password
        text box unu boş kalacak şekilde ayarlayıp kullanıcı oluşturmayı deniyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        BilgeFunc.Bekle(2);

        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']")); // register locator
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)); // tıklanabilir olana kadar bekle
        registerButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement genderMaleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']")); // gender Male locator
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadioButton)); // tıklanabilir olana kadar bekle
        genderMaleRadioButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']")); // first name locator
        firstNameTxtBox.sendKeys("Metin"); // first name i dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']")); // last name locator
        lastNameTxtBox.sendKeys("Karakedi"); // last name i dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement emailTxtBox = driver.findElement(By.cssSelector("#Email")); // e-Mail locator ı
        emailTxtBox.sendKeys("metinkkedi@gmail.com"); // e-Mail dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement passwordTxtBox = driver.findElement(By.cssSelector("#Password")); // password locator ı
        passwordTxtBox.sendKeys(""); // passwordu boş bıraktık
        BilgeFunc.Bekle(2);

        WebElement confirmPassTxtBox = driver.findElement(By.cssSelector("#ConfirmPassword")); // confirm password text box u
        confirmPassTxtBox.sendKeys(""); // confirm password boş bıraktık
        BilgeFunc.Bekle(2);

        WebElement registerButton2 = driver.findElement(By.cssSelector("#register-button"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton2));
        registerButton2.click();
        BilgeFunc.Bekle(2);

        WebElement passwordError = driver.findElement(By.xpath("(//span[text()='Password is required.'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(passwordError));

        Assert.assertTrue("First name is required. Hatası alınamadı...", passwordError.getText().equals("Password is required."));
        // Assert true ile hata mesajını eşleştirdim.

        BekleVeKapat();
    }

    @Test
    public void Test6() {
        /*
        Bu testimizde eksik bilgilerle kullanıcı oluşturma senaryosunu test edeceğiz. Altıncı testimizde confirm password
        text box unu boş kalacak şekilde ayarlayıp kullanıcı oluşturmayı deniyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        BilgeFunc.Bekle(2);

        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']")); // register locator
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)); // tıklanabilir olana kadar bekle
        registerButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement genderMaleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']")); // gender Male locator
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadioButton)); // tıklanabilir olana kadar bekle
        genderMaleRadioButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']")); // first name locator
        firstNameTxtBox.sendKeys("Metin"); // first name i dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']")); // last name locator
        lastNameTxtBox.sendKeys("Karakedi"); // last name i dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement emailTxtBox = driver.findElement(By.cssSelector("#Email")); // e-Mail locator ı
        emailTxtBox.sendKeys("metinkkedi@gmail.com"); // e-Mail dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement passwordTxtBox = driver.findElement(By.cssSelector("#Password")); // password locator ı
        passwordTxtBox.sendKeys("123456"); // passwordu kurallara uygun girdik
        BilgeFunc.Bekle(2);

        WebElement confirmPassTxtBox = driver.findElement(By.cssSelector("#ConfirmPassword")); // confirm password text box u
        confirmPassTxtBox.sendKeys(""); // confirm password boş bıraktık
        BilgeFunc.Bekle(2);

        WebElement registerButton2 = driver.findElement(By.cssSelector("#register-button"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton2));
        registerButton2.click();
        BilgeFunc.Bekle(2);

        WebElement passwordError = driver.findElement(By.xpath("//span[text()='Password is required.']"));
        wait.until(ExpectedConditions.visibilityOf(passwordError));

        Assert.assertTrue("First name is required. Hatası alınamadı...", passwordError.getText().equals("Password is required."));
        // Assert true ile hata mesajını eşleştirdim.

        BekleVeKapat();
    }

    @Test
    public void Test7() {
        /*
        Bu testimizde eksik bilgilerle kullanıcı oluşturma senaryosunu test edeceğiz. Yedinci testimizde confirm passwordu yanlış
        girecek şekilde ayarlayıp kullanıcı oluşturmayı deniyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        BilgeFunc.Bekle(2);

        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']")); // register locator
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)); // tıklanabilir olana kadar bekle
        registerButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement genderMaleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']")); // gender Male locator
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadioButton)); // tıklanabilir olana kadar bekle
        genderMaleRadioButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']")); // first name locator
        firstNameTxtBox.sendKeys("Metin"); // first name i boş bırakıyoruz.
        BilgeFunc.Bekle(2);

        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']")); // last name locator
        lastNameTxtBox.sendKeys("Karakedi"); // last name i dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement emailTxtBox = driver.findElement(By.cssSelector("#Email")); // e-Mail locator ı
        emailTxtBox.sendKeys("metinkkedi@gmail.com"); // e-Mail i giriyoruz.
        BilgeFunc.Bekle(2);

        WebElement passwordTxtBox = driver.findElement(By.cssSelector("#Password")); // password locator ı
        passwordTxtBox.sendKeys("123456"); // passwordu kurallara uygun girdik
        BilgeFunc.Bekle(2);

        WebElement confirmPassTxtBox = driver.findElement(By.cssSelector("#ConfirmPassword")); // confirm password text box u
        confirmPassTxtBox.sendKeys("1234567"); // confirm passwordu yanlış girdik
        BilgeFunc.Bekle(2);

        WebElement registerButton2 = driver.findElement(By.cssSelector("#register-button"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton2));
        registerButton2.click();
        BilgeFunc.Bekle(2);

        WebElement passwordError = driver.findElement(By.xpath("//span[text()='The password and confirmation password do not match.']"));
        wait.until(ExpectedConditions.visibilityOf(passwordError));

        Assert.assertTrue("First name is required. Hatası alınamadı...", passwordError.getText().equals("The password and confirmation password do not match."));
        // Assert true ile hata mesajını eşleştirdim.

        BekleVeKapat();
    }

    @Test
    public void Test8() {
        /*
        Bu testimizde eksik bilgilerle kullanıcı oluşturma senaryosunu test edeceğiz. Sekizinci testimizde password u
        kurallara uygun şekilde ayarlamayıp kullanıcı oluşturmayı deniyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        BilgeFunc.Bekle(2);

        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']")); // register locator
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)); // tıklanabilir olana kadar bekle
        registerButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement genderMaleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']")); // gender Male locator
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadioButton)); // tıklanabilir olana kadar bekle
        genderMaleRadioButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']")); // first name locator
        firstNameTxtBox.sendKeys("Metin"); // first name i boş bırakıyoruz.
        BilgeFunc.Bekle(2);

        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']")); // last name locator
        lastNameTxtBox.sendKeys("Karakedi"); // last name i dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement emailTxtBox = driver.findElement(By.cssSelector("#Email")); // e-Mail locator ı
        emailTxtBox.sendKeys("metinkkedi@gmail.com"); // e-Mail giriyoruz.
        BilgeFunc.Bekle(2);

        WebElement passwordTxtBox = driver.findElement(By.cssSelector("#Password")); // password locator ı
        passwordTxtBox.sendKeys("12345"); // passwordu kurallara uygun girmedik
        BilgeFunc.Bekle(2);

        WebElement confirmPassTxtBox = driver.findElement(By.cssSelector("#ConfirmPassword")); // confirm password text box u
        confirmPassTxtBox.sendKeys("12345"); // confirm passwordu girdik
        BilgeFunc.Bekle(2);

        WebElement registerButton2 = driver.findElement(By.cssSelector("#register-button"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton2));
        registerButton2.click();
        BilgeFunc.Bekle(2);

        WebElement passwordError = driver.findElement(By.xpath("//span[text()='The password should have at least 6 characters.']"));
        wait.until(ExpectedConditions.visibilityOf(passwordError));

        Assert.assertTrue("First name is required. Hatası alınamadı...", passwordError.getText().equals("The password should have at least 6 characters."));
        // Assert true ile hata mesajını eşleştirdim.

        BekleVeKapat();
    }

    @Test
    public void Test9() {
        /*
        Bu testimizde eksik bilgilerle kullanıcı oluşturma senaryosunu test edeceğiz. Dokuzuncu testimizde daha önce alınan
        bir email ile tekrar kullanıcı oluşturmayı deniyoruz.
         */
        driver.get("https://demowebshop.tricentis.com/");
        BilgeFunc.Bekle(2);

        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']")); // register locator
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)); // tıklanabilir olana kadar bekle
        registerButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement genderMaleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']")); // gender Male locator
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadioButton)); // tıklanabilir olana kadar bekle
        genderMaleRadioButton.click(); // tıkladık
        BilgeFunc.Bekle(2);

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']")); // first name locator
        firstNameTxtBox.sendKeys("Metin"); // first name i boş bırakıyoruz.
        BilgeFunc.Bekle(2);

        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']")); // last name locator
        lastNameTxtBox.sendKeys("Karakedi"); // last name i dolduruyoruz.
        BilgeFunc.Bekle(2);

        WebElement emailTxtBox = driver.findElement(By.cssSelector("#Email")); // e-Mail locator ı
        emailTxtBox.sendKeys("metinkkedi@gmail.com"); // daha önceki açtığımız hesapla kullanıcı oluşturmayı deniyoruz.
        BilgeFunc.Bekle(2);

        WebElement passwordTxtBox = driver.findElement(By.cssSelector("#Password")); // password locator ı
        passwordTxtBox.sendKeys("123456"); // passwordu kurallara uygun girmedik
        BilgeFunc.Bekle(2);

        WebElement confirmPassTxtBox = driver.findElement(By.cssSelector("#ConfirmPassword")); // confirm password text box u
        confirmPassTxtBox.sendKeys("123456"); // confirm passwordu girdik
        BilgeFunc.Bekle(2);

        WebElement registerButton2 = driver.findElement(By.cssSelector("#register-button"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton2));
        registerButton2.click();
        BilgeFunc.Bekle(2);

        WebElement emailAlrExst = driver.findElement(By.xpath("//ul/li[text()='The specified email already exists']"));
        wait.until(ExpectedConditions.visibilityOf(emailAlrExst));

        Assert.assertTrue("First name is required. Hatası alınamadı...", emailAlrExst.getText().equals("The specified email already exists"));
        // Assert true ile hata mesajını eşleştirdim.

        BekleVeKapat();
    }
}


