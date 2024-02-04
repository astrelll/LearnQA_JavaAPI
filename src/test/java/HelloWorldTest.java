import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.http.Headers;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class HelloWorldTest {

    @Test
    public void testRestAssured() {

        int statusCode = 300;
        int amountOfRedirects = 0;
        Map<String, String> headers = new HashMap<>();
        String urlRedirects = "https://playground.learnqa.ru/api/long_redirect";
        Response response = null;

        while (statusCode != 200) {
            response = RestAssured
                    .given()
                    .headers(headers)
                    .redirects()
                    .follow(false)
                    .when()
                    .get(urlRedirects)
                    .andReturn();

            urlRedirects = response.getHeader("Location");
            statusCode = response.getStatusCode();
            amountOfRedirects += 1;
        }

        System.out.println("Количество редиректов: " + amountOfRedirects);
    }
}