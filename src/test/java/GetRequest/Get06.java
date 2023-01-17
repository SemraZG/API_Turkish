package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import techproed.testBase.JsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get06 extends JsonPlaceHolder {
    @Test
    public void get06(){
        //1.way
        /*String url= "https://jsonplaceholder.typicode.com/todos/123";
        Response response= given().contentType(ContentType.JSON).when().get(url);
        response.prettyPrint();
        */

        //2.way
        spec.pathParams("first", "todos", "second", 123);
        Response response= given().spec(spec).accept(ContentType.JSON).when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                header("Server", equalTo("cloudflare")).
                body("userId", equalTo(7),"title", equalTo("esse et quis iste est earum aut impedit"));

    }
}
