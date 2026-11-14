package tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.test_data.TestData.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#input-firstname");
    private final SelenideElement lastNameInput = $("#input-lastname");
    private final SelenideElement mobilePhoneInput = $("#input-telephone");
    private final SelenideElement userEmailInput = $("#input-email");
    private final SelenideElement passwordInput = $("#input-password");
    private final SelenideElement confirmPasswordInput = $("#input-confirm");
    private final SelenideElement privacyPolicyCheckbox = $("[name='agree']");
    private final SelenideElement registrationButton = $("button.account-register__submit");
    private final SelenideElement successfulRegistrationHeader = $(".breadcrumb-h1 ");
    private final SelenideElement wrongConfirmationPolicyAlert = $(".alert.alert-danger.alert-dismissible");
    private final SelenideElement validationFirstNameErrorMessage = $(byText(REGISTRATION_WITHOUT_FIRST_NAME_ERROR));
    private final SelenideElement validationLastNameErrorMessage = $(byText(REGISTRATION_WITHOUT_LAST_NAME_ERROR));
    private final SelenideElement validationPhoneNumberErrorMessage = $(byText(REGISTRATION_WITHOUT_PHONE_NUMBER_ERROR));
    private final SelenideElement validationEmailErrorMessage = $(byText(REGISTRATION_WITHOUT_EMAIL_ERROR));
    private final SelenideElement validationPasswordErrorMessage = $(byText(REGISTRATION_WITHOUT_PASSWORD_ERROR));
    private final SelenideElement EmailLetterYesRadioButton = $("input[name='newsletter'][value='1']");
    private final SelenideElement EmailLetterNoRadioButton = $("input[name='newsletter'][value='0']");
    private final SelenideElement EmailLetterRadioButtonTitle = EmailLetterYesRadioButton
            .ancestor(".form-group")
            .$("label.control-label");

    private final SelenideElement privacyPolicyLink = $("a.agree");
    private final SelenideElement registrationPageHeader = $(".account-register__heading.uni-form__heading");


    @Step("Открытие страницы регистрации")
    public RegistrationPage openPage() {
        open("/create-account/");

        return this;
    }

    @Step("Ввод имени пользователя")
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Ввод фамилии пользователя")
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Ввод номера телефона пользователя")
    public RegistrationPage typeMobilePhone(String value) {
        mobilePhoneInput.setValue(value);

        return this;
    }

    @Step("Ввод Email пользователя")
    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Ввод пароля")
    public RegistrationPage typePassword(String value) {
        passwordInput.setValue(value);

        return this;
    }

    @Step("Повторный ввод пароля")
    public RegistrationPage typePasswordConfirmation(String value) {
        confirmPasswordInput.setValue(value);

        return this;
    }

    @Step("Клик по чекбоксу политики конфиденциальности")
    public RegistrationPage acceptPrivacyPolicy() {
        privacyPolicyCheckbox.click();

        return this;
    }

    @Step("Клик по кнопке регистрации")
    public RegistrationPage submitRegistration() {
        registrationButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

        return this;
    }

    @Step("Проверка заголовка после успешной регистрации")
    public RegistrationPage checkSuccessfulRegistrationHeader() {
        successfulRegistrationHeader.shouldHave(text(SUCCESSFUL_REGISTRATION_HEADER));

        return this;
    }

    @Step("Проверка ошибки при регистрации без согласия на политику конфиденциальности")
    public RegistrationPage checkWrongConfirmationAlert() {
        wrongConfirmationPolicyAlert.shouldHave(text(WRONG_CONFIRMATION_ALERT_MESSAGE));

        return this;
    }

    @Step("Проверка валидации и текста ошибки при регистрации без имени пользователя")
    public RegistrationPage checkValidationWithEmptyFirstName() {
        validationFirstNameErrorMessage.parent().parent().shouldHave(text(REGISTRATION_FIRST_NAME_TITLE));

        return this;
    }

    @Step("Проверка валидации и текста ошибки при регистрации без фамилии пользователя")
    public RegistrationPage checkValidationWithEmptyLastName() {
        validationLastNameErrorMessage.parent().parent().shouldHave(text(REGISTRATION_LAST_NAME_TITLE));

        return this;
    }

    @Step("Проверка валидации и текста ошибки при регистрации без номера телефона")
    public RegistrationPage checkValidationWithEmptyPhoneNumber() {
        validationPhoneNumberErrorMessage.parent().parent().shouldHave(text(REGISTRATION_PHONE_NUMBER_TITLE));

        return this;
    }

    @Step("Проверка валидации и текста ошибки при регистрации без Email")
    public RegistrationPage checkValidationWithEmptyEmail() {
        validationEmailErrorMessage.parent().parent().shouldHave(text(REGISTRATION_EMAIL_TITLE));

        return this;
    }

    @Step("Проверка валидации и текста ошибки при регистрации без пароля")
    public RegistrationPage checkValidationWithEmptyPassword() {
        validationPasswordErrorMessage.parent().parent().shouldHave(text(REGISTRATION_PASSWORD_TITLE));

        return this;
    }

    @Step("Проверка наличия и корректности поля ввода имени пользователя")
    public RegistrationPage checkUserFirstNameInputField() {
        firstNameInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", PLACEHOLDER_FIRST_NAME_TITLE));

        return this;
    }

    @Step("Проверка наличия и корректности поля ввода фамилии пользователя")
    public RegistrationPage checkUserLastNameInputField() {
        lastNameInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", PLACEHOLDER_LAST_NAME_TITLE));

        return this;
    }

    @Step("Проверка наличия и корректности поля ввода телефона пользователя")
    public RegistrationPage checkUserPhoneNumberInputField() {
        mobilePhoneInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", PLACEHOLDER_PHONE_NUMBER_TITLE));

        return this;
    }

    @Step("Проверка наличия и корректности поля ввода Email пользователя")
    public RegistrationPage checkUserEmailInputField() {
        userEmailInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", PLACEHOLDER_EMAIL_TITLE));

        return this;
    }

    @Step("Проверка наличия и корректности поля ввода пароля пользователя")
    public RegistrationPage checkUserPasswordInputField() {
        passwordInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", PLACEHOLDER_PASSWORD_TITLE));

        return this;
    }

    @Step("Проверка наличия и корректности поля подтверждения пароля")
    public RegistrationPage checkUserConfirmPasswordInputField() {
        confirmPasswordInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", PLACEHOLDER_PASSWORD_CONFIRM_TITLE));

        return this;
    }

    @Step("Проверка радиокнопки для получения новостей на почту (Да)")
    public RegistrationPage checkEmailLetterYesRadioButton() {
        EmailLetterYesRadioButton
                .shouldBe(visible, checked)
                .parent()
                .shouldHave(text(YES_RADIO_BUTTON_TITLE));

        return this;
    }

    @Step("Проверка радиокнопки для получения новостей на почту (Нет)")
    public RegistrationPage checkEmailLetterNoRadioButton() {
        EmailLetterNoRadioButton
                .shouldBe(visible, not(checked))
                .parent()
                .shouldHave(text(NO_RADIO_BUTTON_TITLE));

        return this;
    }

    @Step("Проверка наименования блока с радиокнопками по получению новостепй на почту")
    public RegistrationPage checkEmailLetterRadioButtonTitle() {
        EmailLetterRadioButtonTitle.shouldBe(visible).shouldHave(text(CONFIRM_LETTER_BUTTON_TITLE));

        return this;
    }

    @Step("Проверка блока с чекбоксом по согласию на политику конфиденциальности")
    public RegistrationPage checkPrivacyPolicyCheckboxBlock() {
        privacyPolicyCheckbox
                .shouldBe(visible)
                .shouldNotBe(checked)
                .parent()
                .shouldHave(text(CONFIRM_POLICY_CHECKBOX_TITLE));

        return this;
    }

    @Step("Проверка наличия гиперссылки  на политику конфиденциальности")
    public RegistrationPage checkPrivacyPolicyLink() {
        privacyPolicyLink
                .shouldBe(visible)
                .shouldHave(text(POLICY_LINK_TITLE))
                .shouldHave(attribute("href", PRIVACY_POLICY_LINK));

        return this;
    }

    @Step("Проверка заголовка страницы регистрации")
    public RegistrationPage checkRegistrationPageHeader() {
        registrationPageHeader
                .shouldHave(text(REGISTRATION_PAGE_HEADER));

        return this;
    }
}