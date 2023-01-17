package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Get02 {
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
*/
    @Test
    public void get02(){
     String url ="https://restful-booker.herokuapp.com/booking/1";
      Response response= given().contentType(ContentType.JSON).when().get(url);
      response.prettyPrint();
      response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
      assertTrue(response.asString().contains("Not Found"));
      assertFalse(response.asString().contains("TechProEd"));
      assertEquals("Cowboy", response.getHeader("Server"));

      assertFalse(response.asString().contains("api"));
      assertEquals("1.1 vegur", response.getHeader("Via"));
    }
}
