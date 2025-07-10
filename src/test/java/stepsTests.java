import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class stepsTests {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome"; // или "firefox"
        Configuration.headless = true;
        Configuration.webdriverLogsEnabled = true; // авто-установка драйверов
        Configuration.remote= "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("allure",new AllureSelenide());
    }
    
    @Test
    @Tag("second")
    void testlambdaStep1 () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("открываем сайт", () -> {
            open("https://github.com/selenide/selenide");
        });


        step("жмем на вики табу", () -> {
            $("#wiki-tab").$(byText("Wiki")).click();
        });


        step("проверка видимости вики", () -> {
            $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").shouldBe(visible);
        });


        step("проверка текста вики", () -> {
            $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").click();
        });

        step("3. Using JUnit5 extend test class23\"", () -> {
            $("#user-content-3-using-junit5-extend-test-class").$(byText("3. Using JUnit5 extend test class23"));
        });
        sleep(6000);

    }
         @Test
         @Tag("second")
        public void testAnnotatedExample() {
            webTests steps = new webTests();
            steps.openMainPage();
            steps.clickOnWikiTab();
            steps.visibility();
            steps.textChecking();


        }

    }



//    @Test
//    void testlambdaStep2 (){
//        SelenideLogger.addListener("allure",new AllureSelenide());
//        open("httpsdsds://github.com/selenide/selenide");
//        $("#wiki-tab").$(byText("Wiki")).click();
//        $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").shouldBe(visible);
//        $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").click();
//        $("#user-content-3-using-junit5-extend-test-class").$(byText("3. Using JUnit5 extend test class23"));
//        sleep(4000);
//        $("#wiki-tab").$(byText("Wikieeg")).click();
//
//
//    }

