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

        Map<String, String> headers = new HashMap<>();
        headers.put("MyHeaders1", "MyValue1");
        headers.put("MyHeaders2", "MyValue2");

        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/get_303")
                .andReturn();

        response.prettyPrint();

        String locationHeader = response.getHeader("Location");
        System.out.println(locationHeader);
    }
}