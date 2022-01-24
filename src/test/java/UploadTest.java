import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class UploadTest {

    @Test
    public void uploadFile() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\euler\\Desktop\\sample.txt");

        Long currentTime = new Date().getTime();

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src/test/resources/screenshot" + currentTime +".png"));

        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();



    }
}
