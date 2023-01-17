package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import javax.sql.rowset.spi.SyncResolver;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get05 {
 /*
       Given
           https://jsonplaceholder.typicode.com/todos/23
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
       And
           “completed” is false
       And
           “userId” is 2
    */
    @Test
    public void get05(){
        String url= "https://jsonplaceholder.typicode.com/todos/23";
        Response response= given().contentType(ContentType.JSON).when().get(url);
        response.prettyPrint();
        response.then().assertThat().contentType(ContentType.JSON).statusCode(200).
                body("completed", equalTo(false), "title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"));
    }
}
