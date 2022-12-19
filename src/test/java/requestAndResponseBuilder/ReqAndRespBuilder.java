package requestAndResponseBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqAndRespBuilder {


    @Test
    public void TestReqAndResp(){

        AddPlace addPlace =  new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setAddress("Test Address 1568");
        addPlace.setLanguage("English");
        addPlace.setName("Test Place name1");
        addPlace.setPhone_number("989-989-7979");

        List<String> types = new ArrayList<String>();

        types.add("test type 1");
        types.add("test type 2");


        addPlace.setTypes(types);

        Location location1 = new Location();
        location1.setLat("-38.383494");
        location1.setLng("33.427362");

        addPlace.setLocation(location1);
        addPlace.setWebsite("http://google.com");

        RequestSpecification reqBuilder = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setContentType("Application/json")
                .addQueryParam("key","qaclick123")
                .build();

        ResponseSpecification respBuilder = new ResponseSpecBuilder().expectStatusCode(200)
                        .expectContentType("Application/json").build();

                RequestSpecification spec = given().log().all().spec(reqBuilder).body(addPlace);
                spec.when().post("/maps/api/place/add/json")
                .then().log().all().spec(respBuilder);






    }

}
