package pages;

import helpers.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


import java.util.Date;
import java.util.List;

import static helpers.Locators.get;
import static helpers.WebDriverSingleton.getDriver;

public class MailBoxPage {
    public static final By WRITE_BUTTON = get("mailBoxPage.writeButton");
    public static final By SUBJECT_FIELD = get("mailBoxPage.subject");
    public static final By TO_ADDRESS_FIElD = get("mailBoxPage.to");
    public static final By BODY_FIElD = get("mailBoxPage.body");
    public static final By SEND_BUTTON = get("mailBoxPage.sendButton");
    public static final By IS_SENT_MESSAGE = get("mailBoxPage.isSentMessage");
    public static final By HEADER_USERNAME = get("mailBoxPage.headerUsername");
    public static final By EXIT_LINK = get("mailBoxPage.exitLink");
    public static final By GROUP_CHECKBOX = get("mailBoxPage.groupCheckBox");
    public static final By RENEW_PASSWORD_LETTER = get("mailBoxPage.renewPasswordLetter");
    public static final By RENEW_PASSWORD_LINK = get("mailBoxPage.renewPasswordLink");

    public MailBoxPage() {
        if (!(getDriver().getTitle().contains("Входящие — Яндекс.Почта"))) {
            throw new IllegalStateException("This is not the mailbox page");
        }
    }

    private void typeInfo(By field, String info) {
        getDriver().findElement(field).clear();
        getDriver().findElement(field).sendKeys(info);
        Waiter.waitForJavascriptFinished(getDriver());
    }

    public void sendEmail(String subject, String toAddress, String body) {
        getDriver().findElement(WRITE_BUTTON).click();
        Waiter.waitForJavascriptFinished(getDriver());
        typeInfo(SUBJECT_FIELD, subject);
        typeInfo(TO_ADDRESS_FIElD, toAddress);
        typeInfo(BODY_FIElD, body);
        getDriver().findElement(SEND_BUTTON).click();
    }

    public boolean isSent() {
        return getDriver().findElement(IS_SENT_MESSAGE).getText().equals("Письмо успешно отправлено.");
    }

    public EmailAuthFormPage exit() {
        getDriver().findElement(HEADER_USERNAME).click();
        Waiter.waitForJavascriptFinished(getDriver());
        getDriver().findElement(EXIT_LINK).click();
        return new EmailAuthFormPage();
    }

    public void findRenewLink() throws InterruptedException {
        Date date = new Date();

//        List<WebElement> groupCheckbox = getDriver().findElements(GROUP_CHECKBOX);
//        if ( !groupCheckbox.isEmpty()) {
//            groupCheckbox.get(0).click();
//        }
//
//        getDriver().findElement(RENEW_PASSWORD_LETTER).click();
//        System.out.println("" + (date.getTime() - new Date().getTime()));
//        getDriver().findElement(RENEW_PASSWORD_LINK).click();
//        for (String winHandle : getDriver().getWindowHandles()) {
//            getDriver().switchTo().window(winHandle);
//        }


        try {
            getDriver().findElement(GROUP_CHECKBOX).click();
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        getDriver().findElement(RENEW_PASSWORD_LETTER).click();
        System.out.println("" + (date.getTime() - new Date().getTime()));
        getDriver().findElement(RENEW_PASSWORD_LINK).click();
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }

    }
}
