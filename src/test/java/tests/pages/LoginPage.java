package tests.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.test_data.TestData.*;

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
        open("https://www.mnogodivanov.ru/login/");

        return this;
    }

    @Step("Ввод пользовательского Email на форму авторизации")
    public LoginPage typeUserEmail(String email) {
        authUserEmailInput.setValue(email);

        return this;
    }

    @Step("Ввод пользовательского пароля на форму авторизации")
    public LoginPage typeUserPassword(String password) {
        authUserPasswordInput.setValue(password);

        return this;
    }

    @Step("Клик по кнопке авторизации пользователя")
    public LoginPage submitAuthorization() {
        authUserButton.shouldBe(visible).click();

        return this;
    }

    @Step("Проверка заголовка на странице атворизации")
    public LoginPage checkLoginPageTitle() {
        authPageTitle.shouldHave(text("Вход в личный кабинет"));

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
    public LoginPage checkUserAuthEmailTitle() {
        authUserEmailInput.parent().shouldHave(text("E-Mail адрес"));

        return this;
    }

    @Step("Проверка поля ввода Email в форме авторизации")
    public LoginPage checkUserAuthEmailInput() {
        authUserEmailInput.shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", "E-Mail адрес"));

        return this;
    }

    @Step("Проверка заголовка над полем пароля в форме авторизации")
    public LoginPage checkUserAuthPasswordTitle() {
        authUserPasswordInput.parent().parent().shouldHave(text("Пароль"));

        return this;
    }

    @Step("Проверка поля ввода пароля в форме авторизации")
    public LoginPage checkUserAuthPasswordInput() {
        authUserPasswordInput.shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(attribute("placeholder", "Пароль"));

        return this;
    }

    @Step("Проверка кнопки авторизации")
    public LoginPage checkUserAuthButton() {
        authUserButton.shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(text("Войти"));

        return this;
    }

    @Step("Проверка кнопки авторизации")
    public LoginPage checkCaptureForNewUser() {
        newUserCaptureMessage.shouldBe(visible)
                .shouldHave(text(NEW_USER_CAPTURE_MESSAGE));

        return this;
    }

    @Step("Проверка успешности авторизации")
    public LoginPage checkSuccessfulUserAuthorization() {
        webdriver().shouldHave(WebDriverConditions.url(MY_ACCOUNT_LINK));

        afterAuthorizationAccountTitle.shouldHave(text("Моя учетная запись"));

        return this;
    }

    @Step("Проверка ошибки при авторизации с не валидными данынми")
    public LoginPage checkWrongUserAuthorization() {
        webdriver().shouldHave(WebDriverConditions.url(LOGIN_PAGE_LINK));

        wrongAuthorizationAller.shouldBe(visible)
                .shouldHave(text(WRONG_AUTHORIZATION_MESSAGE));


        return this;
    }
}
