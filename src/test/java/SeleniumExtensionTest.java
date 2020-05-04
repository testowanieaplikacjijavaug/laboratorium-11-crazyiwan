import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@ExtendWith(SeleniumExtension.class)
public class SeleniumExtensionTest {

    //Przykłady znajdowania elementów na stronie www bez elementów xpath

    private static ChromeDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
        // Implicity wait -> max czas na znalezienie elementu na stronie
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() throws Exception {
        driver.get("https://www.google.pl");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void findById() {
        WebElement element = driver.findElement(By.id("searchform"));
        assertNotNull(element);
    }

    @Test
    public void findByName() {
        WebElement element = driver.findElement(By.name("q"));
        assertNotNull(element);
    }

    @Test
    public void findByClass() {
        WebElement element = driver.findElement(By.className("gsfi"));
        assertNotNull(element);
    }

    @Test
    public void findBylinkText() {
        WebElement element = driver.findElement(By.linkText("Gmail"));
        assertNotNull(element);
    }

    @Test
    public void findByPartiallinkText() {
        WebElement element = driver.findElement(By.partialLinkText("ma"));
        assertNotNull(element);
    }

    @Test
    public void findByTagName() {
        WebElement element = driver.findElement(By.tagName("div"));
        assertNotNull(element);
    }

    @Test
    public void findByCssSelector() {
        WebElement element = driver.findElement(By.cssSelector("input.gsfi"));
        assertNotNull(element);
    }


}
