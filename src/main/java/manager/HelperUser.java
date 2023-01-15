package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public void login(User user) {
        initLogin();
        fillLoginForm(user);
        submitLogin();
        new WebDriverWait(wd,5)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("button[data-testid='header-member-menu-button']"))));
    }

    public void clickAvatarImg() {
        click(By.cssSelector("button[data-testid='header-member-menu-button']"));
    }

    public void openProfileAndVisability() {
        click(By.cssSelector("a[data-testid='account-menu-profile']"));

    }

    public void navigateToAtlassianPtofile() {
        click(By.xpath("//a[text()='Atlassian profile']"));

        ArrayList<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
        new WebDriverWait(wd,5)
                .until(ExpectedConditions.titleIs("Atlassian account"));
    }

    public void initChangeAvatar() {
        Actions actions= new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-hover-info']"))).pause(500).click().release().perform();

        click(By.xpath("//*[text()='Change profile photo']"));
    }

    public void uploadPhoto(String link) {
        wd.findElement(By.id("image-input")).sendKeys(link);
        click(By.xpath("//button/span[text()='Upload']"));
    }

    public boolean isAvatarAdded() {
        WebElement until = new WebDriverWait(wd, 7)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//span[text()='Avatar added']"))));
        return until.isDisplayed();
    }

    public void returnToTrelloHome() {
        List<String > tabs = new ArrayList<>(wd.getWindowHandles());
        wd.close();
        wd.switchTo().window(tabs.get(0));
        click(By.cssSelector("[aria-label='Back to home']"));
    }
}
