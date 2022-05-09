package org.example.features.emag.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EmagUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Qualifier;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("EmagTestData.csv")
public class SearchByKeywordStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    public String search;
    public String result;

    @Qualifier
    public String getQualifier() {
        return search;
    }

    @Steps
    public EmagUserSteps andrei;

    @Test
    public void searching_by_keyword_should_display_the_corresponding_product() {
        andrei.is_on_the_home_page();
        andrei.enters(search);
        andrei.searches_for_products();
        andrei.should_see_product_with_title(result);
    }
}
