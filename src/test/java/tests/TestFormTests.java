package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class TestFormTests  extends TestBase{
    @Test
    void successfullTest() {

        String firstName = "Mariya";
        String lastName = "Bykova";
        String email = "bykova.m@gmail.com";
        String gender = "Female";
        String userNumber = "8999999999";
        String dateOfBdDay = "8";
        String dateOfBdMonth = "July";
        String dateOfBdYear = "1987";
        String subject = "Chemistry";
        String hobby = "Music";
        String uploadPhoto = "src/test/resources/img/1.png";
        String address = "Nsk";
        String state = "NCR";
        String city = "Delhi";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dateOfBdDay, dateOfBdMonth, dateOfBdYear)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadFile(uploadPhoto)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm()
                .checkFormOpened("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", "bykova.m@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8999999999")
                .checkResult("Date of Birth", "8 July,1987")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "Nsk")
                .checkResult("State and City", "NCR Delhi");
    }
}
