package Demoblaze.com;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Demoblaze.com.WebDriverSetUp.driver;

public class Tests {
    private static StartPage startPage;
    private static CartPage cartPage;
    private static ContactPage contactPage;
    private static AboutUsPage aboutUsPage;

    @BeforeAll
    static void unitTest() {

        WebDriverSetUp webDriverSetUp = new WebDriverSetUp();

        startPage = new StartPage();
        cartPage = new CartPage();
        contactPage = new ContactPage();
        aboutUsPage = new AboutUsPage();
    }

    //START PAGE
    //LOGIN
    @Test
    public void checkLoginActive() {
        startPage.openStartPage();
        startPage.loginClick();
    }

    @Test
    public void userNameFieldActive() {
        startPage.openStartPage();
        startPage.loginClick();
        startPage.checkUserNameLoginFieldEnabled();
    }

    @Test
    public void passwordFieldActive() {
        startPage.openStartPage();
        startPage.loginClick();
        startPage.checkPasswordLoginFieldEnabled();
    }

    @Test
    public void userLoginButtonActive() {
        startPage.openStartPage();
        startPage.loginClick();
        startPage.checkUserLoginButtonEnabled();
    }
    @Test
    public void checkLoginModalWindowIsOpen (){
        startPage.openStartPage();

        startPage.loginModalWindowIsOpen();
    }
    @Test
    public void testLogin() {
        //GIVEN
        String existingUserEmail = "emine.test@gmail.com";
        String existingUserPassword = "99911";
        //WHEN
        startPage.openStartPage();
        startPage.loginClick();
        startPage.LoginProcess(existingUserEmail,existingUserPassword);

    }

    //START PAGE
    @Test
    public void swipeCarouselToNextProduct (){
        startPage.openStartPage();
        startPage.swipeCarouselToNextProduct();
    }

    @Test
    public void CheckAddProductToCart(){
        startPage.openStartPage();
        cartPage.addProductToCart();
    }
    @Test
    public void checkScrollToFooter(){
        startPage.openStartPage();
        startPage.scrollToFooter();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
    }

    //CART PAGE
    @Test
    public void openCartPage(){
        cartPage.openCartPage();

    }

    @Test
    public void makeOrder(){
        //GIVEN
        String NameText = "Emma";
        String CountryText = "Ukraine";
        String CityText  = "Kherson";
        String CreditCardText = "9999 9999 9999 9999";
        String MonthText = "May";
        String YearText = "2022";
        //THEN
        startPage.openStartPage();
        cartPage.addProductToCart();
        cartPage.openCartPage();
        cartPage.placeOrder(NameText, CountryText,CityText,CreditCardText, MonthText, YearText );
    }
    @Test
    public void deleteProduct(){
        startPage.openStartPage();
        cartPage.addProductToCart();
        cartPage.openCartPage();
        cartPage.deleteProduct();
    }
    //CONTACT PAGE
    @Test
    public void checkOpenContactPageWindow(){
        startPage.openStartPage();
        contactPage.openContactPageWindow();
    }
    @Test
    public void checkOpenAboutUsPage(){
        startPage.openStartPage();
        aboutUsPage.openAboutUsPage();
    }
    @Test
    public void checkSendContactPageMessage() {
        //GIVEN
        String emailText = "emine.test@gmail.com";
        String nameText = "Emine";
        String messageText = "Hello! I have problems with payment. Could you help me,please!";
        //
        startPage.openStartPage();
        contactPage.openContactPageWindow();
        contactPage.fillContactPageFields(emailText, nameText, messageText);
        contactPage.sendContactMessage();
        contactPage.refreshPage();
    }

    //click inside element
    @Test
    public void checkVideoPlayOnAboutUsPageInsideClose() {
        startPage.openStartPage();
        aboutUsPage.openAboutUsPage();
        aboutUsPage.playVideoAboutUsPageInsideClose();

    }
    //click outside the element
    @Test
    public void checkVideoPlayOnAboutUsPageOutsideClose() {
        startPage.openStartPage();
        aboutUsPage.openAboutUsPage();
        aboutUsPage.playVideoAboutUsPageOutsideClose();
    }
    @Test
    public void testLogOut() {
        //GIVEN
        String emailText = "emine.test@gmail.com";
        String passwordText = "99911";
        //THEN
        startPage.openStartPage();
        startPage.loginClick();
        startPage.LoginProcess(emailText,passwordText);
        startPage.checkUserIsLoginSuccessful();
        startPage.UserLogoutProcess();
    }
    @Test
    public void deleteProduct1(){
        startPage.openStartPage();
        cartPage.addProductToCart();
        cartPage.openCartPage();
        cartPage.deleteProduct();
    }

    @AfterAll
    @Step("Quit browser")
    static void closeDriver(){

        WebDriverSetUp.driver.quit();
    }
}


