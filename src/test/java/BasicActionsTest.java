import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class BasicActionsTest {

    @Test
    public void performAction() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium");

        driver.findElement(By.linkText("Podstawowa strona testowa")).click();
        driver.findElement(By.id("fname")).sendKeys("Kasia");
        //driver.findElement(By.id("fname")).clear();



        System.out.println("Text" + driver.findElement(By.id("fname")).getText());
        driver.findElement(By.xpath("//input[@type='radio' and @value='other']")).click();




        Select car = new Select(driver.findElement(By.cssSelector("select")));
        car.selectByValue("audi");
        System.out.println(car.getAllSelectedOptions().get(0).getText());
        //car.selectByIndex(2);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        System.out.println(driver.findElement(By.name("username")).getAttribute("value"));
        driver.findElement(By.name("username")).sendKeys(Keys.ENTER);

        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        System.out.println(isOption("Mercedes"));
    }

    public boolean isOption(String option) {

        boolean result=false;

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium");
        driver.findElement(By.linkText("Podstawowa strona testowa")).click();

        Select cars = new Select(driver.findElement(By.cssSelector("select")));
        List<WebElement> carsOptions= cars.getOptions();

        int i=0;
        while (i<carsOptions.size() && !carsOptions.get(i).getText().equals(option)) {

            System.out.println(carsOptions.get(i).getText() + " " + option + " " + result);
            i++;
        }
        return result = i<carsOptions.size();
    }
}
