package pages;

import org.openqa.selenium.By;

import static helpers.Locators.get;
import static helpers.WebDriverSingleton.getDriver;

public class EmailLoginPage {
    public static final By USERNAME_FIELD = get("loginPage.usernameField");
    public static final By PASSWORD_FIELD = get("loginPage.passwordField");
    public static final By LOGIN_BUTTON = get("loginPage.loginButton");

    public EmailLoginPage() {
        if (!"Яндекс.Почта — бесплатная электронная почта".equals(getDriver().getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public MailBoxPage login(String username, String pass) throws InterruptedException {
        getDriver().findElement(USERNAME_FIELD).clear();
        getDriver().findElement(USERNAME_FIELD).sendKeys(username);
        getDriver().findElement(PASSWORD_FIELD).clear();
        getDriver().findElement(PASSWORD_FIELD).sendKeys(pass);
        getDriver().findElement(LOGIN_BUTTON).click();
        Thread.sleep(3000);
        return new MailBoxPage();
    }

    public EmailAuthFormPage submitLoginExpectingFailure() {
        getDriver().findElement(LOGIN_BUTTON).submit();
        return new EmailAuthFormPage();
    }


}
