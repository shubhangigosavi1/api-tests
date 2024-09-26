package resources;

import utils.AuthTokenGenerator;

public class Payload {

    public static String authToken= AuthTokenGenerator.generateAuthToken();
    public static String bookingId=Integer.toString(7);
    public static String deleteBookingId;
    public static String invalidBookingId=Integer.toString(0);

    public static String createBooking = "{\n" +
            "    \"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    public static String invalidCreateBooking = "{\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111\n" +
            "}";

    public static String updateBooking ="{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    public static String partialUpdateBooking ="{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\"\n" +
            "}";
}
