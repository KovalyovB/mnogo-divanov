package tests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.MainPage;
import tests.test_data.TestData;

import java.util.Map;

@DisplayName("[UI] Тесты главной страницы сайта")
public class MainPageTests {
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
                .checkSignInButton()
                .checkCreateAccountButton()
                .checkMyOrdersButton()
                .checkWishListButton()
                .checkForgotPasswordButton();
    }

    @Test
    @DisplayName("[UI] Проверка состава header")
    public void headerTest() {
        mainPage.openMainPage()
                .checkHeaderLogo()
                .checkHeaderCatalogButton()
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
