package tests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.LoginPage;
import tests.pages.MainPage;
import tests.pages.RegistrationPage;

@DisplayName("[UI] Тесты страницы авторизации")
public class LoginPageTests extends TestBase {
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("[UI] Проверка корректной загрузки формы авторизации")
    public void loginFormLoadedTest() {
        loginPage.openLoginPage()
                .checkLoginPageTitle()
                .checkAuthUserFormLoaded()
                .checkCreateUserFormLoaded();

    }

    @Test
    @DisplayName("[UI] Проверка состава формы авторизации")
    public void authBlockContentTest() {
        loginPage.openLoginPage()
                .checkUserAuthEmailTitle()
                .checkUserAuthEmailInput()
                .checkUserAuthPasswordTitle()
                .checkUserAuthPasswordInput()
                .checkUserAuthButton()
                .checkCaptureForNewUser();
    }

    @Test
    @DisplayName("[UI] Успешная авторизация пользователя")
    public void successfulUserAuthorizationTest() {

        registrationPage.openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeMobilePhone(userPhoneNumber)
                .typeUserEmail(userEmail)
                .typePassword(userPassword)
                .typePasswordConfirmation(userPassword)
                .acceptPrivacyPolicy()
                .submitRegistration();

        mainPage.clickAccountButton()
                .userLogout();

        loginPage.openLoginPage()
                .typeUserEmail(userEmail)
                .typeUserPassword(userPassword)
                .submitAuthorization()
                .checkSuccessfulUserAuthorization();
    }

    @Test
    @DisplayName("[UI] Проверка возврата ошибки при авторизации с не валидными данными")
    public void wrongUserAuthorizationTest() {

        loginPage.openLoginPage()
                .typeUserEmail(wrongUserEmail)
                .typeUserPassword(wrongUserPassword)
                .submitAuthorization()
                .checkWrongUserAuthorization();

    }
}
