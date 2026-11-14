package tests.test_data;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestData {

    public static final String SUCCESSFUL_REGISTRATION_HEADER = "Ваша учётная запись создана!";
    public static final String WRONG_CONFIRMATION_ALERT_MESSAGE = " Вы должны прочитать и согласиться с Политика конфиденциальности!";
    public static final String REGISTRATION_WITHOUT_FIRST_NAME_ERROR = "Имя должно содержать от 1 до 32 символов!";
    public static final String REGISTRATION_WITHOUT_LAST_NAME_ERROR = "Фамилия должна содержать от 1 до 32 символов!";
    public static final String REGISTRATION_WITHOUT_PHONE_NUMBER_ERROR = "Номер телефона должен содержать от 3 до 32 символов!";
    public static final String REGISTRATION_WITHOUT_EMAIL_ERROR = "E-Mail адрес введен неверно!";
    public static final String REGISTRATION_WITHOUT_PASSWORD_ERROR = "Пароль должен содержать от 4 до 20 символов!";
    public static final String PRIVACY_POLICY_LINK = "https://www.mnogodivanov.ru/index.php?route=information/information/agree&information_id=3";

    public static final String SIGN_IN_LINK = "https://www.mnogodivanov.ru/login/";
    public static final String CREATE_ACCOUNT_LINK = "https://www.mnogodivanov.ru/create-account/";
    public static final String MY_ORDERS_LINK = "https://www.mnogodivanov.ru/order-history/";
    public static final String WISH_LIST_LINK = "https://www.mnogodivanov.ru/wishlist/";
    public static final String FORGOT_PASSWORD_LINK = "https://www.mnogodivanov.ru/forgot-password/";
    public static final String NEW_USER_CAPTURE_MESSAGE
            = "Сохраните контактные данные и адреса доставки," +
            " просматривайте историю заказов и избранные товары в своём кабинете.";

    public static final String MY_ACCOUNT_LINK = "https://www.mnogodivanov.ru/my-account/";
    public static final String LOGIN_PAGE_LINK = "https://www.mnogodivanov.ru/login/";
    public static final String WRONG_AUTHORIZATION_MESSAGE = " Не найден введённый адрес E-Mail и/или пароль указан неправильно.";
    public static final String ANOTHER_WRONG_AUTHORIZATION_MESSAGE = "Ваша учетная запись превысила допустимое количество попыток входа в систему. Пожалуйста, попробуйте еще через 1 час.";
    public static final String LOGIN_PAGE_TITLE = "Вход в личный кабинет";
    public static final String AUTH_EMAIL_TITLE = "E-Mail адрес";
    public static final String AUTH_PASSWORD_TITLE = "Пароль";
    public static final String AUTH_BUTTON_TITLE = "Войти";
    public static final String SUCCESSFUL_AUTH_TITLE = "Моя учетная запись";
    public static final String LOGOUT_BUTTON_TITLE = "Выход";
    public static final String LOGIN_BUTTON_TITLE = "Войти в кабинет";
    public static final String CREATE_USER_BUTTON_TITLE = "Создать аккаунт";
    public static final String USER_ORDERS_BUTTON_TITLE = "Мои заказы";
    public static final String WISH_LIST_BUTTON_TITLE = "Избранное";
    public static final String FORGOT_PASSWORD_BUTTON_TITLE = "Восстановить пароль";
    public static final String CATALOG_BUTTON_TITLE = "Каталог";
    public static final String REGISTRATION_FIRST_NAME_TITLE = "Имя";
    public static final String REGISTRATION_LAST_NAME_TITLE = "Фамилия";
    public static final String REGISTRATION_PHONE_NUMBER_TITLE = "Телефон";
    public static final String REGISTRATION_EMAIL_TITLE = "E-Mail";
    public static final String REGISTRATION_PASSWORD_TITLE = "Пароль";
    public static final String PLACEHOLDER_FIRST_NAME_TITLE = "Имя";
    public static final String PLACEHOLDER_LAST_NAME_TITLE = "Фамилия";
    public static final String PLACEHOLDER_PHONE_NUMBER_TITLE = "Телефон";
    public static final String PLACEHOLDER_EMAIL_TITLE = "E-Mail";
    public static final String PLACEHOLDER_PASSWORD_TITLE = "Пароль";
    public static final String PLACEHOLDER_PASSWORD_CONFIRM_TITLE = "Подтвердите пароль";
    public static final String YES_RADIO_BUTTON_TITLE = "Да";
    public static final String NO_RADIO_BUTTON_TITLE = "Нет";
    public static final String CONFIRM_LETTER_BUTTON_TITLE = "Получать новости на E-Mail";
    public static final String CONFIRM_POLICY_CHECKBOX_TITLE = "Я прочитал(а) и согласен(на) с условиями ";
    public static final String POLICY_LINK_TITLE = "Политика конфиденциальности";
    public static final String REGISTRATION_PAGE_HEADER = "Регистрация";

    public static Map<String, String> getExpectedNavigationMenu() {
        Map<String, String> expectedMenu = new LinkedHashMap<>();

        expectedMenu.put("О компании", "https://www.mnogodivanov.ru/o-kompanii/");
        expectedMenu.put("Оплата и доставка", "https://www.mnogodivanov.ru/oplata-i-dostavka/");
        expectedMenu.put("Возврат", "https://www.mnogodivanov.ru/vozvrat-garantiya/");
        expectedMenu.put("Каталог мебели", "https://www.mnogodivanov.ru/katalog/");
        expectedMenu.put("Контакты", "https://www.mnogodivanov.ru/kontakty/");
        expectedMenu.put("Статьи", "https://www.mnogodivanov.ru/articles/");

        return expectedMenu;
    }

    public static Map<String, String> getExpectedMainFurnitureTypeContent() {
        Map<String, String> expectedMenu = new LinkedHashMap<>();

        expectedMenu.put("", "https://www.mnogodivanov.ru/katalog/matrasy/");
        expectedMenu.put("Диваны", "https://www.mnogodivanov.ru/katalog/divany/");
        expectedMenu.put("Мягкая мебель на заказ", "https://www.mnogodivanov.ru/mebel-na-zakaz/");
        expectedMenu.put("Шкафы", "https://www.mnogodivanov.ru/katalog/shkafy/");
        expectedMenu.put("Мебель для кухни", "https://www.mnogodivanov.ru/katalog/mebel-dlya-kuhni/");
        expectedMenu.put("Распродажа", "https://www.mnogodivanov.ru/rasprodaja/");

        return expectedMenu;
    }
}
