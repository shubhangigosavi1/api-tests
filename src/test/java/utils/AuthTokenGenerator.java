package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthTokenGenerator {

    static PropertiesReader prop = new PropertiesReader();
    private static String authToken;

    //Read username and password from property file
    static String username = prop.getPropValue("username");
    static String password = prop.getPropValue("password");

    public static String generateAuthToken() {

        //Set base URL
        RestAssured.baseURI = prop.getPropValue("APIBaseURI");

        // Create JSON body using the properties
        String body = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/auth");

        authToken = response.jsonPath().getString("token");
        return authToken;
    }
}




