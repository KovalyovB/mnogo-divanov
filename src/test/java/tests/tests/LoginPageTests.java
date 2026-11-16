package tests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.LoginPage;
import tests.pages.MainPage;
import tests.pages.RegistrationPage;

import static tests.test_data.TestData.*;

@DisplayName("[UI] Тесты страницы авторизации")
public class LoginPageTests extends TestBase {
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("[UI] Проверка корректной загрузки формы авторизации")
    public void loginFormLoadedTest() {
        loginPage.openLoginPage()
                .checkLoginPageTitle(LOGIN_PAGE_TITLE)
                .checkAuthUserFormLoaded()
                .checkCreateUserFormLoaded();
    }

    @Test
    @DisplayName("[UI] Проверка состава формы авторизации")
    public void authBlockContentTest() {
        loginPage.openLoginPage()
                .checkUserAuthEmailTitle(AUTH_EMAIL_TITLE)
                .checkUserAuthEmailInput(AUTH_EMAIL_TITLE)
                .checkUserAuthPasswordTitle(AUTH_PASSWORD_TITLE)
                .checkUserAuthPasswordInput(AUTH_PASSWORD_TITLE)
                .checkUserAuthButton(AUTH_BUTTON_TITLE)
                .checkNewUserCaptureMessage(NEW_USER_CAPTURE_MESSAGE);
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
                .userLogout(LOGOUT_BUTTON_TITLE);

        loginPage.openLoginPage()
                .typeUserEmail(userEmail)
                .typeUserPassword(userPassword)
                .submitAuthorization()
                .isAccountPageOpenedAfterLogin(SUCCESSFUL_AUTH_TITLE)
                .checkUserAuthorizationTitle(SUCCESSFUL_AUTH_TITLE);
    }

    @Test
    @DisplayName("[UI] Проверка возврата ошибки при авторизации с не валидными данными")
    public void wrongUserAuthorizationTest() {

        loginPage.openLoginPage()
                .typeUserEmail(wrongUserEmail)
                .typeUserPassword(wrongUserPassword)
                .submitAuthorization()
                .isNotRedirectedAfterFailedLogin(LOGIN_PAGE_LINK)
                .checkWrongUserAuthorizationMessage
                        (WRONG_AUTHORIZATION_MESSAGE, ANOTHER_WRONG_AUTHORIZATION_MESSAGE);
    }
}
