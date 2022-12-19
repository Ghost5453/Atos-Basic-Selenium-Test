package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestBasicWebTest
{
    private WebDriver driver;
    private WebDriverWait wait;

    //Runs before each test
    @BeforeEach
    public void initialiseDriver()
    {
        //Initialises the driver
        driver = new FirefoxDriver();

        //Initialises a wait element
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void searchDuckDuckGo()
    {
        WebElement searchInput;
        WebElement searchButt;
        List<WebElement> results;

        //Lod Page
        driver.get("https://duckduckgo.com/");                                                                   //Load the web page

        //Enter search
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("search_form_input_homepage")));                                                          //This halts the process until a condition is met in this case the element has loaded, this guarantees that the element is found.
        searchInput = driver.findElement(By.id("search_form_input_homepage"));                                  //Finds the element
        searchInput.sendKeys("giant panda");                                                        //Inputs text in the box

        //Click search
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_button_homepage")));             //The button clicking can use the same process as the search but using click, instead of send keys
        searchButt = driver.findElement(By.id("search_button_homepage"));
        searchButt.click();

        //Wait
        wait.until(ExpectedConditions.titleContains("giant panda"));                                            //Waits for the page to lode
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.results div.nrn-react-div")));                                              //Waits for the results to lode

        //Check
        results = driver.findElements(By.cssSelector("div.results h2 span"));                                   //Used to find the links

        for (WebElement result: results)
        {
            Assertions.assertTrue(result.getText().matches("(?i).*panda.*"));                            //Runs the check using regex. the (?i) means that it is case independent, .*panda.* is used to check if the string contains the word panda
        }

    }

    @AfterEach
    public void quitDriver()
    {
        driver.quit();
    }
}
