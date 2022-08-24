package guru.qa;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class WebSteps {

    @Step("Открываем страницу")
    public void openPage(String url) {
        open(url);
    }

    @Step("Вводим искомый репозиторий и перходим на страницу с результатами")
    public void searchForRepository(String queryRepository) {
        $("input[name='q']").click();
        $("input[name='q']").setValue(queryRepository);
        $("input[name='q']").submit();
    }

    @Step("Кликаем на найденный репозиторий")
    public void clickOnRepositoryLink() {
        $("a[href='/selenide/selenide").click();
    }

    @Step("Переходим на таб ISSUES ")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем название Issue")
    public void shouldSeeIssueWithName(String nameIssue) {
        $("#issue_1927_link").shouldHave(text(nameIssue));
    }
}
