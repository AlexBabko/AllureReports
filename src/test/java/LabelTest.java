import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest {
    //BDD

    @Test
    @DisplayName("Display  Name static name")
    @Story("1234")
    @Owner("AlexB")
    void testStaticLabels(){

    }


    @Test
    @DisplayName("Display Name dynamic name")
    @Story("777")
    @Owner("AlexDDD")
    void testDynamicLabels(){

    }
}
