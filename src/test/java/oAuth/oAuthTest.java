package oAuth;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class oAuthTest {

    private String authToken = "";
    private int userId = 3811;


  /* @Test
    public void testApI(){
               Response resp =  RestAssured
               .given()
               .formParam("client_id","TestApplication112")
               .formParam("client_secret","9988dca4f09e717e4203087f47ba19b2")
               .formParam("grant_type","client_credentials")
               .post("http://coop.apps.symfonycasts.com/token");

       String token = resp.jsonPath().getString("access_token");





       RestAssured.baseURI = "http://coop.apps.symfonycasts.com/";

       Response resp1 = RestAssured.given().auth().oauth2(token).post("/api/3811/chickens-feed");

       Assert.assertEquals(resp1.getStatusCode(),200);

       System.out.println("Code :"+resp1.getBody().asString());
   }

   */


   @BeforeTest
    public void initAuthToken(){

      Response res =  RestAssured.given()
               .formParams("client_id","SaadApplication112")
               .formParams("client_secret","498b35b90c5ee57ec4d3454efeb853e1")
               .formParams("grant_type","client_credentials")
               .when().post("http://coop.apps.symfonycasts.com/token");

        authToken = res.jsonPath().getString("access_token");

       System.out.println("token: "+authToken);



   }



   @Test
    public void validAccessOfAPI(){
        RestAssured.baseURI = "http://coop.apps.symfonycasts.com/";
       Response resp = RestAssured.given()
               .auth()
               .oauth2(authToken)
               .when()
               .post("/api/3811/eggs-count");

       System.out.println(resp.jsonPath().prettify());
       Assert.assertEquals(resp.getStatusCode(), 200);

   }





}
