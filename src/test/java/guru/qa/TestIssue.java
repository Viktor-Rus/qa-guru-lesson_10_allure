package guru.qa;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class TestIssue {

    String nameIssue = "Add caching API into standard API";
    String urlGitHub = "https://github.com/";
    String queryRepository = "selenide";


    @Test
    void selenideIssueTest(){
        open(urlGitHub);
        $("input[name='q']").click();
        $("input[name='q']").setValue(queryRepository);
        $("input[name='q']").submit();
        $("a[href='/selenide/selenide").click();
       $("#issues-tab").click();
       $("#issue_1927_link").shouldHave(text(nameIssue));

    }
    @Test
    void lambdaIssueTest(){
        step("Открываем главную страницу", () -> {
            open(urlGitHub);
        });
        step("Вводим искомый репозиторий и перходим на страницу с результатами", () -> {
            $("input[name='q']").click();
            $("input[name='q']").setValue(queryRepository);
            $("input[name='q']").submit();
        });
        step("Кликаем на найденный репозиторий", () -> {
            $("a[href='/selenide/selenide").click();
        });
        step("Переходим на таб ISSUES ", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем название Issue  ", () -> {
            $("#issue_1927_link").shouldHave(text(nameIssue));
        });

    }
    @Test
    void stepIssueTest(){
        WebSteps steps = new WebSteps();

        steps.openPage(urlGitHub);
        steps.searchForRepository(queryRepository);
        steps.clickOnRepositoryLink();
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(nameIssue);

    }
}
