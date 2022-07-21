package Demoblaze.com;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class WebDriverSetUp {
    public static WebDriver driver;
    public static WebDriver wait;

    public WebDriverSetUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/viktor/Documents/Emine/IT/chromedriver 103");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
    }
}
