package org.example.steps.serenity;

import org.example.pages.EmagPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EmagUserSteps {
    EmagPage emagPage;

    public void is_on_the_home_page() {
        emagPage.open();
    }

    public void enters(String keyword) {
        emagPage.enter_keywords(keyword);
    }

    public void searches_for_products() {
        emagPage.lookup_products();
    }

    public void adds_the_first_product_to_cart() { emagPage.add_first_product_to_card(); }

    public void goes_to_cart_page() {
        emagPage.go_to_cart_page();
    }

    public void should_see_product_with_title(String title) {
        assertThat(emagPage.getProductTitles(), hasItem(containsString(title)));
    }

    public void should_see_product_with_title_in_cart(String title) {
        assertThat(emagPage.getCartTitles(), hasItem(containsString(title)));
    }
}
