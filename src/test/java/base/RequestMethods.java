package base;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Payload;
import utils.PropertiesReader;

import java.io.FileNotFoundException;

public class RequestMethods {
    static Response response;
    RequestSpecification reqspec;
    PropertiesReader prop = new PropertiesReader();

    public Response performGETcall(String apiName) throws FileNotFoundException {
        APIResources resourceAPI= APIResources.valueOf(apiName);
        reqspec = new CoreRequestBuilder().reqSpecBuilder();

        //generating request
        switch (apiName)
        {
            case "GetBookingIds":System.out.println("Sending GET request to: "+resourceAPI.getResource()+" service");
                response = RestAssured.given().spec(reqspec).get(resourceAPI.getResource()).then().extract().response();
                break;

            case "GetBooking":System.out.println("Sending GET request to: "+resourceAPI.getResource(Payload.bookingId)+" service");
                response = RestAssured.given().spec(reqspec).header("Accept", "application/json")
                        .get(resourceAPI.getResource(Payload.bookingId)).then().extract().response();
                break;

            case "HealthCheck":System.out.println("Sending GET request to: "+resourceAPI.getResource()+" service");
                response = RestAssured.given().spec(reqspec).get(resourceAPI.getResource()).then().extract().response();
                break;
        }
        return response;
    }

    public Response performPOSTcall(String apiName) throws FileNotFoundException {
        APIResources resourceAPI= APIResources.valueOf(apiName);
        reqspec = new CoreRequestBuilder().reqSpecBuilder();

        switch (apiName)
        {
            case "CreateBooking":System.out.println("Sending POST request to: "+resourceAPI.getResource()+" service");
                reqspec = RestAssured.given().spec(reqspec).header("Accept", "application/json").body(Payload.createBooking);
                break;
        }
        response = reqspec.post(resourceAPI.getResource()).then().extract().response();
        return response;
    }


    public Response performPUTcall(String apiName) throws FileNotFoundException {
        APIResources resourceAPI= APIResources.valueOf(apiName);
        reqspec = new CoreRequestBuilder().reqSpecBuilder();

        switch (apiName)
        {
            case "UpdateBooking":System.out.println("Sending PUT request to: "+resourceAPI.getResource(Payload.bookingId)+" service");
                response = RestAssured.given().spec(reqspec).header("Accept", "application/json").cookie("token", Payload.authToken).body(Payload.updateBooking)
                        .put(resourceAPI.getResource(Payload.bookingId)).then().extract().response();
                break;

            case "UpdateBookingWithoutAuth":System.out.println("Sending PUT request to: "+resourceAPI.getResource(Payload.bookingId)+" service");
                response = RestAssured.given().spec(reqspec).header("Accept", "application/json").body(Payload.updateBooking)
                        .put(resourceAPI.getResource(Payload.bookingId)).then().extract().response();
                break;

        }
        return response;
    }

    public Response performPATCHcall(String apiName) throws FileNotFoundException {
        APIResources resourceAPI= APIResources.valueOf(apiName);
        reqspec = new CoreRequestBuilder().reqSpecBuilder();

        switch (apiName)
        {
            case "PartialUpdateBooking":System.out.println("Sending PUT request to: "+resourceAPI.getResource(Payload.bookingId)+" service");
                response = RestAssured.given().spec(reqspec).header("Accept", "application/json").cookie("token", Payload.authToken).body(Payload.partialUpdateBooking)
                        .patch(resourceAPI.getResource(Payload.bookingId)).then().extract().response();
                break;

        }
        return response;
    }

    public Response performDELETEcall(String apiName) throws FileNotFoundException {
        APIResources resourceAPI= APIResources.valueOf(apiName);
        reqspec = new CoreRequestBuilder().reqSpecBuilder();

        switch (apiName)
        {
            case "DeleteBooking":System.out.println("Sending DELETE request to: "+resourceAPI.getResource(Payload.deleteBookingId)+" service");
                response = RestAssured.given().spec(reqspec).cookie("token", Payload.authToken)
                        .delete(resourceAPI.getResource(Payload.deleteBookingId)).then().extract().response();
                break;

        }
        return response;
    }



}
