package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static driverManager.DriverManager.getDriver;
import static java.util.Collections.singletonList;

@Slf4j
@Getter
public class GoogleResultsPage extends BasePage {

    @FindBy(xpath = "//*[@class='g']//h3/parent::a")
    private WebElement resultLinks;

    @FindBy(xpath = "//a[@id='pnnext']")
    private WebElement nextPageButton;

    public GoogleResultsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public GoogleResultsPage clickOnFirstPage() {
        log.info("Click on the first site");
        List<WebElement> listOfLinks = singletonList(resultLinks);
        listOfLinks.get(0).click();
        return this;
    }
}
