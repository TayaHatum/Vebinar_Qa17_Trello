package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser user;


    public void init(){
        wd = new ChromeDriver();
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
