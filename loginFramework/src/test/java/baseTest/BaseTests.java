package baseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePages homePages;
    String BASEURL = "https://the-internet.herokuapp.com/";


    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
     //   options.addArguments("--headless");

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASEURL);
        driver.getTitle();
        homePages = new HomePages(driver);

    }


    public void runAfterSetup(){

    }

    @AfterMethod
    public void captureScreenShots(ITestResult testResult) {

        if (ITestResult.FAILURE == testResult.getStatus()) {

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            //this path is where it will save the screenshot we have captured of the results
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshot/Failed/" + testResult.getName() + "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File source = screenshot.getScreenshotAs(OutputType.FILE);
                //this path is where it will save the screenshot we have captured of the results
                File destination = new File(System.getProperty("user.dir") +
                        "/resources/screenshot/Passed/" + testResult.getName() + "_" + testResult.getStartMillis() + ".png");

                try {
                    FileHandler.copy(source, destination);
                } catch (IOException e) {
                    throw new RuntimeException(e);
            }
        }
    }

    @AfterMethod()
    public void tearDown() {
            driver.quit();

        }
    }

