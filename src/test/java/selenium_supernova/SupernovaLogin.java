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
import java.util.ArrayList;
import java.util.NoSuchElementException;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class SupernovaLogin {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    @Before

    public void openHomePage() throws InterruptedException{
        driver.get("https://www.supernova.io/");
        driver.manage().window().maximize();
        Thread.sleep(6000);
    }
    @Test

    public void login_ejecuta () throws InterruptedException{
        Supernova_login();
        Supernova_login_documentation();
        supernova_login_design_token();
        supernova_login_search();

    }

    public void Supernova_login() throws InterruptedException {
        AcceptCookies();
        assert driver.getWindowHandles().size() == 1;
        WebElement login = driver.findElement(By.xpath("//a[contains(@href, 'https://app.supernova.io/?_gl=1*13xcr94*_ga*MjEyNTM4NDc4OC4xNzA4MDk0NTc4*_ga_MQWTX6KRP3*MTcwOTA0NzU3MC4xNi4wLjE3MDkwNDc1NzAuNjAuMC4w')]"));
        login.click();
        Thread.sleep(3000);
        wait.until(numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualurl= driver.getCurrentUrl();
        if (actualurl.contains("https://auth.supernova.io/")){
            Thread.sleep(5000);
            WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder, 'email')]"));
            Thread.sleep(5000);
            email.sendKeys("andreabeltranluque@gmail.com");
            WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder, 'password')]"));
            password.sendKeys("Andi1218");
            WebElement loginButton = driver.findElement(By.xpath("//button[contains(@type, 'submit')]"));
            loginButton.click();
            Thread.sleep(5000);
        }else{
            System.out.println(actualurl);
            String title_page = driver.getTitle();
            System.out.println(title_page);
            System.out.println("No se puede ingresar por que esta en la pestaña equivocada");
        }

    }

    public void Supernova_login_documentation() throws InterruptedException{
        Thread.sleep(5000);
        WebElement documentation = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div[1]/div[1]/div[1]/a[1]/div/div/div[2]"));
        documentation.click();
        Thread.sleep(5000);
        WebElement welcome = driver.findElement(By.xpath("//div[@class='max-w-[165px] overflow-hidden text-ellipsis whitespace-nowrap text-primary']"));
        welcome.click();
        Thread.sleep(5000);
        try{
            WebElement design_token = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div/div[3]/div/div[2]/div[2]/div[2]/div[1]/a/div/div/div[2]/div[1]/span"));
            design_token.click();
            Thread.sleep(3000);
        }catch (NoSuchElementException e){
            WebElement foundations = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div/div[3]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/span"));
            foundations.click();
            Thread.sleep(3000);
            WebElement design_token = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div/div[3]/div/div[2]/div[2]/div[2]/div[1]/a/div/div/div[2]/div[1]/span"));
            design_token.click();
            Thread.sleep(3000);
        }
    }

    public void supernova_login_design_token() throws InterruptedException{
        Thread.sleep(5000);
        WebElement design_token = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div[1]/div[1]/div[1]/a[2]/div/div/div[2]"));
        design_token.click();
        Thread.sleep(3000);
        WebElement design_token_typography = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div/div/div[2]/div[1]/div[2]/a/div/div[1]/div[2]"));
        design_token_typography.click();
        Thread.sleep(3000);
        WebElement design_token_visibility = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div/div/div[2]/div[3]/div[4]/a/div/div[1]/div"));
        design_token_visibility.click();
        Thread.sleep(3000);
    }

    public void supernova_login_search() throws InterruptedException{
        WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div[1]/div[2]/button[1]/div/div"));
        search.click();
        Thread.sleep(3000);
        WebElement box_search = driver.findElement(By.xpath("//input[@role='combobox']"));
        box_search.sendKeys("Search tokens");
        Thread.sleep(3000);
        WebElement select_search = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[5]/div/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div"));
        select_search.click();
        Thread.sleep(3000);
        WebElement close_emer_win = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[5]/div/button"));
        close_emer_win.click();
        Thread.sleep(3000);

    }

    public void AcceptCookies() throws InterruptedException{
        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();
        Thread.sleep(3000);
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

}
