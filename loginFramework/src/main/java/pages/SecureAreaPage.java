package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private WebDriver driver;
    private By flash_messages = By.id("flash");
    private By logoutButton = By.cssSelector("#content > div > a");

     public SecureAreaPage(WebDriver driver)
     {  this.driver = driver;

    }
    public String _getFlashMessage(){
         return driver.findElement(flash_messages).getText();

    }

    public LoginPage clickLogoutButton(){
         driver.findElement(logoutButton).click();
         return new LoginPage(driver);
    }
}
