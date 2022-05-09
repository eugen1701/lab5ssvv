package org.example.features.emag.addtocart;

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
public class AddToCartStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    public String search;
    public String result;

    @Qualifier
    public String getQualifier() {
        return search;
    }

    @Steps
    public EmagUserSteps catalin;

    @Test
    public void searching_by_keyword_should_display_the_corresponding_product() {
        catalin.is_on_the_home_page();
        catalin.enters(search);
        catalin.searches_for_products();
        catalin.adds_the_first_product_to_cart();
        catalin.goes_to_cart_page();
        catalin.should_see_product_with_title_in_cart(result);
    }
}
