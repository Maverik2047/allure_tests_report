import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Owner("Maverik2047")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Новый пепозиторий")
    @Story("Был создан новый репозиторий")
    @DisplayName("Проверка поиска репозитория")
    @Description("Найти мой репозиторий и проверить содержимое")
    @Link(name = "Github", url = "https://github.com/")
    public void staticLabels() {

    }

    @Test
    public void dynamicLabels() {
        Allure.label("owner", "Maverik2047");
        Allure.label("Severity", SeverityLevel.CRITICAL.value());
        Allure.feature("Новый пепозиторий");
        Allure.story("Был создан новый репозиторий");
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setName("Тест на поискре позитория"));
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setDescription("Найти мой репозиторий и проверить содержимое"));
        Allure.link("Github", "https://github.com/");

    }

}
