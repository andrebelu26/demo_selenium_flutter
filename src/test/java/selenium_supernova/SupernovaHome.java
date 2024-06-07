package selenium_supernova;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SupernovaHome {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        @Before

        public void openHomePage() throws InterruptedException{
            driver.get("https://www.supernova.io/");
            driver.manage().window().maximize();
            Thread.sleep(6000);
        }
        @Test

        public void ejecutar() throws InterruptedException{
            HomeGetStarted();
          //  HomeRequestaDemo();
           // closeBrowser();
        }

        public void HomeGetStarted() throws InterruptedException{
            AcceptCookies();
            Thread.sleep(6000);
            WebElement getStarted = driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div[2]/div/div[1]/a"));
            getStarted.click();
            Thread.sleep(20000);
              }

        public void HomeRequestaDemo() throws InterruptedException{
            AcceptCookies();
            Thread.sleep(6000);
            WebElement requestDemo = driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div[2]/div/div[2]/a"));
            requestDemo.click();
            Thread.sleep(20000);
        }



        public void AcceptCookies(){
            WebElement acceptCookies = driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']"));
            acceptCookies.click();
        }

        @After
        public void closeBrowser(){
            driver.quit();
        }

}
