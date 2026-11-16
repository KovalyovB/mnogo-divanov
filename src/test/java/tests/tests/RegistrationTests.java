package tests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.RegistrationPage;

import static tests.test_data.TestData.*;

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
                .checkSuccessfulRegistrationHeader(SUCCESSFUL_REGISTRATION_HEADER);
    }

    @Test
    @DisplayName("[UI] Проверка формы валидации при регистрации с пустыми полями")
    void wrongRegistrationWithEmptyFieldsTest() {
        registrationPage.openPage()
                .submitRegistration()
                .checkWrongConfirmationAlert(WRONG_CONFIRMATION_ALERT_MESSAGE)
                .checkValidationWithEmptyFirstName(REGISTRATION_FIRST_NAME_TITLE)
                .checkValidationWithEmptyLastName(REGISTRATION_LAST_NAME_TITLE)
                .checkValidationWithEmptyPhoneNumber(REGISTRATION_PHONE_NUMBER_TITLE)
                .checkValidationWithEmptyEmail(REGISTRATION_EMAIL_TITLE)
                .checkValidationWithEmptyPassword(REGISTRATION_PASSWORD_TITLE);
    }

    @Test
    @DisplayName("[UI] Проверка UI формы регистрации")
    void registrationFormLoadedTest() {
        registrationPage.openPage()
                .checkUserFirstNameInputField(PLACEHOLDER_FIRST_NAME_TITLE)
                .checkUserLastNameInputField(PLACEHOLDER_LAST_NAME_TITLE)
                .checkUserPhoneNumberInputField(PLACEHOLDER_PHONE_NUMBER_TITLE)
                .checkUserEmailInputField(PLACEHOLDER_EMAIL_TITLE)
                .checkUserPasswordInputField(PLACEHOLDER_PASSWORD_TITLE)
                .checkUserConfirmPasswordInputField(PLACEHOLDER_PASSWORD_CONFIRM_TITLE)
                .checkEmailLetterYesRadioButton(YES_RADIO_BUTTON_TITLE)
                .checkEmailLetterNoRadioButton(NO_RADIO_BUTTON_TITLE)
                .checkEmailLetterRadioButtonTitle(CONFIRM_LETTER_BUTTON_TITLE)
                .checkPrivacyPolicyCheckboxBlock(CONFIRM_POLICY_CHECKBOX_TITLE)
                .checkPrivacyPolicyLink(POLICY_LINK_TITLE, PRIVACY_POLICY_LINK)
                .checkRegistrationPageHeader(REGISTRATION_PAGE_HEADER);

    }
}
