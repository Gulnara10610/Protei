package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {
    private SelenideElement
    login = $("#loginEmail"),
    buttonEnter = $("#authButton"),
    loginPass = $("#loginPassword");

    public AuthorizationPage openPage(){
        open("file:///C:/Users/79818/Downloads/Telegram%20Desktop/qa-test.html");
        return this;
    }
    public AuthorizationPage clickButtonEnter(){
        buttonEnter.click();
        return this;
    }
    public AuthorizationPage inputEmail(String value){
       login.setValue(value);
        return this;
    }
    public AuthorizationPage inputPassword(String value){
        loginPass.setValue(value);
        return this;
    }



}
