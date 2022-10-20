package baseTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;

public class ForgotPasswordTest extends BaseTests {

    @Test(priority = 2, dataProvider = "ForgotData")
    public void forgotPasswordTest(String ForgotPassword, String Email, String Error){
       ForgotPasswordPage forgotPasswordPage = homePages.clickForgotPassword(ForgotPassword);
       forgotPasswordPage.enterEmail(Email);
       forgotPasswordPage.clickRetrievePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getErrorMessage(),Error);

    }
    //Works as a database per se
    @DataProvider()
    public Object[][] ForgotData(){
        Object[][] data = new Object[4][3];
        data[0][0] ="Forgot Password"; data [0][1] = "test@tes.com"; data [0][2] = "Internal Server Error";
        data[1][0] ="Forgot Password"; data [1][1] = "Hello@test.com"; data [1][2] = "Internal Server Error";
        data[2][0] ="Forgot Password"; data [2][1] = "Just@test.com"; data [2][2] = "Internal Server Error";
        data[3][0] ="Forgot Password"; data [3][1] = "Nice@test.com"; data [3][2] = "Internal Server Error";

        return data;
    }
}
