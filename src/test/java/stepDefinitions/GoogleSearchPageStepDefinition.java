package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.GoogleSearchPage;

public class GoogleSearchPageStepDefinition {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("I am on the {string} page")
    public void openTheGooglePage(String domain) {
        googleSearchPage.openGoogleSearchPage(domain);
    }

    @When("Enter {string} in the search field and click search button")
    public void enterWordInSearchFieldAndClickSearchButton(String searchWord) {
        googleSearchPage.searchFor(searchWord);
    }

}
