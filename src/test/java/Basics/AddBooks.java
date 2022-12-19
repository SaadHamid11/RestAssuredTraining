package Basics;

import Payloads.AddBooksConstants;
import Utilities.JSONReaderUtils;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class AddBooks {

    @Test
    public void demoAddBookTesT(){

        RestAssured.baseURI="http://216.10.245.166";
        String response = given().contentType("application/json")
                .body(JSONReaderUtils.getJsonFromFile("C:\\Users\\shamid\\Documents\\payload.json"))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        System.out.println("Response: "+response);

        String id = JSONReaderUtils.getStringData(response, "ID");
        String message = JSONReaderUtils.getStringData(response, "Msg");

        System.out.println("ID: "+id);
        System.out.println("Message: "+message);


    }



    @DataProvider (name = "bookdata")
    public Object[][] getData(){
        Object[][] obj = new Object[2][4];

        obj[0][0] = "Test book 1";
        obj[0][1] = "Test216";
        obj[0][2] = 1369;
        obj[0][3] = "Test Author1";

        obj[1][0] = "Test book 2";
        obj[1][1] = "Test217";
        obj[1][2] = 1370;
        obj[1][3] = "Test Author2";


        return obj;
    }
}
