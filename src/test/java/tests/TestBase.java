package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite (alwaysRun = true)
    public void setUp() {
        app.init();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        //app.stop();
    }

}
