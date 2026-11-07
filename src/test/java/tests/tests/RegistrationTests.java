package tests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.RegistrationPage;

@DisplayName("[UI] Тесты по форме регистрации")
public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("[UI] Проверка регистрации с валидными данными")
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeMobilePhone(userPhoneNumber)
                .typeUserEmail(userEmail)
                .typePassword(userPassword)
                .typePasswordConfirmation(userPassword)
                .acceptPrivacyPolicy()
                .submitRegistration()
                .checkSuccessfulRegistrationHeader();
    }

    @Test
    @DisplayName("[UI] Проверка формы валидации при регистрации с пустыми полями")
    void wrongRegistrationWithEmptyFieldsTest() {
        registrationPage.openPage()
                .submitRegistration()
                .checkWrongConfirmationAlert()
                .checkValidationWithEmptyFirstName()
                .checkValidationWithEmptyLastName()
                .checkValidationWithEmptyPhoneNumber()
                .checkValidationWithEmptyEmail()
                .checkValidationWithEmptyPassword();
    }

    @Test
    @DisplayName("[UI] Проверка UI формы регистрации")
    void registrationFormLoadedTest() {
        registrationPage.openPage()
                .checkUserFirstNameInputField()
                .checkUserLastNameInputField()
                .checkUserPhoneNumberInputField()
                .checkUserEmailInputField()
                .checkUserPasswordInputField()
                .checkUserConfirmPasswordInputField()
                .checkEmailLetterYesRadioButton()
                .checkEmailLetterNoRadioButton()
                .checkEmailLetterRadioButtonTitle()
                .checkPrivacyPolicyCheckboxBlock()
                .checkPrivacyPolicyLink()
                .checkRegistrationPageHeader();

    }
}
