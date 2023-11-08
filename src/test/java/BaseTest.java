import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    protected Page page;

    @BeforeClass
    protected void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
        );
    }

    @BeforeMethod
    protected void createContextAndPage() {
        context = browser.newContext(
                new Browser.NewContextOptions()
        );

        page = context.newPage();
    }

    @AfterMethod
    protected void closeContext() {
        context.close();
    }

    @AfterClass
    protected void closeBrowser() {
        browser.close();
        playwright.close();
    }
}
