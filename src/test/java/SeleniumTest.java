import com.google.common.annotations.VisibleForTesting;


import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class SeleniumTest {

    @Test
    public void openGooglePage () {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.pl/");

        driver.findElement(By.xpath("//div[contains(text(),'Zgadzam się')]")).click();

        driver.switchTo().defaultContent();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]"));

        Assert.assertTrue(result.isDisplayed());


    }

    public WebDriver getDriver (String browser) {
        String path;
        WebDriver driver;
        switch (browser) {
            case "chrome":
                //path = "C:\\Users\\euler\\Downloads\\chromedriver_win32\\chromedriver.exe";
                //System.setProperty("webdriver.chrome.driver",path);
                driver = new ChromeDriver();
                break;
            case "firefox":
                //path = "C:\\Users\\euler\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe";
                //System.setProperty("webdriver.gecko.driver",path);
                driver = new FirefoxDriver();
                break;
            case "edge":
                //path = "C:\\Users\\euler\\Downloads\\edgedriver_win64\\msedgedriver.exe";
                //System.setProperty("webdriver.edge.driver",path);
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        return driver;
    }
}
