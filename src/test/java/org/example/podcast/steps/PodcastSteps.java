package org.example.podcast.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PodcastSteps {
    private final RequestSpecBuilder requestSpec;
    List<Object> seasons;
    private String somethinWasWrongShow;
    private String id;
    private Response response;

    public PodcastSteps() {
        requestSpec = new RequestSpecBuilder().setBaseUri("https://podcast-api.netlify.app/");
    }

    @Given("the user searches for all podcasts")
    public void theUserSearchesForAllPodcasts() {
        response = given().spec(requestSpec.build()).get("shows");
        somethinWasWrongShow = response.getBody().jsonPath().getString("[0]");
    }

    @When("the user gets the show's details")
    public void theUserGetsTheShowSDetails() {
        id = response.getBody().jsonPath().getString("[0].id");
        response = given().spec(requestSpec.build()).get("id/"+id);
    }

    @Then("season {string} has {string} episodes")
    public void seasonHasEpisodes(String noOfEpisodes, String expectedNoOfEpisodes) {
        int seasonIndex = Integer.parseInt(noOfEpisodes)-1;
        seasons = response.getBody().jsonPath().getList("seasons.episodes");
        List<Object> episodes = (List<Object>) seasons.get(seasonIndex);

        assertEquals(episodes.size(), Integer.parseInt(expectedNoOfEpisodes));
    }

    @Then("Season {string} episode {string} title is {string}")
    public void seasonEpisodeTitleIs(String arg0, String arg1, String arg2) {

    }
}