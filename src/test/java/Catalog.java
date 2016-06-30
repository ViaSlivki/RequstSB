import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Catalog extends Configuration {

    WebDriver driver;
    By searchField = By.xpath("//input");
    By firstSearchResult = By.cssSelector(".search-result__title");
    By requestNowButton = By.xpath("html/body/div[3]/div/div/div[3]/div/div[1]/div[1]/button[2]");
    By testFieldButton = By.cssSelector(".sb-question__answer.default-input.ng-pristine.ng-untouched.ng-empty.ng-valid-minlength.ng-valid-maxlength.ng-valid.ng-valid-required");
    String testText = "Some text goes here....";
    By compelteRequestButton = By.cssSelector(".btn.btn-primary");
    By requestSubmittedTitle = By.xpath("//span[text()='Request submitted.']");
    By imDoneButton = By.cssSelector(".btn.btn-primary");
    static String orderID;
    int orderIDNum;

    public Catalog(WebDriver driver) {
        this.driver = driver;
    }

    public void openCatalogPage() {
        driver.findElement(By.partialLinkText("Catalog")).click();
    }

    public void searchService() {
        driver.findElement(searchField).sendKeys(testService);
    }

    public void openFirstServiceProfile() {
        driver.findElement(firstSearchResult).click();
    }

    public void requestNowService() {
        driver.findElement(requestNowButton).click();
    }

    public void completeAnswer() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.elementToBeClickable(testFieldButton));
        driver.findElement(testFieldButton).sendKeys(testText);
        Thread.sleep(2000);
    }

    public void completeRequest() {
        driver.findElement(compelteRequestButton).click();
    }

    public void checkIfRequestWasSubmitted() {
        if(driver.findElement(requestSubmittedTitle).isDisplayed()) {
            orderID = driver.findElement(By.cssSelector(".sb-shopping-confirmation__description>span")).getText();
            System.out.println("Confirmation page - Request was submitted " + orderID);
            Pattern p = Pattern.compile("-?\\d+");
            Matcher m = p.matcher(orderID);
            while (m.find()) {
                orderID = m.group();
                orderIDNum = Integer.parseInt(orderID);
            }
            driver.findElement(imDoneButton).click();
        } else {
            System.out.println("Confirmation page - Failed to submit the request");
        }

    }

}
