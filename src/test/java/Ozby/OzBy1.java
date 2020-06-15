package Ozby;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OzBy1 {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://oz.by");

        WebElement checkout = webDriver.findElement(By.xpath("//*[@href=\"/checkout/\"]"));
        checkout.click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement checkoutIsEmpty = webDriver.findElement(By.xpath("//*[@id=\"top-page\"]/div[2]/div/div[1]/div/div"));
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (checkoutIsEmpty.isDisplayed()) {
            System.out.println("Checkout is empty");
        } else {
            System.out.println("Checkout is full");
        }

        webDriver.navigate().back();
        WebElement searchField = webDriver.findElement(By.xpath("//*[@id=\"top-s\"]"));
        searchField.sendKeys("Программирование");
        searchField.submit();

        WebElement book = webDriver.findElement(By.xpath("//*[@id=\"goods-table\"]/li[1]/div/div/div/a"));
        book.click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement add = webDriver.findElement(By.xpath("//button[contains(@class, 'addtocart-btn')]"));
        add.click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement checkout2 = webDriver.findElement(By.xpath("//*[@href=\"/checkout/\"]"));
        checkout2.click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement check = webDriver.findElement(By.xpath("//*[@id=\"goods-block\"]/tbody/tr[2]/td[1]/div/div[2]/div[2]"));
        if (check.isDisplayed()) {
            System.out.println("Good was added");
        } else {
            System.out.println("Checkout is empty");
        }
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.quit();
    }
}
