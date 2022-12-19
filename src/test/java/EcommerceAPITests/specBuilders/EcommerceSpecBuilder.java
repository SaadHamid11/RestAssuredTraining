package EcommerceAPITests.specBuilders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EcommerceSpecBuilder {


    public RequestSpecification requestBuilder(String baseUri){

        RequestSpecification request = new RequestSpecBuilder().setBaseUri(baseUri).setContentType(ContentType.JSON).build();
        return request;

    }


    public RequestSpecification productRequestBuilder(String baseUri, String authorization){
        RequestSpecification  request = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .addHeader("authorization", authorization)
                .build();

        return request;

    }

    public RequestSpecification addToCartRequestBuilder(String baseUri, String authorization){
        RequestSpecification  request = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .addHeader("authorization", authorization)
                .build();

        return request;

    }



}
