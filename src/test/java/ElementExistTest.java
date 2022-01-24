import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExistTest {

    WebDriver driver;

    @Test
    public void elementExistTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        System.out.println(elementExist2(By.tagName("p")));
        System.out.println(elementExist2(By.id("topSecret")));

        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());

        System.out.println(driver.findElement(By.cssSelector("[type='checkbox']")).isSelected());
        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        System.out.println(driver.findElement(By.cssSelector("[type='checkbox']")).isSelected());
    }

    public boolean elementExist(By locator) {

        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean elementExist2(By locator) {
        return driver.findElements(locator).size()>0;
    }
}
