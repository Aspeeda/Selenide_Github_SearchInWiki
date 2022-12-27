package github;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchInGithubWikiTest {

    @Test
    @DisplayName("Search in repo Selenide tab Wiki chapter 'Soft Assertion'")
    public void testSearchInWiki() {

        step("Open Github",() -> open("https://github.com/"));

        step("Search repo Selenide, select first", () -> {
            $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
            $$("ul.repo-list li").first().$("a").click();
        });

        step("click tab Wiki",()-> $("#wiki-tab").click());

        step("Check SoftAssertion is appear",()->
            $("#wiki-body").shouldHave(text("Soft assertions")));

        step("Check text in link SoftAssertion ",()-> {
            $("#wiki-body").$(byText("Soft assertions")).click();
            $("#wiki-body").shouldHave(text("JUnit5 extension"));

        });
    }
}
