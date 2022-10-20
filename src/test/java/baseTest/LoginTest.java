package baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest extends BaseTests {
    private WebDriver driver;

    @Test(priority = 1,dataProvider = "LoginData")
    public void loginSuccessfulTest(String Username, String Password, boolean Success){
    LoginPage loginTest = homePages.clickFormAuthenticationLink("Form Authentication");
    loginTest.setUsername(Username);
    loginTest.setPassword(Password);


    SecureAreaPage secureAreaPage = loginTest.clickSubmitButton();
    Assert.assertTrue(Success, secureAreaPage._getFlashMessage());

    //BASEURL = "/login";
    LoginPage logOutTest = secureAreaPage.clickLogoutButton();
    Assert.assertTrue(Success, logOutTest.getFlashMessageLogout());

    }

    @DataProvider()
    public Object[][] LoginData(){
        Object[][] data = new Object[2][3];
        data[0][0] = "tomsmith"; data [0][1] = "SuperSecretPassword!"; data[0][2] = true;
        data[1][0] = "tomsmith"; data [1][1] = "SuperSecretPassword!"; data[1][2] = true;

        return data;
    }

}
