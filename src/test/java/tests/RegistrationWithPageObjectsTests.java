package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static io.qameta.allure.Allure.step;

import testdata.TestData;
@DisplayName("Параметризированные тесты в Jenkins_ДЗ_15/Уведомлени в ТелеграмБот_ДЗ16")
public class RegistrationWithPageObjectsTests extends TestBase {

      RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();
    @Test
    @Feature("Проверка формы регистрации")
    @Story("Заполнение всех полей формы")
    @Owner("Elena Belavina")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест на заполнение всех полей формы регистрации")
    @Tag("fillForm")
    void successfulRegistrationTest() {
        step("Открываем страницу с формой регистрации", () -> {
                    registrationPage.openPage().closeBanners();
                });
        step("Заполняем все поля формы", () -> {
                    registrationPage.setFirstName(testData.firstName)
                            .setLastName(testData.lastName)
                            .setEmail(testData.userEmail)
                            .setGender(testData.gender)
                            .setUserNumber(testData.userNumber)
                            .setDateOfBirth(testData.dateDay, testData.dateMonth, testData.dateYear)
                            .setSubjects(testData.subjects)
                            .setHobbies(testData.hobbies)
                            .uploadPicture(testData.picture)
                            .setCurrentAddress(testData.currentAddress)
                            .setState(testData.state)
                            .setCity(testData.city)
                            .submit();
                });
        step("Проверка результата заполнения формы", () -> {
                    registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                            .checkResult("Student Email", testData.userEmail)
                            .checkResult("Gender", testData.gender)
                            .checkResult("Mobile", testData.userNumber)
                            .checkResult("Date of Birth", testData.dateDay + " " + testData.dateMonth + "," + testData.dateYear)
                            .checkResult("Subjects", testData.subjects)
                            .checkResult("Hobbies", testData.hobbies)
                            .checkResult("Picture", testData.picture)
                            .checkResult("Address", testData.currentAddress)
                            .checkResult("State and City", testData.state + " " + testData.city);
                });

          }
    @Feature("Проверка формы регистрации")
    @Story("Заполнение только обязательных полей формы")
    @Owner("Elena Belavina")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест на минимальное заполнение полей формы")
    @Tag("fillForm")
    @Test
    void registrationMinTest(){
        registrationPage.openPage().closeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .submit();

        registrationPage.checkResult("Student Name", testData.firstName+" "+testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile",testData.userNumber);
       }

    @Feature("Проверка формы регистрации")
    @Story("Заполняем не все обязательные поля формы")
    @Owner("Elena Belavina")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Негативный тест (заполняем не все обязательные поля формы)")

    @Tag("fillForm")
    @Test
    void registrationNegativeTest(){
        registrationPage.openPage().closeBanners()
                //.setFirstName(testData.firstName)  //не заполняем имя
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dateDay,testData.dateMonth,testData.dateYear)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .uploadPicture(testData.picture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submit();

        registrationPage.checkModalDialog();
         }
}