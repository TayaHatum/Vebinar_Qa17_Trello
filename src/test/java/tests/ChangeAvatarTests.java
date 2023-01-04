package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatarTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if (!app.user().isLogged())
            app.user().login(new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$"));

    }

    @Test(groups = {"smoke"})
    public void changeAvatarTest(){
        app.user().clickAvatarImg();
        app.user().openProfileAndVisability();
        app.user().navigateToAtlassianPtofile();
        app.user().initChangeAvatar();
        app.user().uploadPhoto("/Users/tayahatum/Qa17/Vebinar_Qa17_Trello/src/test/resources/qa1.jpeg");
        Assert.assertTrue(app.user().isAvatarAdded());
        app.user().returnToTrelloHome();

    }
    @Test
    public void changeAvatarTest2(){
        app.user().clickAvatarImg();
        app.user().openProfileAndVisability();
        app.user().navigateToAtlassianPtofile();
        app.user().initChangeAvatar();
        app.user().uploadPhoto("/Users/tayahatum/Qa17/Vebinar_Qa17_Trello/src/test/resources/qa.png");
        Assert.assertTrue(app.user().isAvatarAdded());
        app.user().returnToTrelloHome();

    }


}
