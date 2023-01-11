package tests;

import models.Board;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class BoardCreateTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if (!app.user().isLogged())
            app.user().login(new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$"));

    }

    @Test
    public void createNewBoardSuccess(){
        Random random = new Random();
        int i = random.nextInt(100)+100;
        Board board = Board.builder().title("GreenBoard-"+i).color("Green").build();
        logger.info("Tests start with board --> " +board.toString());

        app.board().initBoardCreation();
        app.board().fillBoardCreationForm(board);
        app.board().submitCreationBoard();
    }
    @Test
    public void createNewBoardSuccess2(){
        Random random = new Random();
        int i = random.nextInt(100)+100;
        Board board = Board.builder().title("PinkBoard-"+i).color("Pink").build();
        logger.info("Tests start with board --> " +board.toString());

        app.board().initBoardCreation();
        app.board().fillBoardCreationForm(board);
        app.board().submitCreationBoard();
        Assert.assertTrue(app.board().isBoardCreated(board.getTitle()));
    }

}
