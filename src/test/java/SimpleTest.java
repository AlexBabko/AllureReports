import com.codeborne.selenide.commands.As;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SimpleTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure",new AllureSelenide());
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").$(byText("Wiki")).click();
        $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").shouldBe(visible);
        $("[href='/selenide/selenide/wiki/How-Selenide-creates-WebDriver']").click();
        $("#user-content-3-using-junit5-extend-test-class").$(byText("3. Using JUnit5 extend test class23"));
        sleep(4000);
       // $("#wiki-tab").$(byText("Wikiee")).click();





    }
}
