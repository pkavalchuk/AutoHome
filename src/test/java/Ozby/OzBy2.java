package Ozby;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OzBy2 {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://oz.by");
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<String> exRes = new ArrayList<>();
        exRes.add("Продукты, деликатесы");
        exRes.add("Книги");
        exRes.add("Косметика, парфюмерия");
        exRes.add("Дом, сад, зоотовары");
        exRes.add("Развлечения, творчество");
        exRes.add("Канцтовары, учёба");
        exRes.add("Сувениры, подарки");
        exRes.add("Детям и мамам");
        exRes.add("Туризм, отдых, спорт");
        exRes.add("Техника, электроника");
        exRes.add("Здоровье, медтехника");

        List<WebElement> result = webDriver.findElements(By.xpath("//li[@class = 'main-nav__list__li main-nav__list__li_wnav']"));
        List<String> acRes = new ArrayList<>();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println(acRes.size());
        for (WebElement element : result){
            acRes.add(element.getText());
        }

        if (exRes.equals(acRes)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        webDriver.quit();
    }
}
