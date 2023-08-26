package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By lblUserNameDropDown = By.xpath("//p[text()='Paul Collings']");

    public String getUserNameDropDownText(){
        wait(lblUserNameDropDown);
        return driver.findElement(lblUserNameDropDown).getText();
    }

    public void wait(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


}
