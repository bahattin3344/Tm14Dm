

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait bekle;
    static {    // eğer puclic static void DriverBaslat yazısını silip sadece static yazarsak programı her çalıştırdığımızda en başta bu çalışır
        Logger logger=Logger.getLogger("");
        logger.setLevel(Level.SEVERE); // sadece hata olan yazıları göster program açıldığında (sistem güncellemelerini kırmızı göstermeyecek artık)
        driver=new ChromeDriver();
        driver.manage().window().maximize(); // açılan ekranı tam ekran açmayı sağlıyor
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 30 saniyede chrome da sayfa açılmazsa kapat
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 30 saniye elementi bulma süresi verdik
        bekle=new WebDriverWait(driver,Duration.ofSeconds(20));  // elemente özel bekleme kısmı oluşturduk
    }
    public static void DriverKapat(){
        MyFunction.wait(3);
        driver.quit();
    }
}