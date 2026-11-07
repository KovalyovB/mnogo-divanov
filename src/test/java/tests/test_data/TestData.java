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
