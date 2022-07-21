package Demoblaze.com;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Demoblaze.com.WebDriverSetUp.driver;

public class StartPage {
    By loginClick = By.xpath("//li/a[@data-target='#logInModal']");
    By loginWindow = By.xpath("//div/h5[@id='logInModalLabel']");
    By userNameLogin = By.xpath("//div/input[@id='loginusername']");
    By passwordLogin = By.id("loginpassword");
    By userLoginButton = By.xpath("//button[@onclick='logIn()']");

    By logoutClick = By.id("//li/a[@onclick='logOut()']");

    By userLoginSuccessful = By.xpath("//*[@id=\"nameofuser\"]");
    By LoginModalWindow = By.xpath("//div/h5[@id='logInModalLabel']");
    By swipeNextProduct = By.xpath("//span[@class='carousel-control-next-icon']");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));

    public void openStartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        driver.get("https://www.demoblaze.com/");

    }

    public void setUserNameLogin(String emailText) {
        WebElement userNameLogin = WebDriverSetUp.driver.findElement(By.xpath("//div/input[@id='loginusername']"));
        ((JavascriptExecutor) WebDriverSetUp.driver).executeScript("arguments[0].click()", userNameLogin);
    }

    public void setPasswordLogin(String passwordText) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordLogin));
        WebDriverSetUp.driver.findElement(passwordLogin).sendKeys(passwordText);
    }
    public void loginClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[@data-target='#logInModal']")));
        driver.findElement(By.xpath("//li/a[@data-target='#logInModal']")).click();
    }

    public void checkUserNameLoginFieldEnabled() {
        boolean enabledUserNameLogin = WebDriverSetUp.driver.findElement(userNameLogin).isEnabled();
        wait.until(ExpectedConditions.presenceOfElementLocated(userNameLogin));
        Assertions.assertTrue(enabledUserNameLogin);
    }

    public void checkPasswordLoginFieldEnabled() {
        boolean enabledPasswordLoginField = WebDriverSetUp.driver.findElement(passwordLogin).isEnabled();
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordLogin));
        Assertions.assertTrue(enabledPasswordLoginField);
    }

    public void checkUserLoginButtonEnabled() {
        boolean enabledUserLoginButton = WebDriverSetUp.driver.findElement(userLoginButton).isEnabled();
        wait.until(ExpectedConditions.elementToBeClickable(userLoginButton));
        Assertions.assertTrue(enabledUserLoginButton);
    }

    public void LoginProcess(String emailText, String passwordText) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@id='loginusername']")));
        driver.findElement(By.xpath("//div/input[@id='loginusername']")).sendKeys(emailText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        driver.findElement(By.id("loginpassword")).sendKeys(passwordText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='logIn()']")));
        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();

    }

    public void checkUserIsLoginSuccessful() {
        wait.until(ExpectedConditions.presenceOfElementLocated(userLoginSuccessful)).isDisplayed();
    }
    public void UserLogoutProcess() {

        WebElement logoutClick = WebDriverSetUp.driver.findElement(By.id("logout2"));
        ((JavascriptExecutor) WebDriverSetUp.driver).executeScript("arguments[0].click()", logoutClick);
    }
    public void swipeCarouselToNextProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(swipeNextProduct));
        WebDriverSetUp.driver.findElement(swipeNextProduct).click();
    }
    public void scrollToFooter(){
        WebElement aboutUsInformation = WebDriverSetUp.driver.findElement(By.xpath("//p[@class='m-0 text-center text-white']"));
        ((JavascriptExecutor) WebDriverSetUp.driver).executeScript("arguments[0].click()", aboutUsInformation);

    }
    public void loginModalWindowIsOpen(){
        WebDriverSetUp.driver.findElement(loginClick).click();
        wait.until(ExpectedConditions.elementToBeClickable(LoginModalWindow));
    }
}

