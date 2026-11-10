# 🛋️ Автотесты для сайта «Много Диванов»

Автоматизированное тестирование интернет-магазина мебели **«Много Диванов»** — [https://www.mnogodivanov.ru/](https://www.mnogodivanov.ru/)

<div align="center">
  <img src="src/test/java/images/divan_main.png" alt="Много Диванов" width="800"/>
</div>

---

## 📋 Содержание

- [🛠️ Технологии и инструменты](#️-технологии-и-инструменты)
- [✅ Примеры автоматизированных тест-кейсов](#-примеры-автоматизированных-тест-кейсов)
- [⚙️ Сборка Jenkins](#️-сборка-jenkins)
- [💻 Команды для запуска в терминале](#-команды-для-запуска-в-терминале)
- [📊 Allure отчет](#-allure-отчет)
- [🧪 Интеграция Allure TestOps](#-интеграция-allure-testops)
- [🔗 Интеграция с Jira](#-интеграция-с-jira)
- [📨 Уведомления в Telegram](#-уведомления-в-telegram)
- [🎥 Пример видео Selenoid тестов в Allure отчете](#-пример-видео-selenoid-тестов-в-allure-отчете)
- [🧰 Стек технологий](#-стек-технологий)

---

## 🛠️ Технологии и инструменты

| 🧩 Инструмент | 🎯 Назначение |
|---|---|
| ☕ **Java** | Язык написания автотестов |
| 🧪 **JUnit 5** | Фреймворк модульного тестирования |
| 🐘 **Gradle** | Система автоматической сборки |
| 🏗️ **Jenkins** | Удалённый запуск с выбором параметров тестирования |
| 📊 **Allure** | Формирование отчетов о пройденных тестах |
| 📨 **Telegram Bot** | Отправка отчетов о тестировании в мессенджер |
| 🧬 **Allure TestOps** | Интеграция с системой управления тестированием |
| 🔗 **Jira Software** | Интеграция с трекером задач |

---

## ✅ Примеры автоматизированных тест-кейсов

- Функциональные проверки формы регистрации
- Проверки UI формы регистрации
- Проверки UI на главной странице сайта
- Функциональные проверки формы авторизации
- Проверки UI на форме авторизации

---

## ⚙️ Сборка Jenkins

<div align="center">
  <!-- 🖼️ Сюда вставь скриншот сборки Jenkins -->
  <img src="src/test/java/images/jenkins_ui.png" alt="Jenkins Build" width="800"/>
</div>

### 🎛️ Параметры сборки

- BROWSER (браузер, по умолчанию chrome)
- BROWSER_VERSION (версия браузера, по умолчанию 100.0)
- BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)
- HEADLESS (Использование GUI при прогоне автотестов, по умолчанию GUI=true)

---

## 💻 Команды для запуска в терминале

Удалённый запуск в Selenoid (конфигурация по умолчанию):
```bash  
./gradlew clean test
```
Локальный запуск в своём браузере:
```bash
./gradlew clean test -Dremote= -Dheadless=false
```

---

## 📊 Allure отчет

### 🏠 Основная страница
<div align="center">
  <img src="src/test/java/images/jenkins_ui.png" alt="Много Диванов" width="800"/>
</div>

### 🧾 Тест-кейсы

<div align="center">
  <img src="src/test/java/images/allure_ui_tests.png" alt="Много Диванов" width="800"/>
</div>

---

## 🧪 Интеграция Allure TestOps

### 🤖 Авто-тесты

<div align="center">
  <img src="src/test/java/images/testOps_auto.png" alt="Много Диванов" width="800"/>
</div>

### 👨‍🔧 Ручные тесты

<div align="center">
  <img src="src/test/java/images/testOps_manual.png" alt="Много Диванов" width="800"/>
</div>

---

## 🔗 Интеграция с Jira

Результаты автопрогонов автоматически отображаются прямо в задаче Jira — статус тестов, ссылки на Allure отчет и подробная информация о прохождении. 🚀

<div align="center">
  <img src="src/test/java/images/jira.png" alt="Много Диванов" width="800"/>
</div>

---

## 📨 Уведомления в Telegram

По итогам каждого прогона в Telegram-бот отправляется отчет со статистикой прохождения тестов. 📬

<!-- 🖼️ Сюда вставь скриншот уведомления в Telegram -->

---

## 🎥 Пример видео Selenoid тестов в Allure отчете

В Allure отчете доступна видеозапись прохождения каждого теста, запущенного в Selenoid — это позволяет детально разобрать шаги выполнения и локализовать причину падения. 🎬

<p align="center">
<img title="Selenoid Video" src="src/test/java/images/registration_gif.gif" width="550" height="350"  alt="video">   
</p>

---

## 🧰 Стек технологий

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-FF5722?style=for-the-badge&logo=allure&logoColor=white)
![Selenoid](https://img.shields.io/badge/Selenoid-00A98F?style=for-the-badge&logo=selenium&logoColor=white)
![Telegram](https://img.shields.io/badge/Telegram-26A5E4?style=for-the-badge&logo=telegram&logoColor=white)
![Jira](https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=jira&logoColor=white)

</div>

---

<div align="center">
  <sub>⚠️ Тестовый демонстрационный пример. Автор не имеет прав на сайт <a href="https://www.mnogodivanov.ru/">mnogodivanov.ru</a>.</sub>
</div>
