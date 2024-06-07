
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

public class SupernovaFeatures {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    @Before

    public void openHomePage() throws InterruptedException{
        driver.get("https://www.supernova.io/");
        driver.manage().window().maximize();
        Thread.sleep(6000);
    }
    @Test
    public void ejecutar() throws InterruptedException {
        features();
        features_documentation();
        features_design_system();
        features_code_automation();
        features_design_tokens();
        features_integrations();
        features_forge();

    }

    public void features() throws InterruptedException {
        AcceptCookies();
        Thread.sleep(3000);
        menu_features();
        Thread.sleep(3000);
    }
    public void features_documentation() throws InterruptedException {
        home_page();
        features();
        WebElement documentation = driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-0\"]/a[1]"));
        documentation.click();
        Thread.sleep(3000);

    }
    public void features_design_system() throws InterruptedException {
        home_page();
        features();
        Thread.sleep(3000);
        WebElement design_system = driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-0\"]/a[2]"));
        design_system.click();
        Thread.sleep(3000);
    }
    public void features_code_automation() throws InterruptedException {
        home_page();
        menu_features();
        WebElement code_automation = driver.findElement(By.xpath("/html/body/nav/div/div/div/div[2]/div[1]/div[1]/nav/a[3]"));
        code_automation.click();
        Thread.sleep(3000);
    }
    public void features_forge() throws InterruptedException {
        home_page();
        menu_features();
        WebElement forge = driver.findElement(By.xpath("/html/body/nav/div/div/div/div[2]/div[1]/div[1]/nav/a[4]"));
        forge.click();
        Thread.sleep(3000);
    }
    public void features_design_tokens() throws InterruptedException {
        home_page();
        menu_features();
        WebElement design_tokens = driver.findElement(By.xpath("/html/body/nav/div/div/div/div[2]/div[1]/div[1]/nav/a[5]"));
        design_tokens.click();
        Thread.sleep(3000);
    }
    public void features_integrations() throws InterruptedException {
        home_page();
        menu_features();
        WebElement integrations = driver.findElement(By.xpath("/html/body/nav/div/div/div/div[2]/div[1]/div[1]/nav/a[6]"));
        integrations.click();
        Thread.sleep(3000);
    }

    public void home_page() throws InterruptedException {
        WebElement home = driver.findElement(By.xpath("/html/body/nav/div/div/div/div[2]/div[1]/div[1]/div/div[2]"));
        home.click();
        Thread.sleep(3000);
    }

    public void menu_features() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-0\"]/div[1]")).click();
        Thread.sleep(3000);

    }
    public void AcceptCookies() throws InterruptedException{
        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();
        Thread.sleep(3000);
    }


}
