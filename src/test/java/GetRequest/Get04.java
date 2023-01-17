package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get04 {

     /*
   Given
       https://restful-booker.herokuapp.com/booking/1
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "TechProEd"
   And
       Server is "Cowboy"
        "firstname": "Richard",
    "lastname": "Roe",
    "totalprice": 150,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-09-25",
        "checkout": "2018-09-30"
    },
    "additionalneeds": "Breakfast"
*/

@Test
    public void get04(){
    String url="https://restful-booker.herokuapp.com/booking/4";
    Response response= given().contentType(ContentType.JSON).when().get(url);
    response.prettyPrint();
    response.
            then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            body("firstname", equalTo("Richard"), "totalprice", equalTo(150), "bookingdates.checkin", equalTo("2018-09-25"));
    assertEquals("Cowboy", response.getHeader("Server"));
    assertTrue(response.asString().contains("Breakfast"));
}
}
