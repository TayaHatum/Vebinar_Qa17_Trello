package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
     EventFiringWebDriver wd;
    HelperUser user;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init(){
        if(browser.equals(BrowserType.CHROME)){
            wd =new EventFiringWebDriver(new ChromeDriver());
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }
        wd.register(new MyListener());

        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        user= new HelperUser(wd);


    }

    public void stop(){
        wd.quit();
    }

    public HelperUser user() {
        return user;
    }


}
