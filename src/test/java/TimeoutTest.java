import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ExtendWith(SeleniumExtension.class)
public class TimeoutTest {
        private static FirefoxDriver driver;

        public TimeoutTest(FirefoxDriver driver) {
            this.driver = driver;
        }

        @Test
        public void testPageLoadTimeout(){
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            driver.get("https://duckduckgo.com/");
            driver.findElement(By.id("search_form_input_homepage")).sendKeys("trojmiasto");
            driver.findElement(By.id("search_button_homepage")).click();
            assertTrue(driver.getCurrentUrl().contains("https://duckduckgo.com/?q=trojmiasto"));
        }

        @Test
        public void testSetScriptTimeout(){
             driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
             driver.get("https://duckduckgo.com/");
             driver.findElement(By.id("search_form_input_homepage")).sendKeys("trojmiasto");
             driver.findElement(By.id("search_button_homepage")).click();
             assertTrue(driver.getCurrentUrl().contains("https://duckduckgo.com/?q=trojmiasto"));
       }
}
