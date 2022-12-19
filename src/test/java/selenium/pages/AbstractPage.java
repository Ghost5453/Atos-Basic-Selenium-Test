package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    private final static int TIMEOUT = 30;

    private WebDriver driver;
    private WebDriverWait wait;

    public AbstractPage(WebDriver myDriver)
    {
        driver = myDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
