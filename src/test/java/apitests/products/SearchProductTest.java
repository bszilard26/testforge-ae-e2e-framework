package apitests.products;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("API – Products")
public class SearchProductTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://automationexercise.com/api";
    }

    @Test(description = "Search for a product using keyword")
    @Description("Sends a POST request to /searchProduct with a search term and validates the response")
    public void searchProductByKeyword() {
        String keyword = "Tshirt";

        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("search_product", keyword)
                .when()
                .post("/searchProduct")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200, "Expected HTTP 200 OK");
        Assert.assertTrue(response.asString().toLowerCase().contains(keyword.toLowerCase()),
                "Keyword '" + keyword + "' should be present in the response");
    }
}
