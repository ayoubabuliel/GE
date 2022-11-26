import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;

import java.util.Locale;

public class TestUI extends InitTest{

    String websiteURL="https://www.google.co.il";

    @Test
    public void test1() throws Exception {
        webDriver.get(websiteURL);
        seleniumUtils.getWebElement(properties.getProperty("Google.SearchInput")).sendKeys("java");
//        seleniumUtils.getAction().sendKeys(Keys.ESCAPE).perform();
        seleniumUtils.getWebElement(properties.getProperty("Google.SubmitButton")).click();
        printLog("The links of 'java' are:\n");
        seleniumUtils.getWebElements(properties.getProperty("Google.PageLinks")).
                forEach(webElement->printLog(webElement.getText().equals("")?"":webElement.getText() + "\n"));
        String firstLinkText = seleniumUtils.getWebElements(properties.getProperty("Google.PageLinks")).get(0).getText();
        Assert.assertTrue
                (String.format("The first link doesn't contains 'java' text, The first link text is '%s'", firstLinkText)
                        , firstLinkText.toLowerCase(Locale.ROOT).contains("java"));
    }

}
