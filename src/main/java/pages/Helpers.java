package pages;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Helpers {
    default WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    default String getTitle() {
        return getDriver().getTitle();
    }

    default WebElement waitUntilVisible(WebElement element) {
        return new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOf(element));
    }

    default WebElement waitUntilClickable(WebElement element) {
        return new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
