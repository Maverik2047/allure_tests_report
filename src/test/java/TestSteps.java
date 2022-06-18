import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class TestSteps {
    public void openPage(){
        open("https://github.com");
    }
    public void repoNameInput(String value){
        $(".form-control").sendKeys(value);
        $(".form-control").submit();
    }
    public void openRepo(String value){
        $(linkText(value)).click();
    }

    public void openRepoData() {
        $(linkText("src/test")).click();
        $("[title=java]").click();
    }

    public void checkFileParseTest(String value) {
        $(".repository-content").shouldHave(Condition.text(value));
    }

    public void checkMyArrayFileNotExists(String value) {
        $(withText(value)).shouldNot(Condition.exist);
    }
}
