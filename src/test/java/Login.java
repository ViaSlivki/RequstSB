import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;
    String loginName = "Allen";
    String password = "password";

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    By userNameLocator = By.xpath(".//input[@name = 'username']");
    By passwordLocator = By.xpath(".//input[@name = 'password']");
    By loginButtonLocator = By.cssSelector(".login-form__submit-btn.btn.btn_teal.btn_wide");

    public void inputDataAndLogin(){
        driver.findElement(userNameLocator).sendKeys(loginName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

}

