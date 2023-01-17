package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class Get03 {
    /*
        Given
                https://restful-booker.herokuapp.com/booking/3
            When
                User sends get request to the URL
            Then
                Status code is 200
              And
                  Among the data there should be someone whose firstname is "James" and lastname is "Brown"
         */
    @Test
    public void get03(){
        String url="https://restful-booker.herokuapp.com/booking/3";
        Response response= given().contentType(ContentType.JSON).when().get(url);
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname", equalTo("James"),
                        "lastname", equalTo("Brown"),
                        "totalprice", equalTo(111),"depositpaid", equalTo(true),
                "bookingdates.checkin", equalTo("2018-01-01"),
                "bookingdates.checkout", equalTo("2019-01-01"));
    }

}
