import org.awaitility.Awaitility;
import org.awaitility.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLogger;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class SeleniumUtils {

    static Long defaultWait = 5L;
    Actions action;
    WebDriver webDriver;

    SeleniumUtils(WebDriver webDriver){
        this.webDriver = webDriver;
        action = new Actions(webDriver);
    }
    public WebElement getWebElement(String elementPath) throws Exception {
        waitTillWebElement(elementPath);
        return webDriver.findElement(By.xpath(elementPath));
    }

    private void waitTillWebElement(String elementPath) throws Exception {
        try {
            await().atMost(defaultWait, SECONDS).ignoreExceptions().pollInterval(new Duration(1, SECONDS)).until(() -> {
               try {
                   webDriver.findElement(By.xpath(elementPath));
                   return true;
               }catch (Exception e){
                return false;
               }
            });
        } catch (Exception e) {
            throw new Exception("Gotten exception within find element of " + elementPath + " and the exception is:\n" + e.getMessage());
        }
    }

    public List<WebElement> getWebElements(String elementPath) throws Exception {
        waitTillWebElement(elementPath);
        return webDriver.findElements(By.xpath(elementPath));
    }

    public Actions getAction(){
        return action;
    }
}
