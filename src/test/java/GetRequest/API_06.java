package GetRequest;

import TestData.AutomationPracticeTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import techproed.testBase.AutomationPractice;



import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class API_06 extends AutomationPractice {
    /*
    {
    "name": "Regular fit jeans",
    "price": 13500,
    "size":46

}
     */

    @Test
    public void  post06() {

        spec.pathParam("first", "searchProduct");


        AutomationPracticeTestData obj = new AutomationPracticeTestData();
        JSONObject expectedData = obj.setUpExpectedBody();
        JSONObject requestData = obj.setUpRequestBody();


        Response response = given().spec(spec).accept(ContentType.JSON).
                body(requestData.toString()).
                auth().basic("admin", "password1233").
                when().post("/{first}");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        assertEquals(expectedData.get("statusCode"), jsonPath.getInt("statusCode"));
        assertEquals(expectedData.get("responseCode"), jsonPath.getInt("responseCode"));
        assertEquals(expectedData.get("message"), jsonPath.getString("message"));

    }
}
