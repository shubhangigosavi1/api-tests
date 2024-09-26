package stepdefs;

import base.RequestMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import resources.Payload;
import utils.PropertiesReader;
import utils.Utilities;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;


public class BookingSteps extends RequestMethods {

    private Response response;
    private PropertiesReader prop = new PropertiesReader();

    @When("{string} API is called with {string} request")
    public void api_is_called_with_request(String apiName, String requestType) throws FileNotFoundException {

        if(requestType.equalsIgnoreCase("POST"))
        {
            response = performPOSTcall(apiName);
        }
        else if(requestType.equalsIgnoreCase("GET"))
        {
			response = performGETcall(apiName);
        }
        else if(requestType.equalsIgnoreCase("PUT"))
        {
            response = performPUTcall(apiName);
        }
        else if(requestType.equalsIgnoreCase("PATCH"))
        {
            response = performPATCHcall(apiName);
        }
        else if(requestType.equalsIgnoreCase("DELETE"))
        {
            response = performDELETEcall(apiName);
        }
    }

    @Given("invalid booking ID")
    public void invalidBookingId() {
        Payload.bookingId = Payload.invalidBookingId;// Set this to an invalid booking ID
    }

    @And("atleast one bookingId is present in the response body")
    public void atleastOneBookingIdIsPresentInTheResponseBody() {
        JsonPath js = Utilities.rawToJson(response);
        //Retrive first booking id
        Assert.assertNotNull(js.get("[0].bookingid"));

        //store first booking to delete it later
        Payload.deleteBookingId=(js.get("[0].bookingid")).toString();
    }

    @Then("Status code is {int}")
    public void statusCodeIs(int expectedStatusCode) {
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
    }

    @And("response body is not null")
    public void responseBodyIsNotNull() {
        JsonPath js = Utilities.rawToJson(response);
        Assert.assertNotNull(js);
    }

    @Given("invalid create booking payload")
    public void invalidCreateBookingPayload() {
        Payload.createBooking = Payload.invalidCreateBooking;// invalid create booking payload
    }

    @And("response body should contain the message {string}")
    public void responseBodyErrorMessage(String expectedMessage) {
        Assert.assertEquals(response.body().asString(), expectedMessage);
    }
}
