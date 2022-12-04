package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{



    @Test
    public void loginSuccess(){

        app.user().initLogin();
        app.user().fillLoginForm("hatum.testing@gmail.com","Hatum21$");
        app.user().submitLogin();

    }
}
