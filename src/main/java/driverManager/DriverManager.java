package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.Objects;

public class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void setUpDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser");

        switch (browser) {
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().setSize(new Dimension(Integer.parseInt(System.getProperty("browserWidth")),
                Integer.parseInt(System.getProperty("browserHeight"))));
        driver.manage().window().setPosition(new Point(0, 0));
        driver.get("https://" + System.getProperty("domain"));
        DRIVER.set(driver);
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(DRIVER.get())) {
            setUpDriver();
        }
        return DRIVER.get();
    }

    public static void quiteDriver() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }

}
