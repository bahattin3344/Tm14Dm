import Bilgehan.BilgeFunc;
import com.sun.org.omg.CORBA.ExceptionDescription;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
        email.sendKeys("tecnostudy8585@gmail.com");
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
        emailGiris.sendKeys("tecnostudy8585@gmail.com");
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

        // Sipariş Oluşturma Ve Onaylama
        WebElement addToCartBut = driver.findElement(By.xpath("(//input[@class = 'button-2 product-box-add-to-cart-button'])[2]"));
        addToCartBut.click(); // herhangi bir ürünü seçip sepete ekledik

        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
        // işlem başarılı yazısı görünene kadar bekledik

        BilgeFunc.Bekle(2);

        JavascriptExecutor js=(JavascriptExecutor)driver;

        WebElement shoppingCartButton = driver.findElement(By.xpath("//span[text()='Shopping cart']")); // sepetim yazısını bulduk
        js.executeScript("window.scrollTo(0, 0);");
        shoppingCartButton.click();

        BilgeFunc.Bekle(2);

        WebElement sepettekiUrun = driver.findElement(By.xpath("//a[@class='product-name']"));
        Assert.assertTrue("Ürün bulunamadı...", sepettekiUrun.getText().equals("14.1-inch Laptop"));
        // assert true ile laptop u kontrol ettim

        WebElement selectMenu1 = driver.findElement(By.id("CountryId")); // country menüsü locator ı
        Select countrySelect = new Select(selectMenu1); // select e çevirdim
        countrySelect.selectByVisibleText("Turkey");

        WebElement selectMenu2 = driver.findElement(By.id("StateProvinceId"));
        Select stateSelect = new Select(selectMenu2); // zaten tek seçenek old. için indexi 0 olanı seç dedim
        stateSelect.selectByIndex(0);

        WebElement zipCodeText = driver.findElement(By.id("ZipPostalCode")); // posta kodu locator
        zipCodeText.sendKeys("42100");

        BilgeFunc.Bekle(2);

        WebElement estShipBut = driver.findElement(By.name("estimateshipping")); // est shipping butonu
        estShipBut.click();

        BilgeFunc.Bekle(2);

        WebElement ground = driver.findElement(By.xpath("(//strong[@class='option-name'])[1]"));
        Assert.assertTrue("Kargolama görüntülenemedi...", ground.getText().contains("Ground")); // kargo seçeneği kontrolü

        WebElement iAgreeCheckBox = driver.findElement(By.id("termsofservice"));
        iAgreeCheckBox.click();

        WebElement checkOutBut = driver.findElement(By.cssSelector("[class='button-1 checkout-button']"));
        checkOutBut.click();

        BilgeFunc.Bekle(2);

       // WebElement selectMenu5 = driver.findElement(By.id("billing-address-select"));
       // Select newAddress = new Select(selectMenu5);
       // newAddress.selectByVisibleText("New Address");

        WebElement selectMenu3 = driver.findElement(By.name("BillingNewAddress.CountryId")); // sipariş tamamlama adımındaki ülke seçimi
        Select countrySelect2 = new Select(selectMenu3);
        countrySelect2.selectByVisibleText("Turkey");

        WebElement cityTextBox = driver.findElement(By.name("BillingNewAddress.City")); // sipariş tamamlama adımındaki şehir girişi
        cityTextBox.sendKeys("Ankara");

        WebElement address1TextBox = driver.findElement(By.name("BillingNewAddress.Address1")); // sipariş tamamlama adımındaki adres girişi
        address1TextBox.sendKeys("Oran");

        WebElement postalCodeText = driver.findElement(By.name("BillingNewAddress.ZipPostalCode"));
        postalCodeText.sendKeys("06030"); // sipariş tamamlama adımındaki posta kodu girişi

        WebElement phoneNumberText = driver.findElement(By.name("BillingNewAddress.PhoneNumber"));
        phoneNumberText.sendKeys("+905012698547"); // sipariş tamamlama adımındaki telefon girişi

        WebElement continueButton = driver.findElement(By.cssSelector("[onclick='Billing.save()']"));
        continueButton.click(); // continue butonuna tıkladım

        WebElement inStorePickupCheck = driver.findElement(By.cssSelector("[onclick='Shipping.togglePickUpInStore(this)']"));
        inStorePickupCheck.click(); // mağazadan teslim seçeneği

        WebElement kaybolanYazi = driver.findElement(By.cssSelector("[style='display: none']"));
        Assert.assertTrue("Seçenek kaybolmadı...", kaybolanYazi.isEnabled());

        WebElement continueButton2 = driver.findElement(By.cssSelector("[onclick='Shipping.save()']"));
        continueButton2.click();

        WebElement cashOnDelivery = driver.findElement(By.id("paymentmethod_0"));
        cashOnDelivery.click();

        WebElement continueButton3 = driver.findElement(By.cssSelector("[onclick='PaymentMethod.save()']"));
        continueButton3.click();

        WebElement checkPayInformation = driver.findElement(By.xpath("//tr/td/p"));
        Assert.assertTrue("Ödeme yöntemi farklı...", checkPayInformation.getText().contains("COD"));

        WebElement continueButton4 = driver.findElement(By.cssSelector("[onclick='PaymentInfo.save()']"));
        continueButton4.click();

        WebElement productPrice = driver.findElement(By.xpath("(//span[@class='product-price'])[1]"));
        double productPr = Double.parseDouble(productPrice.getText());

        WebElement paymentMet = driver.findElement(By.xpath("(//span[@class='product-price'])[3]"));
        double payMet = Double.parseDouble(paymentMet.getText());

        WebElement totalPrice = driver.findElement(By.xpath("//span[@class='product-price order-total']/strong"));
        double totalPrice1 = Double.parseDouble(totalPrice.getText());;

        Assert.assertTrue("Tutarlar hatalı...", (productPr+payMet == totalPrice1));

        WebElement continueButton5 = driver.findElement(By.cssSelector("[onclick='ConfirmOrder.save()']"));
        continueButton5.click();

        BilgeFunc.Bekle(2);

        WebElement basariliOdeme = driver.findElement(By.xpath("//div/strong"));
        Assert.assertTrue("Sipariş oluşturulamadı...", basariliOdeme.getText().contains("successfully"));

        WebElement continueButton6 = driver.findElement(By.cssSelector("[class='button-2 order-completed-continue-button']"));
        continueButton6.click();

        // Profile Giriş

        WebElement profil=driver.findElement(By.cssSelector("[class='header-links']>ul>li>[class='account']"));
        profil.click();
        // orders Giriş
        bekle.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='active']")));
        WebElement orders=driver.findElement(By.cssSelector("[class='active']"));
        orders.click();
        // Sipariş Özetine Giriş

        WebElement details=driver.findElement(By.xpath("//ul[@class='list']/li[3]/a"));
        details.click();
        // Özeti İndirme
        bekle.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.buttons > input[type='button']")));
        WebElement pdfBtn=driver.findElement(By.cssSelector("div.buttons > input[type='button']"));
        pdfBtn.click();







        MyFunction.wait(10);
        driver.quit();


    }
}
