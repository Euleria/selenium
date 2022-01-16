import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SelectorTest {

    @Test
    public void findElements() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement clickOnMeButton = driver.findElement(By.id("clickOnMe"));
        WebElement fNameInput = driver.findElement(By.name("fname"));
        fNameInput.sendKeys("Max");
        WebElement topSecretPar = driver.findElement(By.className("topSecret"));
        ArrayList<WebElement> inputs = new ArrayList();
        inputs.addAll(driver.findElements(By.tagName("input")));
        System.out.println("Input size " + inputs.size());

        driver.findElement(By.linkText("Visit W3Schools.com!"));
        driver.findElement(By.partialLinkText("Visit"));


    }
}
