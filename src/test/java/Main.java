import org.testng.annotations.Test;

public class Main extends Configuration {

    @Test
    public void requestingSBService() throws InterruptedException {
        Login login = new Login(driver);
        login.inputDataAndLogin();
        Catalog catalog = new Catalog(driver);
        catalog.openCatalogPage(); //if Catalog is default page it's OK
        catalog.searchService();
        catalog.openFirstServiceProfile();
        catalog.requestNowService();
        catalog.completeAnswer();
        catalog.completeRequest();
        catalog.checkIfRequestWasSubmitted();
        NewsFeed updates = new NewsFeed(driver);
        updates.openNewsFeedPage();
        updates.checkIfRequestIsOnTheTimeline();


    }
}
