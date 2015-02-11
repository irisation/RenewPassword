package pages;

import org.openqa.selenium.By;

import static helpers.Locators.get;
import static helpers.WebDriverSingleton.getDriver;

public class ShopLoginPage {
    public static final By ENTER_BUTTON = get("shopLoginPage.enterButton");
    public static final By FORGOT_PASSWORD_LINK = get("shopLoginPage.forgotPasswordLink");
    public static final By EMAIL_FIELD = get("shopLoginPage.emailField");
    public static final By RENEW_BUTTON = get("shopLoginPage.renewButton");

    public ShopLoginPage() {
        if (!"Торговый портал Shop.by – Все интернет-магазины Минска и Беларуси".equals(getDriver().getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public void renewPassword(String email) {
        getDriver().findElement(ENTER_BUTTON).click();
        getDriver().findElement(FORGOT_PASSWORD_LINK).click();
        getDriver().findElement(EMAIL_FIELD).clear();
        getDriver().findElement(EMAIL_FIELD).sendKeys(email);
        getDriver().findElement(RENEW_BUTTON).click();
    }

}
