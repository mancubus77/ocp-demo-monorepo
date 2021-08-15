package org.acme.rest.json;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class WhoamiTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/v1/whoami")
          .then()
             .statusCode(200)
             .body(is("{\"app\":\"Quarkus\",\"message\":\"I \\uD83D\\uDC95 Quarkus!!!\"}"));
    }

}