package Bilgehan;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SiparisVerme extends BaseDriver {
    @Test
    public void SiparisVerme(){
        driver.get("https://demowebshop.tricentis.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='ico-login']")));
        WebElement logIn= driver.findElement(By.cssSelector("[class='ico-login']")); // loh in butonuna tıkladık
        logIn.click();

        WebElement emailGiris=driver.findElement(By.cssSelector("#Email"));
        emailGiris.sendKeys("tecnostudy123@gmail.com"); // emailimizi girdik

        WebElement passwordGiris=driver.findElement(By.cssSelector("#Password"));
        passwordGiris.sendKeys("Denizan561"); // şifremizi girdik

        WebElement girisBtn=driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        girisBtn.click(); // login butonuna bastık

        MyFunction.Bekle(2);

        WebElement addToCartBut = driver.findElement(By.xpath("(//input[@class = 'button-2 product-box-add-to-cart-button'])[2]"));
        addToCartBut.click(); // herhangi bir ürünü seçip sepete ekledik

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
        // işlem başarılı yazısı görünene kadar bekledik

        MyFunction.Bekle(2);

        JavascriptExecutor js=(JavascriptExecutor)driver;

        WebElement shoppingCartButton = driver.findElement(By.xpath("//span[text()='Shopping cart']")); // sepetim yazısını bulduk
        js.executeScript("window.scrollTo(0, 0);");
        shoppingCartButton.click();

        MyFunction.Bekle(2);

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

        MyFunction.Bekle(2);

        WebElement estShipBut = driver.findElement(By.name("estimateshipping")); // est shipping butonu
        estShipBut.click();

        MyFunction.Bekle(2);

        WebElement ground = driver.findElement(By.xpath("(//strong[@class='option-name'])[1]"));
        Assert.assertTrue("Kargolama görüntülenemedi...", ground.getText().contains("Ground")); // kargo seçeneği kontrolü

        WebElement iAgreeCheckBox = driver.findElement(By.id("termsofservice"));
        iAgreeCheckBox.click();

        WebElement checkOutBut = driver.findElement(By.cssSelector("[class='button-1 checkout-button']"));
        checkOutBut.click();

        MyFunction.Bekle(2);

        WebElement selectMenu5 = driver.findElement(By.id("billing-address-select"));
        Select newAddress = new Select(selectMenu5);
        newAddress.selectByVisibleText("New Address");

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

        MyFunction.Bekle(2);

        WebElement basariliOdeme = driver.findElement(By.xpath("//div/strong"));
        Assert.assertTrue("Sipariş oluşturulamadı...", basariliOdeme.getText().contains("successfully"));

        WebElement continueButton6 = driver.findElement(By.cssSelector("[class='button-2 order-completed-continue-button']"));
        continueButton6.click();

        BekleVeKapat();
    }
}
