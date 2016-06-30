import com.sun.org.apache.xpath.internal.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsFeed{
    WebDriver driver;
    By closeCatalogSearchButton = By.cssSelector(".icon-cross.search-field-box__clear-btn");
    String orderIdUpdatesNumber;
    int orderIdUpdates;
    Catalog cat = new Catalog(driver);


    public NewsFeed(WebDriver driver) {
        this.driver = driver;
    }


    public void openNewsFeedPage() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(closeCatalogSearchButton).click();
        driver.findElement(By.partialLinkText("News Feed")).click();
    }


    public void check() {
        orderIdUpdatesNumber = driver.findElement(By.xpath("//span[contains(text(), 'Order')]")).getText();
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(orderIdUpdatesNumber);
        while (m.find()) {
            orderIdUpdatesNumber = m.group();
            orderIdUpdates = Integer.parseInt(orderIdUpdatesNumber);
        }
        System.out.println("Order ID from Updates = " + orderIdUpdates);

        if (orderIdUpdates == cat.orderIDNum){
            System.out.println("Request was submitted and it is present on the timeline");
        } else
            System.out.println("Can't find recently submitted request on the Timeline");



    }

         public String getOrderIdLocator() {
             String s = "//span[contains(text(), '%s')]";
             return String.format(s, cat.orderID );
    }

        public void checkIfRequestIsOnTheTimeline(){
            String locator = getOrderIdLocator();
            driver.findElement(By.xpath(locator));
            System.out.println("Request was submitted and it is present on the Timeline");
        }




}
