import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Properties;

public abstract class InitTest {
    WebDriver webDriver;
    public Properties properties;
    SeleniumUtils seleniumUtils;

    @Before
    public void initTest() throws IOException {
        webDriver = new ChromeDriver();
        seleniumUtils = new SeleniumUtils(webDriver);
        properties = new Properties();
        properties.load(new FileInputStream("myProperties.properties"));
    }

    @After
    public void cleanup(){
        webDriver.close();
    }
    public WebDriver getWebDriver(){
        return webDriver;
    }

    public static void printLog(String log){
        System.out.print(log);
    }
}
