import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class TestSteps {
    @Step("Открываем главную страницу")
    public void openPage() {

        open("https://github.com");
    }

    @Step("Вводим в поиск название репозитория")
    public void repoNameInput(String value) {
        $(".form-control").sendKeys(value);
        $(".form-control").submit();
    }

    @Step("Заходим в найденный репозиторий")
    public void openRepo(String value) {
        $(linkText(value)).click();
    }

    @Step("Переходим в содержимое найденного репозитория")
    public void openRepoData() {
        $(linkText("src/test")).click();
        $("[title=java]").click();
    }

    @Step("Проверяем что существует файл FileParseTest.java")
    public void checkFileParseTest(String value) {
        $(".repository-content").shouldHave(Condition.text(value));
    }

    @Step("Проверяем что не существует файл myArray.html")
    public void checkMyArrayFileNotExists(String value) {
        $(withText(value)).shouldNot(Condition.exist);
    }
}
