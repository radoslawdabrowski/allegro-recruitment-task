package pl.allegro.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.ResourceAccessException;
import pl.allegro.utils.constraints.Github;

import static com.jayway.restassured.RestAssured.given;


@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTests {

    @LocalServerPort
    int randomServerPort;

    /**
     * if github repository gives {@link HttpStatus#INTERNAL_SERVER_ERROR} then i expect from my service to return response with status {@link HttpStatus#NOT_FOUND}
     */
    @Test
    public void repository_500() {
        if(given().when().get(String.format(Github.REPOS, "radoslawdabrowski", "g-leaflet-draw")).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            given().when().get(String.format("http://localhost:%s/repositories/%s/%s", randomServerPort, "radoslawdabrowski", "spring-boot-example")).then().statusCode(HttpStatus.NOT_FOUND.value());
        }
    }

    /**
     * if github timeout, I expect from my app to return returns response with status {@link HttpStatus#NOT_FOUND}
     */
    @Test
    public void repository_github_timeout() {
        try {
            given().when().get(String.format(Github.REPOS, "radoslawdabrowski", "g-leaflet-draw"));
        } catch (ResourceAccessException ex) {
            given().when().get(String.format("http://localhost:%s/repositories/%s/%s", randomServerPort, "radoslawdabrowski", "spring-boot-example")).then().statusCode(HttpStatus.NOT_FOUND.value());
        }
    }

}
