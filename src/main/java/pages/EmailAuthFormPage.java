package pages;

import org.openqa.selenium.By;

import static helpers.Locators.get;
import static helpers.WebDriverSingleton.getDriver;

public class EmailAuthFormPage {
    public static final By USERNAME_FIELD = get("emailAuthFormPage.usernameField");
    public static final By PASSWORD_FIELD = get("emailAuthFormPage.passwordField");
    public static final By LOGIN_BUTTON = get("emailAuthFormPage.loginButton");

    public EmailAuthFormPage() {
        if (!"Авторизация".equals(getDriver().getTitle())) {
            throw new IllegalStateException("This is not the auth form page");
        }
    }

    public MailBoxPage login(String username, String pass) {
        getDriver().findElement(USERNAME_FIELD).clear();
        getDriver().findElement(USERNAME_FIELD).sendKeys(username);
        getDriver().findElement(PASSWORD_FIELD).clear();
        getDriver().findElement(PASSWORD_FIELD).sendKeys(pass);
        getDriver().findElement(LOGIN_BUTTON).click();
        return new MailBoxPage();
    }
}
