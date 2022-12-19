package selenium.test.good;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.pages.DuckDuckGoResultsPage;
import selenium.pages.DuckDuckGoSearchPage;

import java.util.List;

public class TestBasicWebTest {

    private WebDriver driver;
    private int allCount = 10;

    @BeforeEach
    public void initialiseDriver()
    {
        driver = new FirefoxDriver();
    }

    @Test
    public void searchDuckDuckGoPanda()
    {
        String query = "giant panda";
        String matchStr = "(?i).*panda.*";
        List<String> resultsStr;

        DuckDuckGoSearchPage searchPage = new DuckDuckGoSearchPage(driver);
        searchPage.loadPage();
        searchPage.search(query);

        DuckDuckGoResultsPage resultsPage = new DuckDuckGoResultsPage(driver);
        resultsStr = resultsPage.getResults(query);

        int matches = 0;

        for (String text: resultsStr)
        {
            Assertions.assertTrue(text.matches(matchStr), "Couldn't find in text " + query);
            if (text.matches(matchStr))
                matches++;
        }
        Assertions.assertEquals(allCount, matches, "didn't match all 10" + query);
    }

    @Test
    public void searchDuckDuckGoDane()
    {
        String query = "grate dane";
        String matchStr = "(?i).*dane.*";
        List<String> resultsStr;

        DuckDuckGoSearchPage searchPage = new DuckDuckGoSearchPage(driver);
        searchPage.loadPage();
        searchPage.search(query);

        DuckDuckGoResultsPage resultsPage = new DuckDuckGoResultsPage(driver);
        resultsStr = resultsPage.getResults(query);

        int matches = 0;

        for (String text: resultsStr)
        {
            Assertions.assertTrue(text.matches(matchStr), "Couldn't find in text " + query);
            if (text.matches(matchStr))
                matches++;
        }
        Assertions.assertEquals(allCount, matches, "didn't match all 10" + query);
    }

    @Test
    public void searchDuckDuckGoChow()
    {
        String query = "chow chow";
        String matchStr = "(?i).*chow chow.*";
        List<String> resultsStr;

        DuckDuckGoSearchPage searchPage = new DuckDuckGoSearchPage(driver);
        searchPage.loadPage();
        searchPage.search(query);

        DuckDuckGoResultsPage resultsPage = new DuckDuckGoResultsPage(driver);
        resultsStr = resultsPage.getResults(query);

        int matches = 0;

        for (String text: resultsStr)
        {
            Assertions.assertTrue(text.matches(matchStr), "Couldn't find in text " + query);
            if (text.matches(matchStr))
                matches++;
        }
        Assertions.assertEquals(allCount, matches, "didn't match all 10" + query);
    }

    @AfterEach
    public void quitDriver()
    {
        driver.quit();
    }
}
