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

        Map<String, String> data = new HashMap<>();
        data.put("login", "secret_login");
        data.put("password", "secret_pass");

        String url = "https://playground.learnqa.ru/api/get_auth_cookie";
        Response response = null;

        response = RestAssured
                .given()
                .body(data)
                .when()
                .post(url)
                .andReturn();

        System.out.println("\nPretty text:");
        response.prettyPrint();

        System.out.println("\nheaders:");
        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);

        System.out.println("\ncookies:");
        Map <String, String> responseCookies = response.getCookies();
        System.out.println(responseCookies);
    }
}