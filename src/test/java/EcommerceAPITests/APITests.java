package EcommerceAPITests;

import EcommerceAPITests.Pojo.*;
import EcommerceAPITests.specBuilders.EcommerceSpecBuilder;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class APITests {
        EcommerceSpecBuilder spec = new EcommerceSpecBuilder();
        Login login = new Login();
        String userId = "";

        String token = "";
        String productAddResponse = "";

    @Test(priority = 1)
    public void loginTest(){
        RequestSpecification specs = spec.requestBuilder("https://rahulshettyacademy.com");
        login.setUserEmail("sheikhsaadhamid1@gmail.com");
        login.setUserPassword("Test_1234");
        RequestSpecification req = RestAssured.given().spec(specs).body(login);
        Response resp = req.when().post("/api/ecom/auth/login");
        LoginResponse loginResp = resp.then().extract().response().as(LoginResponse.class);
        token = loginResp.getToken();
        userId = loginResp.getUserId();
        System.out.println("Token: "+token);
    }

    @Test(priority = 2)
     public void addProduct(){
        RequestSpecification  specs = spec.productRequestBuilder("https://rahulshettyacademy.com", token);
        RequestSpecification request = RestAssured.given().log().all().spec(specs)
                .formParam("productName","TestProduct12343")
                .formParam("productAddedBy", userId)
                .formParam("productCategory","fashion")
                .formParam("productSubCategory","shirts")
                .formParam("productPrice","2500")
                .formParam("productDescription", "Nike Gymware")
                .formParam("productFor", "Men")
                .multiPart("productImage", new File("C:\\Users\\shamid\\Pictures\\Saved Pictures\\images.jpg"));


        Response resp = request.when().post("/api/ecom/product/add-product");
        CreateProductResponse productResponse = resp.then().extract().response().as(CreateProductResponse.class);
        System.out.println(productResponse.getProductId());
        productAddResponse = productResponse.getProductId();
    }

@Test(priority = 3)
    public void createOrder(){
    RequestSpecification  specs = spec.addToCartRequestBuilder("https://rahulshettyacademy.com", token);
    Product product = new Product();
    product.setProductAddedBy(userId);
    product.setProductCategory("fashion");
    product.setProductSubCategory("shirts");
    product.setProductPrice("2500");
    product.setProductDescription("Nike Gym ware");
    product.setProductFor("Men");
    product.setProductImage("C:\\Users\\shamid\\Pictures\\Saved Pictures\\images.jpg");
    product.set_id(productAddResponse);


    AddToCart addCart = new AddToCart();
    addCart.setProduct(product);
    addCart.setCountry(productAddResponse);





    RequestSpecification req = RestAssured.given().spec(specs).body(addCart);
    Response  response = req.when().post("/api/ecom/user/add-to-cart");
    String result = response.then().extract().response().jsonPath().prettify();
    System.out.println(result);



}



}
