package requests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;

public class Authentication {

    @Test
    public void authentication() {

        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        RequestSpecification request = RestAssured.given();

        String credentials = "TOOLSQA-Test:Test@123";

        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());

        String encodedCredentialsAsString = new String(encodedCredentials);

        request.header("Authentication","Basic "+encodedCredentialsAsString);
    }
}
