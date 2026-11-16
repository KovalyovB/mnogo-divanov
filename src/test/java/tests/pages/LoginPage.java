package tests.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement authPageTitle = $(".mnd-account-title");
    private final SelenideElement authUserForm =
            $(byText("Новый покупатель")).ancestor(".account-login__wrapper");
    private final SelenideElement createUserForm =
            $(byText("Постоянный покупатель")).ancestor(".account-login__wrapper");

    private final SelenideElement authUserEmailInput = $("#input-email");
    private final SelenideElement authUserPasswordInput = $("#input-password");
    private final SelenideElement authUserButton = $(".account-login__btn.btn.btn-primary");
    private final SelenideElement newUserCaptureMessage = $(".mnd-account-caption");
    private final SelenideElement afterAuthorizationAccountTitle = $(".breadcrumb-h1 ");
    private final SelenideElement wrongAuthorizationAller = $(".alert.alert-danger.alert-dismissible");


    @Step("Открытие страницы авторизации")
    public LoginPage openLoginPage() {
        open("/login/");

        return this;
    }

    @Step("Ввод пользовательского Email на форму авторизации")
    public LoginPage typeUserEmail(String value) {
        authUserEmailInput.setValue(value);

        return this;
    }

    @Step("Ввод пользовательского пароля на форму авторизации")
    public LoginPage typeUserPassword(String value) {
        authUserPasswordInput.setValue(value);

        return this;
    }

    @Step("Клик по кнопке авторизации пользователя")
    public LoginPage submitAuthorization() {
        authUserButton.shouldBe(visible).click();

        return this;
    }

    @Step("Проверка заголовка на странице атворизации")
    public LoginPage checkLoginPageTitle(String value) {
        authPageTitle.shouldHave(text(value));

        return this;
    }

    @Step("Проверка загрузки формы авторизации пользователя")
    public LoginPage checkAuthUserFormLoaded() {
        authUserForm.shouldBe(visible);

        return this;
    }

    @Step("Проверка загрузки формы создания пользователя")
    public LoginPage checkCreateUserFormLoaded() {
        createUserForm.shouldBe(visible);

        return this;
    }

    @Step("Проверка заголовка над полем Email в форме авторизации")
    public LoginPage checkUserAuthEmailTitle(String value) {
        authUserEmailInput.parent().shouldHave(text(value));

        return this;
    }

    @Step("Проверка поля ввода Email в форме авторизации")
    public LoginPage checkUserAuthEmailInput(String value) {
        authUserEmailInput.shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", value));

        return this;
    }

    @Step("Проверка заголовка над полем пароля в форме авторизации")
    public LoginPage checkUserAuthPasswordTitle(String value) {
        authUserPasswordInput.parent().parent().shouldHave(text(value));

        return this;
    }

    @Step("Проверка поля ввода пароля в форме авторизации")
    public LoginPage checkUserAuthPasswordInput(String value) {
        authUserPasswordInput.shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", value));

        return this;
    }

    @Step("Проверка кнопки авторизации")
    public LoginPage checkUserAuthButton(String value) {
        authUserButton.shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка кнопки авторизации")
    public LoginPage checkCaptureForNewUser(String value) {
        newUserCaptureMessage.shouldBe(visible)
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка успешности авторизации")
    public LoginPage checkSuccessfulUserAuthorization(String accountLink, String authTitle) {
        webdriver().shouldHave(WebDriverConditions.url(accountLink));

        afterAuthorizationAccountTitle.shouldHave(text(authTitle));

        return this;
    }

    @Step("Проверка ошибки при авторизации с не валидными данынми")
    public LoginPage checkWrongUserAuthorization(String pageLink, String wrongAuthMessage, String wrongAuth2Message) {
        webdriver().shouldHave(WebDriverConditions.url(pageLink));

        wrongAuthorizationAller.shouldBe(visible)
                .shouldHave(anyOf(
                        text(wrongAuthMessage),
                        text(wrongAuth2Message)));


        return this;
    }
}
