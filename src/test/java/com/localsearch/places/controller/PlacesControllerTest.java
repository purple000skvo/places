package com.localsearch.places.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlacesControllerTest {

    public static final String REST_PATH = "/places";
    public static final String[] VALID_PLACE_IDS = {"GXvPAor1ifNfpF0U5PTG0w", "ohGSnJtMIC5nPfYRi_HTAg"};
    public static final String INVALID_PLACE_ID = "test";

    @Test
    public void validate_retrieval_data_for_valid_placeId() {

        get(REST_PATH + "/" + VALID_PLACE_IDS[0])
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Casa Ferlin"))
                .body("address", equalTo("Stampfenbachstrasse 38, 8006 Zürich"))
                .body("opening_hours.monday.get(0).start", equalTo("11:30"))
                .body("opening_hours.tuesday.get(0).end", equalTo("14:00"))
                .body("opening_hours.wednesday.get(1).type", equalTo("OPEN"))
                .body("opening_hours.friday.get(1).start", equalTo("22:00"));
    }

    @Test
    public void not_found_on_InvalidPlaceId() {
        get(REST_PATH + "/" + INVALID_PLACE_ID)
                .then()
                .statusCode(404);

    }
}
