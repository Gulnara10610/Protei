package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.Questionnaire;
import pages.Result;

import static pages.Questionnaire.*;



public class CheckQuestionnaire {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    Result result = new Result();
    CheckAuthorization checkAuthorization = new CheckAuthorization();
    Questionnaire questionnaire = new Questionnaire();

    private final String wrongEmail = "fgdfgdh@ggkj@.hjghj";
    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    @DisplayName("Оставляем все поля пустые")
    void allFieldsEmpty(){
        checkAuthorization.fillEmailPass();
        questionnaire.clickButtonAdd();
        result.emailError();
    }
    @Test
    @DisplayName("Позитивный ввод всех полей")
    void fillFormPositive(){
        checkAuthorization.fillEmailPass();
        questionnaire.clickButtonAdd();
        result.positiveAuth()
                .checkLines();
        questionnaire.fillEmail(emailFaker)
                .fillName(firstName)
                .chooseVariant()
                .chooseVariant2()
                .chooseRadioButton1()
                .buttonAdd();
        result.modalPopApp()
                .answer(emailFaker)
                .answerName(firstName)
                .answerGender(genderMen)
                .answerVariant(variant3)
                .answerRadioButton(radioButton1);
    }
    @Test
    @DisplayName("Позитивный ввод всех полей дважды")
    void fillFormPositiveTwice(){
        checkAuthorization.fillEmailPass();
        questionnaire.clickButtonAdd();
        result.positiveAuth()
                .checkLines();
        questionnaire.fillEmail(emailFaker)
                .fillName(firstName)
                .chooseVariant()
                .chooseVariant2()
                .chooseRadioButton1()
                .buttonAdd();
        result.modalPopApp()
                .modalPopAppOk()
                .answer(emailFaker)
                .answerName(firstName)
                .answerGender(genderMen)
                .answerVariant(variant3)
                .answerRadioButton(radioButton1);

        questionnaire.fillEmail(rightEmail)
                .fillName(firstName)
                .chooseVariant2()
                .chooseRadioButton3()
                .buttonAdd();
        result.modalPopApp()
                .answer(emailFaker)
                .answerName(firstName)
                .answerGender(genderMen)
                .answerVariant(variant2)
                .answerRadioButton(radioButton1)
                .answerSecondRow(emailFaker,firstName,genderMen,variant2,radioButton3);

    }
    @Test
    @DisplayName("Ввод только неправильного email")
    void fillWrongEmailOnly(){
        checkAuthorization.fillEmailPass();
        questionnaire.clickButtonAdd();
        result.positiveAuth()
                .checkLines();
        questionnaire.fillEmail(wrongEmail)
                .buttonAdd();
        result.modalPopAppError();
    }
    @Test
    @DisplayName("Пустое поле имени")
    void fillOnlyEmail(){
        checkAuthorization.fillEmailPass();
        questionnaire.clickButtonAdd();
        result.positiveAuth()
                .checkLines();
        questionnaire.fillEmail(emailFaker)
                .buttonAdd();
        result.modalPopAppError();
    }
    @Test
    @DisplayName("Вод только имени")
    void fillOnlyName(){
        checkAuthorization.fillEmailPass();
        questionnaire.clickButtonAdd();
        result.positiveAuth()
                .checkLines();
        questionnaire.fillName(firstName)
                .buttonAdd();
        result.emailError();

    }
    @Test
    @DisplayName("кликаем дважды радиобаттон, пропускаем чек-бокс")
    void clickTwiceRadioButton(){
        checkAuthorization.fillEmailPass();
        questionnaire.clickButtonAdd();
        result.positiveAuth()
                .checkLines();
        questionnaire.fillEmail(rightEmail)
                .fillName(firstName)
                .chooseRadioButton1()
                .chooseRadioButton2()
                .chooseRadioButton3();
        result.answer(rightEmail)
                .answerName(firstName)
                .answerGender(genderMen)
                .answerVariant(variant)
                .answerRadioButton(radioButton3);
    }
    @Test
    @DisplayName("Тест без ввода имени и email")
    void withOutEmailName(){
        checkAuthorization.fillEmailPass();
        questionnaire.clickButtonAdd();
        result.positiveAuth()
                .checkLines();
        questionnaire.chooseGender()
                .chooseGenderWoman()
                .chooseVariant2()
                .chooseRadioButton2();
        result.emailError();
    }
    @Test
    @DisplayName("Вводим только Емаил и имя")
    void withOutVariants(){
        checkAuthorization.fillEmailPass();
        questionnaire.clickButtonAdd();
        result.positiveAuth()
                .checkLines();
        questionnaire.fillEmail(rightEmail)
                .fillName(firstName)
                .clickButtonAdd();
        result.modalPopApp()
                .answer(rightEmail)
                .answerName(firstName)
                .answerGender(genderMen)
                .answerVariant(variant);
    }
    @Test
    @DisplayName("Длинный неправильный емайл")
    void tooLoongEmail(){
        checkAuthorization.fillEmailPass();
        questionnaire.clickButtonAdd();
        result.positiveAuth()
                .checkLines();
        questionnaire.fillEmail(longEmail)
                .fillName(firstName)
                .chooseVariant2()
                .chooseRadioButton1()
                .chooseGender()
                .chooseGenderWoman()
                .buttonAdd();
        result.emailError();
    }


}
