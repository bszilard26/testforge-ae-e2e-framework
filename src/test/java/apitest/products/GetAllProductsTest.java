package apitest.products;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("API – Products")
public class GetAllProductsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://automationexercise.com/api";
    }

    @Test(description = "Verify that all products are returned from the API")
    @Description("Sends a GET request to /productsList and checks the response status and content")
    public void getAllProducts() {
        Response response = given()
                .when()
                .get("/productsList")
                .then()
                .extract()
                .response();

        System.out.println("[RESPONSE] " + response.asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected HTTP 200 OK");
        Assert.assertTrue(response.asString().contains("products"), "Response should contain 'products'");
    }
}
