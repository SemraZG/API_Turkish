package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import techproed.testBase.HerOkuApp;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get07 extends HerOkuApp {
@Test
    public void get07(){
    spec02.pathParams("first", "booking", "second", 3);
    Response response=given().spec(spec02).
            accept(ContentType.JSON).when().get("/{first}/{second}");
            response.prettyPrint();

    JsonPath jsonPath=response.jsonPath();

 assertEquals("Mark", jsonPath.getString("firstname"));
    assertEquals("Jones", jsonPath.getString("lastname"));
   assertEquals(868, jsonPath.getInt("totalprice"));
    assertEquals(false, jsonPath.getBoolean("depositpaid"));
    assertEquals("2019-12-20", jsonPath.getString("bookingdates.checkin"));


}
}
