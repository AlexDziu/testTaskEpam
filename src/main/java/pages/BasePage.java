package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driverManager.DriverManager.getDriver;

@Getter
public abstract class BasePage {
    protected String getTitle() {
        return getDriver().getTitle();
    }

    protected WebElement waitUntilVisible(WebElement element) {
        return new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilClickable(WebElement element) {
        return new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
