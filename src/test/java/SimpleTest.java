import Helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.As;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
//import static jdk.internal.foreign.abi.aarch64.AArch64Architecture.Regs.v1;
//import static jdk.internal.module.ModulePath.of;
//import static jdk.vm.ci.aarch64.AArch64.v2;
//import static jdk.vm.ci.amd64.AMD64.k1;
//import static jdk.vm.ci.amd64.AMD64.k2;


public class SimpleTest {
    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome"; // или "firefox"
        Configuration.headless = true;
        Configuration.webdriverLogsEnabled = true; // авто-установка драйверов


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        Configuration.remote= "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");

    }

    @Test
    @Tag("second")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure",new AllureSelenide());

        step("open site", ()-> {
            open("https://github.com/selenide/selenide");
            $("#wiki-tab").$(byText("Wiki")).click();
            $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").shouldBe(visible);
            $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").click();
            $("#user-content-3-using-junit5-extend-test-class").$(byText("3. Using JUnit5 extend test class23"));
            sleep(4000);
        });


       // $("#wiki-tab").$(byText("Wikiee")).click();



//        @Test
//        public void testIssueSearch() {
//            SelenideLogger.addListener("allure",new AllureSelenide());
//            open("https://github.com/selenide/selenide");
//            $("#wiki-tab").$(byText("Wiki")).click();
//            $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").shouldBe(visible);
//            $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").click();
//            $("#user-content-3-using-junit5-extend-test-class").$(byText("3. Using JUnit5 extend test class23"));
//            sleep(4000);




    }
}
