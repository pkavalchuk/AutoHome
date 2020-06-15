package Hometask_12_06_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VkTest1 {
    private WebDriver driver = new ChromeDriver();
    private static String EMAIL;
    private static String PASSWORD;
    private WebDriverWait waiter = new WebDriverWait(driver, 10);

    @BeforeClass
    public void setCreds() {
        EMAIL = "";
        PASSWORD = "";

        driver.manage().window().maximize();
        driver.get("https://vk.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement email = driver.findElement(By.id("index_email"));
        email.sendKeys(EMAIL);

        WebElement password = driver.findElement(By.id("index_pass"));
        password.sendKeys(PASSWORD);

        WebElement button = driver.findElement(By.id("index_login_button"));
        button.click();
    }

    @Test
    public void sendMessage() {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("l_msg")));
        WebElement openMessages = driver.findElement(By.id("l_msg"));
        openMessages.click();

        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("im_dialogs")));
        WebElement search = driver.findElement(By.id("im_dialogs_search"));
        search.sendKeys("Полина");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.className("_im_dialog_link")));

        WebElement searchMyName = driver.findElement(By.xpath("//li[@data-list-id = \"50996024cr\"]"));
        searchMyName.click();

        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("im_editable0")));
        WebElement textField = driver.findElement(By.id("im_editable0"));
        textField.sendKeys("Hello world!");
        WebElement sendMessage = driver.findElement(By.xpath("//button[@class=\"im-send-btn im-chat-input--send _im_send im-send-btn_send\"]"));
        sendMessage.click();

        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = \"Hello world!\"]")));
        WebElement check = driver.findElement(By.xpath("//div[text() = \"Hello world!\"]"));
        if (check.isDisplayed()){
            driver.quit();
        } else {
            System.out.println("FAILED");
        }
    }
}
