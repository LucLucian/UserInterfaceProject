import org.testng.annotations.Test;
import pageobjects.SearchPageObject;
import pageobjects.SearchResultsPageObject;

public class SearchTests extends BaseTestClass {

    @Test
    public void SearchByAutocomplete() throws Exception {
        SearchPageObject.searchInput().sendKeys("mobile");
        Thread.sleep(2000);
        SearchPageObject.ClickSuggestionByName("mobiler akku");
        SearchPageObject.searchButton().click();
        SearchResultsPageObject.getMainTitleText().contains("Ihre Suche nach mobiler akku");
    }
}
