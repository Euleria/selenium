import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class XPathTest {

    @Test
    public void findElements() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement clickOnMeButton = driver.findElement(By.xpath("//button[@id='clickOnMe']"));

        WebElement fNameInput = driver.findElement(By.xpath("//input[@name='fname']"));

        WebElement topSecretPar = driver.findElement(By.xpath("//p[@class='topSecret']"));


        ArrayList<WebElement> inputs = new ArrayList();
        inputs.addAll(driver.findElements(By.xpath("//input")));
        System.out.println("Input size " + inputs.size());

        driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));
        driver.findElement(By.xpath("//a[contains(text(),'Visit')]"));


        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);

        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementWithAttribute = By.xpath("//*[@name]");
        driver.findElement(elementWithAttribute);

        By AttributeEq = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(AttributeEq);

        By elementContainsText = By.xpath("//*[contains(@name,'ame')]");
        driver.findElement(elementContainsText);

        By elementStartsWith = By.xpath("//*[starts-with(@name,'f')]");
        driver.findElement(elementStartsWith);

        By elementEndsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('name')+1)='name']");
        driver.findElement(elementEndsWith);

        By child = By.xpath("//div/child::ul");
        driver.findElement(child);

        By desc = By.xpath("//div/descendant::ul");
        driver.findElement(desc);

        By parent = By.xpath("//div/../..");
        driver.findElement(parent);

        By asc = By.xpath("//div/ancestor::*");
        driver.findElement(asc);

        By foll = By.xpath("//img/following::*");
        driver.findElement(foll);

        By follSib = By.xpath("//img/following-sibling::*"); //powyżej na tym samym poziomie
        driver.findElement(follSib);

        By prec = By.xpath("//img/preceding::*");
        driver.findElement(prec);

        By precSib = By.xpath("//img/preceding-sibling::*");
        driver.findElement(precSib);

        By divAndLinks = By.xpath("//a | //div");
        driver.findElement(divAndLinks);

        By andOp = By.xpath("//input[@name='fname' and @id='fname'] | //input");
        driver.findElement(andOp);

        By orOp = By.xpath("//input[@name='fname' or @id='fnam'] | //input");
        driver.findElement(orOp);
    }
}
