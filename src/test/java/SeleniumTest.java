import com.google.common.annotations.VisibleForTesting;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class SeleniumTest {

    @Test
    public void openGooglePage () {
        WebDriver driver = getDriver("edge");
        driver.get("https://www.google.pl/");

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
