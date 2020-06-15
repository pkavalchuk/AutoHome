package Ozby;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OzBy3 {
    public static void main(String[] args){
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://oz.by");

        WebElement sale = webDriver.findElement(By.xpath("//*[@id=\"top-page\"]/div[1]/div[2]/ul/li[3]/a"));
        sale.click();

        Set<String> s = webDriver.getWindowHandles();
        for (String s1: webDriver.getWindowHandles()) {
            webDriver.switchTo().window(s1);
        }
        WebElement close = webDriver.findElement(By.xpath("/html/body/small/center/a"));
        close.click();

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.quit();
    }
}
