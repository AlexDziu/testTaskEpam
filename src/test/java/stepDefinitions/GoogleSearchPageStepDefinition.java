package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.GoogleSearchPage;

public class GoogleSearchPageStepDefinition {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("I am on the google.com page")
    public void openTheGooglePage() {
        googleSearchPage.openGoogleSearchPage();
    }

    @When("Enter {string} in the search field and click search button")
    public void enterWordInSearchFieldAndClickSearchButton(String searchWord) {
        googleSearchPage.searchFor(searchWord);
    }

}
