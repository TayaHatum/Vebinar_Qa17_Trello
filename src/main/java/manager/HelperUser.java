package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void initLogin() {
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginForm(String email, String password) {
        fillEmail(email);
        fillPassword(password);
    }

    private void fillPassword(String password) {
        pause(3000);
        type(By.id("password"),password);
    }

    private void fillEmail(String email) {
        type(By.name("user"),email);
        click(By.id("login"));
    }

    public void submitLogin() {
        click(By.id("login-submit"));
    }


}
