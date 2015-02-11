import core.TestBase;
import helpers.Waiter;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.EmailLoginPage;
import pages.ShopLoginPage;

import java.util.NoSuchElementException;

import static helpers.WebDriverSingleton.getDriver;


public class RenewPasswordTest extends TestBase {

    @Test
    public void renewPasswordTest() throws InterruptedException {
        ShopLoginPage shopLoginPage = new ShopLoginPage();
        shopLoginPage.renewPassword("testuse1@tut.by");
        getDriver().get("https://mail.yandex.by");
        EmailLoginPage emailLoginPage = new EmailLoginPage();
        emailLoginPage.login("testuse1@tut.by", "testuser1").findRenewLink();
        Assert.assertEquals(getDriver().getTitle(), "Мой Shop.by – Изменение пароля");
    }

}
