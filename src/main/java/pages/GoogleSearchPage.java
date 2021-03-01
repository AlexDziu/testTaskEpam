package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
@Getter
public class GoogleSearchPage implements Helpers {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(css = ".UUbT9 [name='btnK']")
    private WebElement searchButton;

    public GoogleSearchPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void openGoogleSearchPage(String domain) {
        getDriver().get("https://" + domain);
        waitUntilVisible(searchField);
    }

    public GoogleResultsPage searchFor(String searchRequest) {
        log.info("Input text in the search field");
        waitUntilVisible(searchField).sendKeys(searchRequest);
        log.info("Click on the search button");
        waitUntilClickable(searchButton).click();
        return new GoogleResultsPage();
    }
}
