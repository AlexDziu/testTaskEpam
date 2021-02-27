package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleSearchPage;

public class GoogleSearchPageStepDefinition {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("I am on the google.com page")
    public void i_am_on_the_google_com_page() {
        googleSearchPage.openGoogleSearchPage();
    }

    @When("I enter {string} in the search field and click search button")
    public void i_enter_in_the_search_field_and_click_search_button(String searchWord) {
        googleSearchPage.searchFor(searchWord);
    }

    @Then("I check that title contains search word")
    public void i_check_that_title_contains_search_word() {

    }
}
