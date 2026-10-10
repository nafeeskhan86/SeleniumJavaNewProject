import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LoginTest {
    @Test
    public void loginToApplication()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/");
        driver.findElement(By.id("userEmail")).sendKeys("nafees.mca07@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Khan@123");
        driver.findElement(By.id("login")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("button[routerlink='/dashboard/']")
        ));
        List<WebElement> listOfMenu = driver.findElements(By.cssSelector(".btn-custom"));
        System.out.println(listOfMenu.size());
        List<String> menuName = listOfMenu.stream().map(WebElement::getText).toList();
        System.out.println(menuName);

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

        driver.quit();

    }
}
