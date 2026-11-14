package tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static tests.test_data.TestData.*;

public class MainPage {

    private final ElementsCollection navLinks = $$("ul.top-links__ul a.top-links__a");
    private final ElementsCollection furnitureTypeLinks = $$("ul.menu__collapse a.menu__level-1-a");
    private final SelenideElement accountButton = $("#account");
    private final SelenideElement accountMenu = $("#mnd-account-menu");
    private final SelenideElement headerLogo = $(".header-logo");
    private final SelenideElement headerCatalogButton = $(".header-menu__btn.btn");
    private final SelenideElement headerSearchForm = $("#site-search");
    private final SelenideElement headerWishListButton = $(".header-block__item.header-block__item-wishlist");
    private final SelenideElement headerCompareButton = $(".header-block__item.header-block__item-compare");
    private final SelenideElement headerCartButton = $(".header-block__item.header-block__item-cart");


    @Step("Открытие главной страницы")
    public MainPage openMainPage() {
        open("");

        return this;
    }

    @Step("Получение состава навигационной панели в шапке страницы")
    public Map<String, String> getActualNavigationMap() {
        Map<String, String> actualMap = new LinkedHashMap<>();
        navLinks.forEach(link -> {
            String name = link.getText().trim();
            String href = link.getAttribute("href");
            actualMap.put(name, href);
        });
        return actualMap;
    }

    @Step("Получение состава навигационной панели по типам мебели")
    public Map<String, String> getActualFurnitureTypeContentMap() {
        Map<String, String> actualMap = new LinkedHashMap<>();
        furnitureTypeLinks.forEach(link -> {
            String name = link.getText().trim();
            String href = link.getAttribute("href");
            actualMap.put(name, href);
        });
        return actualMap;
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public MainPage clickAccountButton() {
        accountButton.shouldBe(visible).click();

        return this;
    }

    @Step("Деавторизация пользователя")
    public MainPage userLogout() {
        accountMenu.find(byText(LOGOUT_BUTTON_TITLE)).click();

        return this;
    }

    @Step("Проверка открытия меню личного кабинета")
    public MainPage checkAccountMenuIsOpened() {
        accountMenu.shouldBe(visible);

        return this;
    }

    @Step("Проверка наличия кнопки 'Войти в кабинет' в меню личного кабинета")
    public MainPage checkSignInButton() {
        accountMenu.$(byText(LOGIN_BUTTON_TITLE))
                .shouldHave(attribute("href", SIGN_IN_LINK))
                .shouldBe(visible)
                .shouldBe(clickable);

        return this;
    }

    @Step("Проверка наличия кнопки 'Создать аккаунт' в меню личного кабинета")
    public MainPage checkCreateAccountButton() {
        accountMenu.$(byText(CREATE_USER_BUTTON_TITLE))
                .shouldHave(attribute("href", CREATE_ACCOUNT_LINK))
                .shouldBe(visible)
                .shouldBe(clickable);

        return this;
    }

    @Step("Проверка наличия кнопки 'Мои заказы' в меню личного кабинета")
    public MainPage checkMyOrdersButton() {
        accountMenu.$(byText(USER_ORDERS_BUTTON_TITLE))
                .shouldHave(attribute("href", MY_ORDERS_LINK))
                .shouldBe(visible)
                .shouldBe(clickable);

        return this;
    }

    @Step("Проверка наличия кнопки 'Избранное' в меню личного кабинета")
    public MainPage checkWishListButton() {
        accountMenu.$(byText(WISH_LIST_BUTTON_TITLE))
                .shouldHave(attribute("href", WISH_LIST_LINK))
                .shouldBe(visible)
                .shouldBe(clickable);

        return this;
    }

    @Step("Проверка наличия кнопки 'Восстановить пароль' в меню личного кабинета")
    public MainPage checkForgotPasswordButton() {
        accountMenu.$(byText(FORGOT_PASSWORD_BUTTON_TITLE))
                .shouldHave(attribute("href", FORGOT_PASSWORD_LINK))
                .shouldBe(visible)
                .shouldBe(clickable);

        return this;
    }

    @Step("Проверка наличия логотипа в header")
    public MainPage checkHeaderLogo() {
        headerLogo.shouldBe(visible)
                .shouldBe(clickable);

        return this;
    }

    @Step("Проверка наличия кнопки каталога  в header")
    public MainPage checkHeaderCatalogButton() {
        headerCatalogButton.shouldBe(visible)
                .shouldBe(clickable)
                .shouldHave(text(CATALOG_BUTTON_TITLE));

        return this;
    }

    @Step("Проверка наличия формы поиска в header")
    public MainPage checkHeaderSearchForm() {
        headerSearchForm.shouldBe(visible)
                .shouldBe(clickable);

        return this;
    }

    @Step("Проверка наличия кнопки 'Избранное' в header")
    public MainPage checkHeaderWishListButton() {
        headerWishListButton.shouldBe(visible)
                .shouldBe(clickable);

        return this;
    }

    @Step("Проверка наличия кнопки 'Сравнение' в header")
    public MainPage checkHeaderCompareButton() {
        headerCompareButton.shouldBe(visible)
                .shouldBe(clickable);

        return this;
    }

    @Step("Проверка наличия кнопки 'Корзина' в header")
    public MainPage checkHeaderCartButton() {
        headerCartButton.shouldBe(visible)
                .shouldBe(clickable);

        return this;
    }

    @Step("Сверка ожидаемого состава навгационной панели с актуальным на странице")
    public void checkNavigationMatches(Map<String, String> expectedMap) {

        assertThat(getActualNavigationMap())
                .containsExactlyEntriesOf(expectedMap);
    }

    @Step("Сверка ожидаемого состава навгационной панели с актуальным на странице")
    public void checkMainFurnitureTypeContentMatches(Map<String, String> expectedMap) {

        assertThat(getActualFurnitureTypeContentMap())
                .containsExactlyEntriesOf(expectedMap);
    }
}