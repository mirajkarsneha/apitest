package requests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.awt.desktop.SystemHotkey;

public class GETRequest {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/BookStore/v1/Books");

        int statusCode = response.getStatusCode();
        //System.out.println("Response status code is "+statusCode);
        Assertions.assertEquals(200, statusCode);

        Headers header = response.getHeaders();
        //System.out.println("Response Headers are "+header);
        int countOfHeaders = header.asList().size();
        Assertions.assertEquals(7, countOfHeaders);

        String headerValue = response.getHeader("Content-Type");
        Assertions.assertEquals("application/json; charset=utf-8", headerValue);

        String responseBodyAsString = response.getBody().asString();
        Assertions.assertTrue(responseBodyAsString.contains("Git Pocket Guide"));
        //body.prettyPrint();
        //System.out.println("Response body is "+body.prettyPrint());

    }
}
