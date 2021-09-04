package helpers;

import config.Credentials;

import static io.restassured.RestAssured.given;

public class Browserstack {
    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(Credentials.credentials.bs_login(), Credentials.credentials.bs_password())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");

    }
}
