package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {
    public AuthorizationPage openPage(){
        open("file:///C:/Users/79818/Downloads/Telegram%20Desktop/qa-test.html");
        return this;
    }
    public AuthorizationPage clickButtonEnter(){
        $("#authButton").click();
        return this;
    }
    public AuthorizationPage inputEmail(String value){
        $("#loginEmail").setValue(value);
        return this;
    }
    public AuthorizationPage inputPassword(String value){
        $("#loginPassword").setValue(value);
        return this;
    }


}
