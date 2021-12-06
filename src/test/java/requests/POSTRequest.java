package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class POSTRequest {

    @Test
    public void createUserTest() {

        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        String payload = "{\n" +
                "  \"userName\": \"POST_Request102\",\n" +
                "  \"password\": \"POSTRequest@123\"\n" +
                "}";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type", "application/json");

        Response response = httpRequest.body(payload).post("/Account/v1/User");

        int statusCode = response.getStatusCode();
        System.out.println("Response code is "+statusCode);
    }
}
