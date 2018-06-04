import javafx.beans.property.SetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import java.util.List;

import static java.lang.Thread.sleep;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        SkriptA();
        SkriptB();


    }

    private static void SkriptA() {
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminLogin&token=d251f363cceb5a849cb7330938c64dea");
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");
        WebElement pass = driver.findElement(By.id("passwd"));
        pass.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();
        WebElement employeeAvatar = driver.findElement(By.className("employee_avatar_small"));
        employeeAvatar.click();
        WebElement exit = driver.findElement(By.id("header_logout"));
        exit.click();
        driver.quit();
    }

    private static void SkriptB() throws InterruptedException {
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminLogin&token=d251f363cceb5a849cb7330938c64dea");
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");
        WebElement pass = driver.findElement(By.id("passwd"));
        pass.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();
        List<WebElement> items = driver.findElements(By.xpath("//*[@class=\"maintab  has_submenu\"]/a/span"));
        for( int i = 0; i<items.size(); i++){
            String itemName = items.get(i).getText();
            System.out.println(itemName);
            driver.navigate().refresh();
            sleep(300);
            items = driver.findElements(By.xpath("//*[@class=\"maintab  has_submenu\"]/a/span"));
            if(items.get(i).getText().compareTo(itemName) == 0){
                System.out.println("Имя пункта не совпадает после рефреша " + itemName);
            }
            driver.quit();

        }

    }

    private static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver",Test.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
}
