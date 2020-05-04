import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import java.util.List;
@ExtendWith(SeleniumExtension.class)
public class WaitinTest {
    private static FirefoxDriver driver;

    public WaitinTest(FirefoxDriver driver) {
        this.driver = driver;
    }

    @Test
    public void testElementToBeClickable(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("trojmiasto");
        driver.findElement(By.id("search_button_homepage")).click();
        List<WebElement> linkList = driver.findElements(By.className("result__a"));
        wait.until(ExpectedConditions.elementToBeClickable(linkList.get(0)));
        assertEquals("trojmiasto at DuckDuckGo",driver.getTitle());
    }
    @Test
    public void testElementToBeSelected(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("trojmiasto");
        driver.findElement(By.id("search_button_homepage")).click();
        assertThrows(TimeoutException.class, () ->
                wait.until(ExpectedConditions.elementToBeSelected(By.linkText("abcsadfasdsa"))));

    }
    
    @Test
    public void testTextToBePresentInElement(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("trojmiasto");
        driver.findElement(By.id("search_button_homepage")).click();
        List<WebElement> linkList = driver.findElements(By.className("result__a"));
        wait.until(ExpectedConditions.textToBePresentInElement(linkList.get(1),"Wyborcza"));
        linkList.get(1).click();
        assertTrue(driver.getCurrentUrl().contains("wyborcza"));
    }

    @Test
    public void testTextToBePresentInElementValue(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("trojmiasto");
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("search_form_input_homepage")
                ,"trojmiasto"));
        driver.findElement(By.id("search_button_homepage")).click();
        List<WebElement> linkList = driver.findElements(By.className("result__a"));
        linkList.get(1).click();
        assertTrue(driver.getCurrentUrl().contains("wyborcza"));

    }

    @Test
    public void testTitleContains(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("trojmiasto");
        driver.findElement(By.id("search_button_homepage")).click();
        List<WebElement> linkList = driver.findElements(By.className("result__a"));
        linkList.get(1).click();
        wait.until(ExpectedConditions.titleContains("Trójmiasto.Wyborcza.pl - Najnowsze wiadomości z Trójmiasta"));
        assertTrue(driver.getCurrentUrl().contains("wyborcza"));
    }


}
