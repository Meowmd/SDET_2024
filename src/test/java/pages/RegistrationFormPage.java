package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.components.CalenderComponent;
import pages.components.ResultsTableComponent;

import java.io.File;
import java.net.HttpCookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    public CalenderComponent calenderComponent = new CalenderComponent();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value){
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calenderComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String value){
        $("#subjectsInput").sendKeys(value);
        $("#subjectsInput").pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value){
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }
    public RegistrationFormPage uploadFile(String value){
        $("#uploadPicture").uploadFile (new File(value));

    return this;
    }

    public RegistrationFormPage setAddress(String value){
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value){
        $("#state").click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value){
        $("#city").click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationFormPage submitForm(){
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkFormOpened(String value){
        $("#example-modal-sizes-title-lg").shouldHave(text(value));
        return this;
    }


    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key,value);
        return this;
    }
}