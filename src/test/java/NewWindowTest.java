import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {

    @Test
    public void testNewWIndow() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium");
        driver.findElement(By.linkText("Podstawowa strona testowa")).click();

        String currentWindow = driver.getWindowHandle();

        driver.findElement(By.id("newPage")).click();
        Set<String> allWindows = driver.getWindowHandles();

        for(String window: allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.xpath("//div[contains(text(),'Zgadzam')]")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //System.out.println(driver.getTitle());
    }
}
