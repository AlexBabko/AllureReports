import com.codeborne.selenide.Configuration;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class webTests {
    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome"; // или "firefox"
        Configuration.headless = true;
        Configuration.webdriverLogsEnabled = true; // авто-установка драйверов
    }
    @Test
    @Step
    public void openMainPage() {
        open("https://github.com/selenide/selenide");
    }

    @Step
    public void clickOnWikiTab() {
        $("#wiki-tab").$(byText("Wiki")).click();
    }


    @Step
    public void visibility() {
        $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").shouldBe(visible);
    }

    @Step
    public void textChecking() {
        $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").click();
    }


    @Step
    public void textJunit() {
        $("#user-content-3-using-junit5-extend-test-class").$(byText("3. Using JUnit5 extend test class23"));

    }
   @Attachment(value = "Screenshot", type = "image/png")
   public byte[] takeScreenshot() {
            // Return the byte[] of the screenshot
   return new byte[0]; // Replace with real screenshot logic
    }


}
