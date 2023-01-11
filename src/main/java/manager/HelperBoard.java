package manager;

import models.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBoard extends HelperBase{
    public HelperBoard(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreation() {
        click(By.cssSelector("li[data-testid='create-board-tile']"));
    }

    public void fillBoardCreationForm(Board board) {
        type(By.cssSelector("[data-testid='create-board-title-input']"), board.getTitle());
        if(!board.getColor().equals("Pink")) {
            String locator = String.format("//button[@title='%s']", board.getColor());
            click(By.xpath("//button[@title='Green']"));
        }else {
            click(By.cssSelector("#background-picker>ul:last-child>li:last-child"));
            click(By.xpath("//div[@title='Pink']"));
        }
    }

    public void submitCreationBoard() {
        click(By.xpath("//button[text()='Create']"));
    }

    public boolean isBoardCreated(String title) {
       // pause(8000);
        String locator = "a[href $= '"+ title.toLowerCase()+"']";
//        new WebDriverWait(wd,10)
//                .until(ExpectedConditions.titleContains(title));
        new WebDriverWait(wd,13)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(locator))));

        return wd.findElement(By.cssSelector(locator)).isDisplayed();

    }
}
