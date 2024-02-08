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

        String urlGet = "https://playground.learnqa.ru/api/get_auth_cookie";
        String urlCheck = "https://playground.learnqa.ru/api/check_auth_cookie";
        Response responseForGet = null;

        responseForGet = RestAssured
                .given()
                .body(data)
                .when()
                .post(urlGet)
                .andReturn();

        String responseCookie = responseForGet.getCookie("auth_cookie");
        Map<String, String> cookies = new HashMap<>();
        if (responseCookie != null) {
            cookies.put("auth_cookie", responseCookie);
        }

        Response responseForCheck = RestAssured
                .given()
                .body(data)
                .cookies(cookies)
                .when()
                .post(urlCheck)
                .andReturn();

        responseForCheck.print();
    }
}