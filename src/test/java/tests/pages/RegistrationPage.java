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
    public RegistrationPage checkSuccessfulRegistrationHeader(String value) {
        successfulRegistrationHeader.shouldHave(text(value));

        return this;
    }

    @Step("Проверка ошибки при регистрации без согласия на политику конфиденциальности")
    public RegistrationPage checkWrongConfirmationAlert(String value) {
        wrongConfirmationPolicyAlert.shouldHave(text(value));

        return this;
    }

    @Step("Проверка валидации и текста ошибки при регистрации без имени пользователя")
    public RegistrationPage checkValidationWithEmptyFirstName(String value) {
        validationFirstNameErrorMessage.parent().parent().shouldHave(text(value));

        return this;
    }

    @Step("Проверка валидации и текста ошибки при регистрации без фамилии пользователя")
    public RegistrationPage checkValidationWithEmptyLastName(String value) {
        validationLastNameErrorMessage.parent().parent().shouldHave(text(value));

        return this;
    }

    @Step("Проверка валидации и текста ошибки при регистрации без номера телефона")
    public RegistrationPage checkValidationWithEmptyPhoneNumber(String value) {
        validationPhoneNumberErrorMessage.parent().parent().shouldHave(text(value));

        return this;
    }

    @Step("Проверка валидации и текста ошибки при регистрации без Email")
    public RegistrationPage checkValidationWithEmptyEmail(String value) {
        validationEmailErrorMessage.parent().parent().shouldHave(text(value));

        return this;
    }

    @Step("Проверка валидации и текста ошибки при регистрации без пароля")
    public RegistrationPage checkValidationWithEmptyPassword(String value) {
        validationPasswordErrorMessage.parent().parent().shouldHave(text(value));

        return this;
    }

    @Step("Проверка наличия и корректности поля ввода имени пользователя")
    public RegistrationPage checkUserFirstNameInputField(String value) {
        firstNameInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", value));

        return this;
    }

    @Step("Проверка наличия и корректности поля ввода фамилии пользователя")
    public RegistrationPage checkUserLastNameInputField(String value) {
        lastNameInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", value));

        return this;
    }

    @Step("Проверка наличия и корректности поля ввода телефона пользователя")
    public RegistrationPage checkUserPhoneNumberInputField(String value) {
        mobilePhoneInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", value));

        return this;
    }

    @Step("Проверка наличия и корректности поля ввода Email пользователя")
    public RegistrationPage checkUserEmailInputField(String value) {
        userEmailInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", value));

        return this;
    }

    @Step("Проверка наличия и корректности поля ввода пароля пользователя")
    public RegistrationPage checkUserPasswordInputField(String value) {
        passwordInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", value));

        return this;
    }

    @Step("Проверка наличия и корректности поля подтверждения пароля")
    public RegistrationPage checkUserConfirmPasswordInputField(String value) {
        confirmPasswordInput
                .shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", value));

        return this;
    }

    @Step("Проверка радиокнопки для получения новостей на почту (Да)")
    public RegistrationPage checkEmailLetterYesRadioButton(String value) {
        EmailLetterYesRadioButton
                .shouldBe(visible, checked)
                .parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка радиокнопки для получения новостей на почту (Нет)")
    public RegistrationPage checkEmailLetterNoRadioButton(String value) {
        EmailLetterNoRadioButton
                .shouldBe(visible, not(checked))
                .parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка наименования блока с радиокнопками по получению новостепй на почту")
    public RegistrationPage checkEmailLetterRadioButtonTitle(String value) {
        EmailLetterRadioButtonTitle.shouldBe(visible).shouldHave(text(value));

        return this;
    }

    @Step("Проверка блока с чекбоксом по согласию на политику конфиденциальности")
    public RegistrationPage checkPrivacyPolicyCheckboxBlock(String value) {
        privacyPolicyCheckbox
                .shouldBe(visible)
                .shouldNotBe(checked)
                .parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка наличия гиперссылки  на политику конфиденциальности")
    public RegistrationPage checkPrivacyPolicyLink(String policyLinkTitle, String policyLink) {
        privacyPolicyLink
                .shouldBe(visible)
                .shouldHave(text(policyLinkTitle))
                .shouldHave(attribute("href", policyLink));

        return this;
    }

    @Step("Проверка заголовка страницы регистрации")
    public RegistrationPage checkRegistrationPageHeader(String value) {
        registrationPageHeader
                .shouldHave(text(value));

        return this;
    }
}