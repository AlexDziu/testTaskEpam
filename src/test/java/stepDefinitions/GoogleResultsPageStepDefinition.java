package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleResultsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleResultsPageStepDefinition {
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();

    @Then("Check that title contains {string} word")
    public void verifyThatTitleContainsSearchWord(String expectedTitle) {
        assertThat(googleResultsPage.getTitle()).containsIgnoringCase(expectedTitle);
    }

    @When("Open first result page")
    public void clickOnFirstResultPage() {
        googleResultsPage.clickOnFirstPage();
    }

    @Then("Check that expected domain {string} on search {int} results pages")
    public void verifyThatSearchResultContainsDomainName(String expectedDomain, int numberOfPages) {
        assertThat(googleResultsPage.domainNameIsPresent(expectedDomain, numberOfPages))
                .as(String.format("not found expected domain: %s", expectedDomain)).isTrue();
    }
}
