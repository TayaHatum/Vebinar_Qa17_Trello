package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.user().isLogged()) {
            app.user().logout();
        }

    }

    @Test
    public void loginSuccess() {

        app.user().initLogin();
        app.user().fillLoginForm("hatum.testing@gmail.com", "Hatum21$");
        app.user().submitLogin();
        Assert.assertTrue(app.user().isLogged());

    }

    @Test
    public void loginSuccessModels() {
        User user = new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$");
//        user.setEmail("a");
//        user.setPassword("b");


        app.user().initLogin();
        app.user().fillLoginForm(user);
        app.user().submitLogin();
        Assert.assertTrue(app.user().isLogged());

    }

    @Test
    public void loginNegativeWrongEmailModels() {
        User user = new User().withEmail("hatum.testinggmail.com").withPassword("Hatum21$");
        app.user().initLogin();
        app.user().fillLoginForm(user);
        app.user().submitLoginError();
        Assert.assertFalse(app.user().isLogged());
        Assert.assertTrue(app.user().getTextErrorEmail().contains("There isn't an account for this username"));


    }
    @Test
    public void loginNegativeWrongPasswordModels() {
        User user = new User().withEmail("hatum.testing@gmail.com").withPassword("Hat");
        app.user().initLogin();
        app.user().fillLoginForm(user);
        app.user().submitLogin();
        Assert.assertFalse(app.user().isLogged());
        Assert.assertTrue(app.user().getTextErrorPassword().contains("Incorrect email address and / or password."));


    }
}
