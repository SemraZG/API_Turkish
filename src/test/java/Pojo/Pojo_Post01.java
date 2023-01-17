package Pojo;

import Pojo_Test_Base.todos_pojo_class_pojo01;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import techproed.testBase.JsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Pojo_Post01 extends JsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/todos url e bir request gönderildiğinde request body
    {
    "userId": 21,
        "id": 201,
        "title": "Tidy your room",
        "completed": false
        }
        status codun 201, ve response body nin ise
{
    "userId": 21,
        "id": 201,
        "title": "Tidy my room",
        "completed": false
        }
        olduğunu test edin.

     */
    @Test
    public void post(){
        spec.pathParam("first", "todos");

        todos_pojo_class_pojo01 requestAndExpectedData=new todos_pojo_class_pojo01(21, 201, "Tidy my room", false );

        System.out.println(requestAndExpectedData);//todos_pojo{userId=21, id=201, title='Tidy your room', completed=false}

        Response response= given().accept(ContentType.JSON).spec(spec).
                auth().basic("admin", "password123").
                body(requestAndExpectedData).
                when().
                post("/{first}");

        response.prettyPrint();

        //De-Serilization

        todos_pojo_class_pojo01 actualData=response.as(todos_pojo_class_pojo01.class);
        assertEquals(201, response.getStatusCode());
        assertEquals(requestAndExpectedData.getId(), actualData.getId());
        assertEquals(requestAndExpectedData.getTitle(), actualData.getTitle());
        assertEquals(requestAndExpectedData.getUserId(), actualData.getUserId());

    }

}
