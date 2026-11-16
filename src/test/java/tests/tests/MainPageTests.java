package tests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.MainPage;
import tests.test_data.TestData;

import java.util.Map;

import static tests.test_data.TestData.*;

@DisplayName("[UI] Тесты главной страницы сайта")
public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("[UI] Проверка состава и гиперссылок навигационной панели в шапке страницы")
    public void verifyNavigationBarContentTest() {

        Map<String, String> expectedNavigationBarMenu = TestData.getExpectedNavigationMenu();

        mainPage.openMainPage()
                .checkNavigationMatches(expectedNavigationBarMenu);
    }

    @Test
    @DisplayName("[UI] Проверка меню личного кабинета")
    public void accountMenuTest() {

        mainPage.openMainPage()
                .clickAccountButton()
                .checkAccountMenuIsOpened()
                .checkSignInButton(LOGIN_BUTTON_TITLE, SIGN_IN_LINK)
                .checkCreateAccountButton(CREATE_USER_BUTTON_TITLE, CREATE_ACCOUNT_LINK)
                .checkMyOrdersButton(USER_ORDERS_BUTTON_TITLE, MY_ORDERS_LINK)
                .checkWishListButton(WISH_LIST_BUTTON_TITLE, WISH_LIST_LINK)
                .checkForgotPasswordButton(FORGOT_PASSWORD_BUTTON_TITLE, FORGOT_PASSWORD_LINK);
    }

    @Test
    @DisplayName("[UI] Проверка состава header")
    public void headerTest() {
        mainPage.openMainPage()
                .checkHeaderLogo()
                .checkHeaderCatalogButton(CATALOG_BUTTON_TITLE)
                .checkHeaderSearchForm()
                .checkHeaderWishListButton()
                .checkHeaderCompareButton()
                .checkHeaderCartButton();
    }

    @Test
    @DisplayName("[UI] Проверка состава и гиперссылок навигационной панели по типам мебели")
    public void verifyMainFurnitureTypeContentTest() {

        Map<String, String> expectedMainFurnitureTypeContent = TestData.getExpectedMainFurnitureTypeContent();

        mainPage.openMainPage()
                .checkMainFurnitureTypeContentMatches(expectedMainFurnitureTypeContent);
    }
}
