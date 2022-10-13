package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    private By forgotPasswordEmail = By.id("email");
    private By retrievePasswordButton = By.cssSelector("#form_submit > i");
    private By errorMessage = By.tagName("h1");


    //creating a constructor so that we handle the driver
    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(forgotPasswordEmail).sendKeys(email);
    }
    public void clickRetrievePasswordButton(){
        driver.findElement(retrievePasswordButton).submit();
    }
    public String getErrorMessage(){
       return driver.findElement(errorMessage).getText();
    }
}
