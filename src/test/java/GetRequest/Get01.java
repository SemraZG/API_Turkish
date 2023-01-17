package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
       /*
   Given
       https://restful-booker.herokuapp.com/booking/101
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be application/json
   And
       Status Line should be HTTP/1.1 200 OK
*/
    /*

    1) ilk olarak endpoint belirlenir,
    2) expected data oluşturulur,
    3) request(get, post, put, patch or delete) gönderilir,
    4) response alınır ve actual result oluşturulur,
    5) Assertion yapılır.

     */
    @Test
    public void get01(){


    //1) ilk olarak endpoint belirlenmeli,
        String url ="https://restful-booker.herokuapp.com/booking/3";
    //3) request(get, post, put, patch or delete) gönderilir,
        Response response= given().accept("application/json").when().get(url);
        response.prettyPrint();
    //5) Assertion yapılır.
        System.out.println( response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getStatusLine());

       response.
               then().
               assertThat().
               statusCode(200).
               contentType(ContentType.JSON).
               statusLine("HTTP/1.1 200 OK");

    }
}
