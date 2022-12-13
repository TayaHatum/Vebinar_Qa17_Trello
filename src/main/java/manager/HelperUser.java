package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collection;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void initLogin() {
        pause(2000);
        if(isHomePage())
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginForm(String email, String password) {
        fillEmail(email);
        fillPassword(password);
    }
    public void fillLoginForm(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
    }

    private void fillPassword(String password) {
        pause(2000);
        type(By.id("password"),password);
    }

    private void fillEmail(String email) {
        if(wd.findElement(By.cssSelector("button.username-change")).isDisplayed()){
            click(By.cssSelector("button.username-change"));
            type(By.name("user"),email);
        }else {
            type(By.name("user"),email);
        }

        click(By.id("login"));
    }

    public void submitLogin() {
        click(By.id("login-submit"));
    }

    public void submitLoginError() {
        click(By.id("login"));
    }
    public boolean isLogged() {
        pause(2000);
        return isElementPresent(By.cssSelector("button[data-testid='header-member-menu-button']"));
    }

    public void logout() {
        click(By.cssSelector("button[data-testid='header-member-menu-button']"));
        click(By.cssSelector("button[data-testid='header-member-menu-logout']"));
        click(By.id("logout-submit"));
    }

    public String getTextErrorEmail() {
        return wd.findElement(By.cssSelector("p.error-message")).getText();

    }

    public String getTextErrorPassword() {
        return getText(By.cssSelector("div#login-error"));
    }
}
