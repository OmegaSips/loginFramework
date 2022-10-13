package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    //Fields declared
    private By username = By.id("username");
    private By password = By.id("password");
    private By submitButton = By.cssSelector("#login > button");

    private By flash_messages_logout = By.id("flash");

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    //Input username method
    public void setUsername(String inputName) {
        driver.findElement(username).sendKeys(inputName);

    }

    //Input password method
    public void setPassword(String inputPassword) {
        driver.findElement(password).sendKeys(inputPassword);
    }

    //Clicking the login button
    public SecureAreaPage clickSubmitButton() {
        driver.findElement(submitButton).click();

        //homework section to add a logout functionality
       // WebElement logoutButton = driver.findElement(By.linkText("Logout"));
       // logoutButton.click();
        //homework section to see the homepage

        return new SecureAreaPage(driver);
    }
        public String getFlashMessageLogout () {
            return driver.findElement(flash_messages_logout).getText();




        }
    }