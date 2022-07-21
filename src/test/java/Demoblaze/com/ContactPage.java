package Demoblaze.com;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Demoblaze.com.WebDriverSetUp.driver;

public class ContactPage {
    By contactClick = By.xpath("//li/a[@data-target='#exampleModal']");
    By newMessageWindow = By.xpath("//*[@id=\"exampleModalLabel\"]");
    By contactEmailField = By.xpath("//*[@id=\"recipient-email\"]");
    By contactNameField = By.xpath("//input[@id='recipient-name']");
    By messageField = By.xpath("//div/textarea[@id='message-text']");
    By sendMessageButtonClick = By.xpath("//button[@onclick='send()']");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));

    public void openContactPageWindow() {
        wait.until(ExpectedConditions.presenceOfElementLocated(contactClick)).isDisplayed();
        WebDriverSetUp.driver.findElement(contactClick).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(newMessageWindow)).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(50000L));
    }

    public void fillContactPageFields(String EmailText, String NameText, String MessageText) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"recipient-email\"]")));
        driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).sendKeys(EmailText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='recipient-name']")));
        driver.findElement(By.xpath("//input[@id='recipient-name']")).sendKeys(NameText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/textarea[@id='message-text']")));
        driver.findElement(By.xpath("//div/textarea[@id='message-text']")).sendKeys(MessageText);

    }

    public void sendContactMessage() {
        boolean closeContactPage = WebDriverSetUp.driver.findElement(sendMessageButtonClick).isEnabled();
        wait.until(ExpectedConditions.presenceOfElementLocated(sendMessageButtonClick)).click();
        Assertions.assertTrue(closeContactPage);
    }

    public void refreshPage(){
        driver.switchTo().alert().dismiss();
    }

}

