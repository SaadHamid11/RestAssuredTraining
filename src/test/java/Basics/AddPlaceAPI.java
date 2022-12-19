package Basics;

import Payloads.AddPlaceConstants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPlaceAPI {
    private String placeId = "";

    @Test(priority = 1)
    public void addPlaceTest(){
        RestAssured.baseURI = "https://rahulshettyacademy.com";

                String response = given().log().all()
                .queryParam("key" ,"qaclick123")
                .contentType("application/json")
                .body(AddPlaceConstants.getAddPlacePayload()).
                        when()
                .post("/maps/api/place/add/json").then().assertThat().statusCode(200)
                        .extract().response().asString();


        System.out.println("Response: "+response);

        JsonPath js = new JsonPath(response);
        placeId =  js.getString("place_id");

        System.out.println("Place ID: "+placeId);






    }


    @Test (priority = 2)
    public void updatedPlaceTest(){
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key" ,"qaclick123").contentType("application/json").body(AddPlaceConstants.getUpdatePlacePayload(placeId))
                .when().put("maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
    }


    @Test(priority = 3)
    public void getPlaceTest(){
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String getResponse =given().log().all().queryParam("key" ,"qaclick123").queryParam("place_id",placeId)
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        System.out.println(getResponse);

        JsonPath js = new JsonPath(getResponse);
        String address = js.getString("address");

        System.out.println("Address: "+address);

        Assert.assertEquals(address,"80 winter walk, USA");
    }
}
