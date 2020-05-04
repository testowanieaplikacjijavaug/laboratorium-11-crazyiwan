import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class ElementPresentTest {

    //Przykłady znajdowania elementów na stronie www bez elementów xpath

    private static WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);
        driver = new FirefoxDriver(firefoxOptions);
        // Implicity wait -> max czas na znalezienie elementu na stronie
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setDefaultPage() throws Exception{
        driver.get("https://www.google.pl");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }


    boolean isElementPresent(By by){
        try {
            driver.findElement(by);
                    return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    @Test
    public void findById() {
        assertTrue(isElementPresent(By.id("searchform")));
    }

    @Test
    public void findByName() {
        assertTrue(isElementPresent(By.name("q")));

    }

    @Test
    public void findByClass() {
        assertTrue(isElementPresent(By.className("gsfi")));
    }

    @Test
    public void findBylinkText() {
        assertTrue(isElementPresent(By.linkText("Gmail")));
    }

    @Test
    public void findByPartiallinkText() {
        assertTrue(isElementPresent(By.partialLinkText("ma")));
    }

    @Test
    public void findByTagName() {
        assertTrue(isElementPresent(By.tagName("div")));
    }

    @Test
    public void findByCssSelector() {
        assertTrue(isElementPresent(By.cssSelector("input.gsfi")));
    }




}
