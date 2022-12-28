package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatarTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if (!app.user().isLogged())
            app.user().login(new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$"));

    }

    @Test
    public void changeAvatarTest(){
        app.user().clickAvatarImg();
        app.user().openProfileAndVisability();
        app.user().navigateToAtlassianPtofile();

    }

}
