package Demoblaze.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Demoblaze.com.WebDriverSetUp.driver;

public class AboutUsPage {
    By aboutUsClick = By.xpath("//li/a[@data-target='#videoModal']");
    By aboutAsWindow = By.xpath("//div/h5[@id='videoModalLabel']");
    By playVideoClick = By.xpath("//span[@aria-live='polite']");
    By playVideoBlock = By.xpath("//*[@id=\"example-video\"]/div[1]");
    By closeVideoBlocInsideClick = By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button");
    By closeVideoBlocOutsideClick = By.xpath("//div[@style='display: block;']");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));

    public void openAboutUsPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(aboutUsClick)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(aboutAsWindow));

    }
    public void playVideoAboutUsPageInsideClose(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.presenceOfElementLocated(closeVideoBlocInsideClick)).isDisplayed();

        WebElement closeVideoBlocInsideClick = WebDriverSetUp.driver.findElement(By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button"));
        ((JavascriptExecutor) WebDriverSetUp.driver).executeScript("arguments[0].click()", closeVideoBlocInsideClick);


    }
    public void playVideoAboutUsPageOutsideClose(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.presenceOfElementLocated(closeVideoBlocOutsideClick)).click();
    }
}

