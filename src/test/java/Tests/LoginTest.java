package Tests;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homepage;

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver and open the login page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
        homepage = new HomePage(driver);
    }

    @Test
    @Parameters({"username", "password"})
    public void testLogin(String username, String password) {
        // Perform login
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String actualUserName = homepage.getUserNameDropDownText();
        String expectedUserName = "Test 1 Collings";
        // Add assertions or verifications for successful login here
        Assert.assertEquals(actualUserName,expectedUserName, "Username not valid");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
