package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import utils.PropertiesReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CoreRequestBuilder {
    PropertiesReader prop = new PropertiesReader();
    RequestSpecBuilder builder;
    RequestSpecification reqspec;
    PrintStream log;

    public RequestSpecification reqSpecBuilder() throws FileNotFoundException {
        //Creating request skeleton with base url
        builder = new RequestSpecBuilder();
        builder.setBaseUri(prop.getPropValue("APIBaseURI"));
        builder.setContentType("application/json");
        log = new PrintStream(new FileOutputStream("log.txt", true));
        builder.addFilter(RequestLoggingFilter.logRequestTo(log));
        builder.addFilter(ResponseLoggingFilter.logResponseTo(log));
        reqspec =  builder.build();
        return reqspec;
    }
}
