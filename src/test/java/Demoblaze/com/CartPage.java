package Demoblaze.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Demoblaze.com.WebDriverSetUp.driver;

public class CartPage {
    By addToCartButtonNexus = By.xpath("//a[@onclick='addToCart(3)']");
    By NexusProduct = By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a");
    By cart = By.id("//a[@id='cartur']");
    By placeOrderButton = By.xpath("//button[@data-target='#orderModal']");
    By placeOrderModalWindow = By.xpath("//div/h5[@id='orderModalLabel']");
    By placeOrderNameField = By.xpath("//*[@id=\"name\"]");
    By placeOrderCountryField = By.xpath("//input[@id='country']");
    By placeOrderCityField = By.xpath("//input[@id='city']");
    By placeOrderCreditCardField = By.xpath("//input[@id='card']");
    By placeOrderMonthField = By.xpath("//input[@id='month']");
    By placeOrderYearField = By.xpath("//input[@id='year']");
    By placeOrderPurchaseButton = By.xpath("//button[@onclick='purchaseOrder()']");
    By OkButtonSuccessfulPurchase = By.xpath("//div/button[@class='confirm btn btn-lg btn-primary']");
    By deleteProduct = By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));

    public void openCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));

        WebDriverSetUp.driver.get("https://www.demoblaze.com/cart.html");
    }

    public void addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.presenceOfElementLocated(NexusProduct)).isDisplayed();
        WebDriverSetUp.driver.findElement(NexusProduct).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButtonNexus)).click();
    }

    public void placeOrder(String NameText, String CountryText, String CityText,
                           String CreditCardText, String MonthText, String YearText) {


        WebElement placeOrderButton = WebDriverSetUp.driver.findElement(By.xpath("//button[@data-target='#orderModal']"));
        ((JavascriptExecutor) WebDriverSetUp.driver).executeScript("arguments[0].click()", placeOrderButton);

        WebDriverSetUp.driver.findElement(placeOrderModalWindow);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]")));
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(NameText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='country']")));
        driver.findElement(By.xpath("//input[@id='country']")).sendKeys(CountryText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='city']")));
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(CityText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='card']")));
        driver.findElement(By.xpath("//input[@id='card']")).sendKeys(CreditCardText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='month']")));
        driver.findElement(By.xpath("//input[@id='month']")).sendKeys(MonthText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='year']")));
        driver.findElement(By.xpath("//input[@id='year']")).sendKeys(YearText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='purchaseOrder()']")));
        driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[@class='confirm btn btn-lg btn-primary']")));
        driver.findElement(By.xpath("//div/button[@class='confirm btn btn-lg btn-primary']")).click();

    }
    public void deleteProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")).click();

    }
}
