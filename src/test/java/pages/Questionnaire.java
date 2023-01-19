package pages;

import com.codeborne.selenide.selector.ByText;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Questionnaire {
    private static final Faker faker = new Faker();

    public static String firstName = faker.name().firstName(),
            emailFaker = faker.internet().safeEmailAddress(),
            wrongEmail = "fgdfg@dhggkj@.hjghj",
            wrongEmail2 = "fgdf g@dhggkj@ds.fdf.hjghj",
            rightEmail = "gulnara0706@mail.ru",
            genderWoman = "Женский",
            genderMen = "Мужской",
            variant3 = "1.1, 1.2",
            variant1 = "1.1",
            variant2 = "1.2",
            variant = "нет",
            radioButton1 = "2.1",
             radioButton2 = "2.2",
            radioButton3 = "2.3";

    public Questionnaire clickButtonAdd (){
        $("#dataSend").click();
        return this;
    }
    public Questionnaire fillEmail(String value){
        $("#dataEmail").setValue(value);
        return this;
    }
    public Questionnaire clearEmail(){
        $("#dataEmail").clear();
        return this;
    }
    public Questionnaire fillName(String value){
        $("#dataName").setValue(value);
        return this;
    }
    public Questionnaire clearName(){
        $("#dataName").clear();
        return this;
    }
    public Questionnaire chooseGender(){
        $("#dataGender").click();
        return this;
    }
    public Questionnaire chooseGenderWoman(){
        $("option",1).click();
        return this;
    }
    public Questionnaire chooseVariant(){
        $("#dataCheck11").click();
        return this;
    }
    public Questionnaire chooseVariant2(){
        $("#dataCheck12").click();
        return this;
    }
    public Questionnaire chooseRadioButton1(){
        $("#dataSelect21").click();
        return this;
    }
    public Questionnaire chooseRadioButton2(){
        $("#dataSelect22").click();
        return this;
    }
    public Questionnaire chooseRadioButton3(){
        $("#dataSelect23").click();
        return this;
    }
    public Questionnaire buttonAdd(){
        $("#dataSend").click();
        return this;
    }

}
