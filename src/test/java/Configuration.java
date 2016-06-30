import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Configuration {
    WebDriver driver;
    String testService = "Viber";
    String testUrl = "http://clm-aus-005346.bmc.com:9000/ux/myitapp";

    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(testUrl);

    }
//    @AfterTest
//    public void tearDown(){
//        driver.close();
//    }
}
