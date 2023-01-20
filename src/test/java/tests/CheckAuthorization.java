package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.Result;


public class CheckAuthorization {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    Result result = new Result();

    private static String email = "test@protei.ru",
     pass = "test",
    spaceEmail = " test@protei.ru",
    spacePass = "test ";

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Тест без заполнения полей ")
    void emptyField() {
        authorizationPage.openPage()
                .clickButtonEnter();
        result.emailError();
    }
    @Test
    @DisplayName("Ввод емайл и пароля с пробелом ")
    void withSpaceFields() {
        authorizationPage.openPage()
                .inputEmail(spaceEmail)
                .inputPassword(spacePass)
                .clickButtonEnter();
        result.emailPassError()
                .closePopApp();
        authorizationPage.inputEmail(email)
                .inputPassword(pass)
                .clickButtonEnter();
        result.positiveAuth()
                .checkLines();

    }

    @Test
    @DisplayName("Тест с заполнением только Email")
    void emptyPassword() {
        authorizationPage.openPage()
                .inputEmail(email)
                .clickButtonEnter();
        result.emailPassError();
    }
    @Test
    @DisplayName("Тест с заполнением только Password")
    void emptyEmail() {
        authorizationPage.openPage()
                .inputPassword(email)
                .clickButtonEnter();
        result.emailError();
    }
    @Test
    @DisplayName("Позитивный логин ")
    void fillEmailPass(){
        authorizationPage.openPage()
                .inputEmail(email)
                .inputPassword(pass)
                .clickButtonEnter();
        result.positiveAuth()
                .checkLines();
    }





}


