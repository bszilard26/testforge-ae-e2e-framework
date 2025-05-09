package apitest.products;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Test class for testing product search functionality via API endpoints.
 * Uses Allure reporting and TestNG framework for test execution.
 */
@Feature("API – Products")
public class SearchProductTest {

    /**
     * Setup method that runs before all test methods in this class.
     * Configures the base URI for REST Assured API calls.
     */
    @BeforeClass
    public void setup() {
        // Set the base URI for all API requests in this test class
        RestAssured.baseURI = "https://automationexercise.com/api";
    }

    /**
     * Test method to verify product search functionality.
     * Sends a POST request to search for products and validates the response.
     */
    @Test(description = "Search for a product using keyword")
    @Description("Sends a POST request to /searchProduct with a search term and validates the response")
    public void searchProductByKeyword() {
        // Define the search keyword for the product search
        String keyword = "Tshirt";

        // Build and execute the API request
        Response response = given()
                .contentType(ContentType.URLENC) // Set content type to URL encoded form data
                .formParam("search_product", keyword) // Add search parameter as form data
                .when()
                .post("/searchProduct") // Send POST request to the search endpoint
                .then()
                .extract()
                .response(); // Extract the response for further validation

        // Log the response body for debugging purposes
        System.out.println("[RESPONSE] " + response.asString());

        // Verify that the API returns HTTP 200 status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected HTTP 200 OK");

        // Verify that the response contains the searched keyword (case-insensitive)
        Assert.assertTrue(response.asString().toLowerCase().contains(keyword.toLowerCase()),
                "Expected keyword '" + keyword + "' to be in the response");
    }
}
