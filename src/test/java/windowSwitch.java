import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class windowSwitch {
    @Test
    public void windowSwitchTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        String password = driver.findElement(
                        By.cssSelector("p.text-center.text-white b:nth-of-type(2) i"))
                .getText();

        System.out.println(password);
        String originalWindowHandle = driver.getWindowHandle();
        driver.findElement(By.partialLinkText("Free Access")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getWindowHandles().size()==2);

        for(String handle: driver.getWindowHandles())
        {
            if(!handle.equals(originalWindowHandle))
            {
                driver.switchTo().window(handle);
                break;
            }
        }
        String  para =driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println(para);
        String username = para.split("@")[1].split("\\.com")[0];
        System.out.println(username);
        driver.switchTo().window(originalWindowHandle);


        driver.quit();
    }
}
