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

    public void checkFileParseTest() {
        $(".repository-content").shouldHave(Condition.text("FileParseTest.java"));
    }

    public void checkMyArrayFileNotExists() {
        $(withText("myArray.html")).shouldNot(Condition.exist);
    }
}
