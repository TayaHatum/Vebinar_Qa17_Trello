package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){

        wd.findElement(locator).click();
    }
    public void type(By locator, String text){
        if(text!=null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
}

public String  getText(By locator){
        return wd.findElement(locator).getText();
}

public boolean isHomePage(){
        String  current_url = wd.getCurrentUrl();
        return current_url.equals("https://trello.com/")||current_url.equals("https://trello.com/home");

}

public void  returnToHome(){
wd.navigate().to("https://trello.com/");
}

public void alertShow(){
    Alert alert = wd.switchTo().alert();
    alert.accept(); ///OK
    alert.dismiss(); /// cancel
    alert.sendKeys("text");
    alert.getText();

    Alert alert1 = new WebDriverWait(wd, 5)
            .until(ExpectedConditions.alertIsPresent());
}
    }
