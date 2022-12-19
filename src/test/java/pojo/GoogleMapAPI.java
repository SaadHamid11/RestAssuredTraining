package pojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GoogleMapAPI {


    @Test
    public void addPlaceAPITest(){

        AddPlace addPlace =  new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setAddress("Test Address 1234");
        addPlace.setLanguage("English");
        addPlace.setName("Test Place name");
        addPlace.setPhone_number("989-989-7878");

        List<String> types = new ArrayList<String>();

        types.add("test type 1");
        types.add("test type 2");


        addPlace.setTypes(types);

        Location location1 = new Location();
        location1.setLat("-38.383494");
        location1.setLng("33.427362");

        addPlace.setLocation(location1);
addPlace.setWebsite("http://google.com");

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        Response response = given().log().all()
                .queryParams("key","qaclick123")
                .body(addPlace)
                .when()
                .post("/maps/api/place/add/json");

        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println(response.jsonPath().prettify());

        AddPlaceResponse addPlaceResponse = response.as(AddPlaceResponse.class);

        System.out.println("ID: "+addPlaceResponse.getId());














    }
}
