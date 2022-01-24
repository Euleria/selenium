import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test
public class checkResult {
    public void checkResult(String PESEL, String code) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://covid19.gyncentrum.pl/wyniki-badanie-nfz");


        boolean result = false;
        String resultLink;
        do {
            Thread.sleep(60 * 1000);
            driver.findElement(By.id("pesel_aut")).sendKeys(PESEL);
            driver.findElement(By.id("nr_probki_aut")).sendKeys(code);
            driver.findElement(By.cssSelector("[onclick='sprWynikSanepid();']")).click();

            Thread.sleep(5 * 1000);
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            resultLink = driver.findElement(By.id("wynik_link")).getText();

            System.out.println("resultLink " + resultLink);
        }
        while (resultLink.equals("Wynik nie jest jeszcze dostępny."));

        System.out.println("Wynik jest dostępny!!!!!");
    }
}
