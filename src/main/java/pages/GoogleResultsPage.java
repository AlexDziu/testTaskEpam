package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
@Getter
public class GoogleResultsPage implements Helpers {

    @FindBy(css = ".hlcw0c .g .NJjxre cite")
    private List<WebElement> resultLinks;

    @FindBy(xpath = "//a[@id='pnnext']")
    private WebElement nextPageButton;

    public GoogleResultsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public GoogleResultsPage clickOnFirstPage() {
        log.info("Click on the first site");
        getResultLinks().get(0).click();
        return this;
    }

    public boolean domainNameIsPresent(String domainName, int numberOfPages) {
        log.info("Checking that domain name is present on the pages");
        int currentPage = 1;
        while (currentPage <= numberOfPages) {
            List<WebElement> listOfLinks = getResultLinks();
            for (WebElement link : listOfLinks) {
                if (link.getText().contains(domainName)) {
                    return true;
                }
            }
            nextPageButton.click();
            currentPage++;
        }
        return false;
    }
}
