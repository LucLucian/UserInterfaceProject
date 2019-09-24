package tests;

import org.testng.annotations.Test;
import pageobjects.SearchPageObject;
import pageobjects.SearchResultsPageObject;
import utils.ExtentTestManager;

import java.lang.reflect.Method;

public class SearchTests extends BaseTestClass {

    @Test
    public void SearchByAutocomplete(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(), "Search by auto-complete suggestion and validated that the product page is the one selected from suggestions");
        SearchPageObject.searchInput().sendKeys("mobile");
        SearchPageObject.ClickSuggestionByName("mobiler akku");
        SearchPageObject.searchButton().click();
        SearchResultsPageObject.getMainTitleText().contains("Ihre Suche nach mobiler akku");
    }
}
