package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Result {
    public Result emailError(){
        $("#emailFormatError").shouldHave(text("Неверный формат E-Mail"));
        return this;
    }
    public Result emailPassError(){
        $("#invalidEmailPassword").shouldHave(text("Неверный E-Mail или пароль"));
        return this;
    }
    public Result positiveAuth(){
        $("#dataSend").shouldHave(text("Добавить"));
        return this;
    }
    public Result modalPopApp(){
        $(".uk-modal-content").shouldHave(text("Данные добавлены."));
        return this;
    }
    public Result modalPopAppOk(){
        $(".uk-button.uk-button-primary.uk-modal-close").click();
        return this;
    }
    public Result modalPopAppError(){
        $("#blankNameError").shouldHave(text("Поле имя не может быть пустым"));
        return this;
    }
    public Result answer(String value){
        $("td").shouldHave(text(value));
        return this;
    }
    public Result answerName(String value){
        $("td",1).shouldHave(text(value));
        return this;
    }
    public Result answerGender(String value){
        $("td",2).shouldHave(text(value));
        return this;
    }
    public Result answerVariant(String value){
        $("td",3).shouldHave(text(value));
        return this;
    }
    public Result answerSecondRow(String value, String firstName, String genderMen, String variant2, String radioButton3){
        $("tbody").shouldHave(text(value));
        return this;
    }
    public Result answerRadioButton(String value){
        $("td",4).shouldHave(text(value));
        return this;
    }
    public Result closePopApp(){
        $(".uk-alert-close.uk-close").click();
        return this;
    }
}
