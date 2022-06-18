import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {

    private final String myRepo = "Maverik2047/zip_file_tests";

    @Test
    void testMyGitHubSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Вводим в поиск название репозитория", () -> {
            $(".form-control").sendKeys(myRepo);
            $(".form-control").submit();
        });
        step("Заходим в найденный репозиторий", () -> {

            $(linkText("Maverik2047/zip_file_tests")).click();
        });
        step("Переходим в содержимое найденного репозитория", () -> {
            $(linkText("src/test")).click();
            $("[title=java]").click();
        });
        step("Проверяем что существует файл FileParseTest.java", () -> {
            $(".repository-content").shouldHave(Condition.text("FileParseTest.java"));
        });
        step("Проверяем что не существует файл myArray.html", () -> {
            $(withText("myArray.html")).shouldNot(Condition.exist);
        });

    }

    @DisplayName("Annotated test with steps")
    @Test
    void testAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        TestSteps testSteps = new TestSteps();
        testSteps.openPage();
        testSteps.repoNameInput(myRepo);
        testSteps.openRepo(myRepo);
        testSteps.openRepoData();
        testSteps.checkFileParseTest("FileParseTest.java");
        testSteps.checkMyArrayFileNotExists("myArray.html");


    }

}
