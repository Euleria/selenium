import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CSSSelectorsTest {

    @Test
    public void findElements() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("First");

        By cssAttribute = By.cssSelector("[name='fname']");
        driver.findElement(cssAttribute);

        By cssClass2 = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClass2);

        By all = By.cssSelector("*");
        driver.findElement(all);

        By ulInDiv = By.cssSelector("div ul");
        driver.findElement(ulInDiv);

        By trInTable = By.cssSelector("table tr");
        driver.findElement(trInTable);

        By trInTBody = By.cssSelector("tBody tr");
        driver.findElement(trInTBody);

        By firstChildUlInDiv = By.cssSelector("div > ul");
        driver.findElement(firstChildUlInDiv);

        By firstChildTrInTBody = By.cssSelector("tBody tr");
        driver.findElement(firstChildTrInTBody);

        By firstFormAfterLabel = By.cssSelector("label + form");
        driver.findElement(firstFormAfterLabel);

        By allFormsAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(allFormsAfterLabel);

        By attributeTag = By.cssSelector("input[name='fname']");
        driver.findElement(attributeTag);

        By attributeContains = By.cssSelector("input[name*='nam']");
        driver.findElement(attributeContains);

        By attributeStarts = By.cssSelector("input[name^='fn']");
        driver.findElement(attributeStarts);

        By attributeEnds = By.cssSelector("input[name$='me']");
        driver.findElement(attributeEnds);

        By firstChild = By.cssSelector("li:first-child");
        driver.findElement(firstChild);

        By lastChild = By.cssSelector("li:last-child");
        driver.findElement(lastChild);

        By thirdChild = By.cssSelector("li:nth-child(3)");
        driver.findElement(thirdChild);

    }
}
