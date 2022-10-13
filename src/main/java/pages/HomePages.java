package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePages {

    private WebDriver driver;
    private By formAuthenticationLink = By.linkText("Form Authentication");

    public HomePages(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticationLink(String linkText) {
        clickLinkText(linkText);
        return new LoginPage(driver);

    }


    //void means theres no return or nothing is returned
    private void clickLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public ForgotPasswordPage clickForgotPassword(String linkText) {
        clickLinkText(linkText);
        return new ForgotPasswordPage(driver);

    }
}