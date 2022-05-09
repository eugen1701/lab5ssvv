package org.example.pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DefaultUrl("https://www.emag.ro")
public class EmagPage extends PageObject {
    @FindBy(id = "searchboxTrigger")
    private WebElementFacade searchBox;

    @FindBy(className = "searchbox-submit-button")
    private WebElementFacade searchButton;

    @FindBy(linkText = "Vezi detalii cos")
    private WebElementFacade cartButton;

    public void enter_keywords(String keyword) {
        searchBox.type(keyword);
    }

    public void lookup_products() {
        searchButton.click();
    }

    public void add_first_product_to_card() {
        Optional<WebElementFacade> addToCartButton = findFirst(By.className("yeahIWantThisProduct"));
        addToCartButton.get().click();
        waitABit(2000);
    }

    public void go_to_cart_page() {
        cartButton.click();
    }

    public List<String> getProductTitles() {
        ListOfWebElementFacades productTitles = findAll(By.cssSelector("[data-zone=title]"));
        return productTitles.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public List<String> getCartTitles() {
        ListOfWebElementFacades productTitles = findAll(By.cssSelector(".main-product-title"));
        return productTitles.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
